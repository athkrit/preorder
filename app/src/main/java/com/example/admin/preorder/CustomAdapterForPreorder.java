package com.example.admin.preorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterForPreorder extends BaseAdapter {
    Context mContext;
    ArrayList<String> fruitname;
    public CustomAdapterForPreorder(Context context, ArrayList<String> fruitname){
        this.fruitname = fruitname;
        this.mContext = context;
    }
    @Override
    public int getCount() {
        return fruitname.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = mInflater.inflate(R.layout.listday, parent, false);
        final ImageView imageView = (ImageView)view.findViewById(R.id.img1);
        imageView.setImageResource(R.drawable.mangosteen);
        TextView text = (TextView)view.findViewById(R.id.text1);
        text.setText(fruitname.get(position));
    return view;
    }
}
