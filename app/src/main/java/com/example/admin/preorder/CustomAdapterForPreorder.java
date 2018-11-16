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
    ArrayList<String> clubkey = new ArrayList<String>();
    ArrayList<Integer> countDurianA = new ArrayList<Integer>();
    ArrayList<Integer> countLonganA = new ArrayList<Integer>();
    ArrayList<Integer> countOrangeA = new ArrayList<Integer>();
    ArrayList<Integer> countPineappleA = new ArrayList<Integer>();
    ArrayList<Integer> countrambutanA = new ArrayList<Integer>();
    ArrayList<Integer> countmangosteenA = new ArrayList<Integer>();
    public CustomAdapterForPreorder(Context context, ArrayList<String> clubkey,ArrayList<Integer> countDurianA, ArrayList<Integer> countLonganA,ArrayList<Integer> countOrangeA,ArrayList<Integer> countPineappleA,ArrayList<Integer> countrambutanA,ArrayList<Integer> countmangosteenA){
        this.mContext = context;
        this.clubkey = clubkey;
        this.countDurianA =countDurianA;
        this.countLonganA = countLonganA;
        this.countmangosteenA = countmangosteenA;
        this.countOrangeA = countOrangeA;
        this.countPineappleA = countPineappleA;
        this.countrambutanA = countrambutanA;
    }
    @Override
    public int getCount() {
        return clubkey.size();
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
        final TextView date = (TextView)view.findViewById(R.id.text1);
        date.setText(""+clubkey.get(position));

//        ArrayList<String> name = new ArrayList<String>();

//        if(countDurianA.get(position)!=0){
//            ImageView img1 = view.findViewById(R.id.img1);
//            img1.setImageResource(R.drawable.durian);
//        }
//        if(countLonganA.get(position)!=0){
//            ImageView img2 = view.findViewById(R.id.img2);
//            img2.setImageResource(R.drawable.longan);
//        }
//        if(countrambutanA.get(position)!=0){
//            ImageView img3 = view.findViewById(R.id.img3);
//            img3.setImageResource(R.drawable.rambutan);
//        }
//        if(countOrangeA.get(position)!=0){
//            ImageView img4 = view.findViewById(R.id.img11);
//            img4.setImageResource(R.drawable.orange);
//        }
//        if(countmangosteenA.get(position)!=0){
//            ImageView img5 = view.findViewById(R.id.img12);
//            img5.setImageResource(R.drawable.mangosteen);
//        }
//        if(countPineappleA.get(position)!=0){
//            ImageView img6 = view.findViewById(R.id.img13);
//            img6.setImageResource(R.drawable.pineapple);
//        }

    return convertView;
    }
}
