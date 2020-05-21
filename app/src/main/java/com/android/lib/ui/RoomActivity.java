package com.android.lib.ui;

import android.view.View;

import com.android.baselib.ui.BaseActivity;
import com.android.lib.R;
import com.android.lib.databinding.ActivityRoomBinding;
import com.android.lib.room.Word;
import com.android.lib.room.WordViewModel;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;

public class RoomActivity extends BaseActivity<ActivityRoomBinding,WordViewModel> {


    @Override
    protected Class<? extends AndroidViewModel> getViewModel() {
        return WordViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_room;
    }

    @Override
    protected void initViewsAndEvents() {

        mViewModel.getAllWordsLive().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                StringBuilder text = new StringBuilder();
                for(int i=0;i<words.size();i++) {
                    Word word = words.get(i);
                    text.append(word.getId()).append(":").append(word.getWord()).append("=").append(word.getChineseMeaning()).append("\n");
                }
                mBinding.textView.setText(text.toString());
            }
        });
        mBinding.buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word1 = new Word("Hello","你好！");
                Word word2 = new Word("World","世界！");
                mViewModel.insertWords(word1,word2);
            }
        });
        mBinding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.deleteAllWords();
            }
        });

        mBinding.buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("Hi","你好啊!");
                word.setId(90);
                mViewModel.updateWords(word);
            }
        });

        mBinding.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("Hi","你好啊!");
                word.setId(90);
                mViewModel.deleteWords(word);
            }
        });
    }

}
