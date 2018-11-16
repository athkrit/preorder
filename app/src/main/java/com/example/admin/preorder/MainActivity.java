package com.example.admin.preorder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public DatabaseReference callPre, callall;
    ArrayList<String> fruitID = new ArrayList<String>();
    ArrayList<String> fruitName = new ArrayList<String>();
    ArrayList<Integer> price = new ArrayList<Integer>();
    ArrayList<String> productName = new ArrayList<String>();
    ArrayList<Integer> quantity = new ArrayList<Integer>();
    ArrayList<String> unitPro = new ArrayList<String>();
    CustomAdapterForPreorder adapterCus;
    ArrayList<String> clubkey = new ArrayList<String>();
    String getK;
    int countKey, countDurian, countLongan, countOrange, countPineapple, countrambutan, countmangosteen;
    ArrayList<Integer> countDurianA = new ArrayList<Integer>();
    ArrayList<Integer> countLonganA = new ArrayList<Integer>();
    ArrayList<Integer> countOrangeA = new ArrayList<Integer>();
    ArrayList<Integer> countPineappleA = new ArrayList<Integer>();
    ArrayList<Integer> countrambutanA = new ArrayList<Integer>();
    ArrayList<Integer> countmangosteenA = new ArrayList<Integer>();
    ArrayList<String[]> fruitcount = new ArrayList<String[]>();
    public int i;
    String[] day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int[] fruit = {R.drawable.mangosteen, R.drawable.longan, R.drawable.orange, R.drawable.pineapple, R.drawable.rambutan, R.drawable.durian};
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        callPre = database.getReference().child("product").child("preorderProduct");
        callPre.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                countKey = 0;
                clubkey.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    getK = d.getKey();
                    clubkey.add(getK);
                    countKey = countKey + 1;
                }
                String[] mStringArray = new String[clubkey.size()];
                mStringArray = clubkey.toArray(mStringArray);
                ListView list = (ListView) findViewById(R.id.list);
                ArrayAdapter<String> adapter =new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, mStringArray);
                list.setAdapter(adapter);
                final String[] finalMStringArray = mStringArray;
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent next = new Intent(MainActivity.this, PreListDay.class);
                        next.putExtra("DayPre", finalMStringArray[position]);
                        startActivity(next);
                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }
}
