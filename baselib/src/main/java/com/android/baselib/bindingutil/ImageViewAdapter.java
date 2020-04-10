package com.android.baselib.bindingutil;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

/**
 * Author: WangHao
 * Created On: 2020/04/09  16:36
 * Description: dataBinding绑定image必须的适配器
 */
public class ImageViewAdapter {

    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, Bitmap bitmap) {
        view.setImageBitmap(bitmap);
    }


    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, int resId) {
        view.setImageResource(resId);
    }


    @BindingAdapter("imageUrl")
    public static void setSrc(ImageView imageView, String url) {
//        Glide.with(imageView.getContext()).load(url)
//            .placeholder(R.mipmap.ic_launcher)
//            .into(imageView);
    }


    @BindingAdapter({"app:imageUrl", "app:placeHolder", "app:error"})
    public static void loadImage(ImageView imageView, String url, Drawable holderDrawable, Drawable errorDrawable) {
//        Glide.with(imageView.getContext())
//            .load(url)
//            .placeholder(holderDrawable)
//            .error(errorDrawable)
//            .into(imageView);
    }
}
