package com.android.lib.observer;

import android.content.Context;

import java.util.logging.Handler;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * Author: WangHao
 * Created On: 2020/05/15  14:02
 * Description:
 */
public class UploadWorker extends Worker {


    public UploadWorker(@NonNull Context context,
        @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        String inputData = getInputData().getString("input_data");
        Data data =new Data.Builder().putString("output_data",inputData+"!!!").build();

        return Result.success(data);
    }
}
