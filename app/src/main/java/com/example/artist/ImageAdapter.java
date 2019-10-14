package com.example.artist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    ImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return ViewPhotos.imagelist.size();

    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public View getView(int i, View arg1, ViewGroup arg2) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(500,500));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(10, 10, 10, 10);
        //imageView.setImageResource(TestBitmap.splittedImages.get(arg0));
        imageView.setImageBitmap(ViewPhotos.imagelist.get(i));
        return imageView;
    }
}
