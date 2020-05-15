package com.android.lib.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.paging.PositionalDataSource;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.baselib.ui.BaseActivity;
import com.android.lib.R;
import com.android.lib.databinding.ActivityPageListBinding;

import java.util.ArrayList;
import java.util.List;

public class PageListActivity extends BaseActivity<ActivityPageListBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_page_list;
    }

    @Override
    protected void initViewsAndEvents() {
        final MyAdapter mAdapter = new MyAdapter();
        PagedList.Config config = new PagedList.Config.Builder()
            .setPageSize(10)                         //配置分页加载的数量
            .setEnablePlaceholders(false)     //配置是否启动PlaceHolders
            .setInitialLoadSizeHint(10)              //初始化加载的数量
            .build();
        /**
         * LiveData<PagedList<DataBean>> 用LivePagedListBuilder生成
         * LivePagedListBuilder 用 DataSource.Factory<Integer,DataBean> 和PagedList.Config.Builder 生成
         * DataSource.Factory<Integer,DataBean> 用 PositionalDataSource<DataBean>
         */
        LiveData<PagedList<DataBean>>
            liveData = new LivePagedListBuilder(new MyDataSourceFactory(), config)
            //                .setBoundaryCallback(null)
            //                .setFetchExecutor(null)
            .build();
        liveData.observe(this,new Observer<PagedList<DataBean>>() {
            @Override
            public void onChanged(@Nullable PagedList<DataBean> dataBeans) {
                mAdapter.submitList(dataBeans);
            }
        });
        RecyclerView mRecyclerView = findViewById(R.id.mRecyclerView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }


    private class DataBean {
        public int id;
        public String content;
    }

    private class MyDataSourceFactory extends DataSource.Factory<Integer,DataBean>{
        @Override
        public DataSource<Integer, DataBean> create() {
            return new MyDataSource();
        }
    }

    private class MyDataSource extends PositionalDataSource<DataBean> {

        @Override
        public void loadInitial(@NonNull LoadInitialParams params,@NonNull LoadInitialCallback<DataBean> callback) {
            callback.onResult(loadData(0, 10),0,10);
        }

        @Override
        public void loadRange(@NonNull PositionalDataSource.LoadRangeParams params
            ,@NonNull LoadRangeCallback<DataBean> callback) {
            callback.onResult(loadData(params.startPosition, 10));
        }

    }

    /**
     * 假设这里需要做一些后台线程的数据加载任务。
     *
     * @param startPosition
     * @param count
     * @return
     */
    private List<DataBean> loadData(int startPosition,int count) {
        List<DataBean> list = new ArrayList();

        for (int i = 0; i < count; i++) {
            DataBean data = new DataBean();
            data.id = startPosition + i;
            data.content = "测试的内容=" + data.id;
            list.add(data);
        }

        return list;
    }

    private class MyAdapter extends PagedListAdapter<DataBean, MyViewHolder> {
        public MyAdapter() {
            super(mDiffCallback);
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
            View view = LayoutInflater
                .from(getApplicationContext()).inflate(android.R.layout.simple_list_item_2,null);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder,int position) {
            DataBean data = getItem(position);
            holder.text1.setText(String.valueOf(position));
            holder.text2.setText(String.valueOf(data.content));
        }
    }

    private DiffUtil.ItemCallback<DataBean> mDiffCallback = new DiffUtil.ItemCallback<DataBean>() {
        @Override
        public boolean areItemsTheSame(@NonNull DataBean oldItem,@NonNull DataBean newItem) {
            Log.d("DiffCallback","areItemsTheSame");
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull DataBean oldItem,@NonNull DataBean newItem) {
            Log.d("DiffCallback","areContentsTheSame");
            return (oldItem == newItem);
        }
    };

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text1;
        public TextView text2;

        public MyViewHolder(View itemView) {
            super(itemView);

            text1 = itemView.findViewById(android.R.id.text1);
            text1.setTextColor(Color.RED);

            text2 = itemView.findViewById(android.R.id.text2);
            text2.setTextColor(Color.BLUE);
        }
    }

    @Override
    protected AndroidViewModel initViewModel() {
        return null;
    }
}
