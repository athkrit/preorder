package com.example.admin.preorder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    CustomAdapterForPreorder adapter;
    ArrayList<String> clubkey = new ArrayList<String>();
    String getK;
    int countKey, countDurian, countLongan, countOrange, countPineapple, countrambutan, countmangosteen;
    ArrayList<Integer> countDurianA = new ArrayList<Integer>();
    ArrayList<Integer> countLonganA = new ArrayList<Integer>();
    ArrayList<Integer> countOrangeA = new ArrayList<Integer>();
    ArrayList<Integer> countPineappleA = new ArrayList<Integer>();
    ArrayList<Integer> countrambutanA = new ArrayList<Integer>();
    ArrayList<Integer> countmangosteenA = new ArrayList<Integer>();
    ArrayList<String> fruitcount = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listday);


        final int[] fruit = {R.drawable.mangosteen, R.drawable.longan, R.drawable.orange, R.drawable.pineapple, R.drawable.rambutan, R.drawable.durian};
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        callPre = database.getReference().child("product").child("preorderProduct");
        callPre.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                countKey = 0;
                clubkey.clear();
                countDurianA.clear();
                countLonganA.clear();
                countOrangeA.clear();
                countPineappleA.clear();
                countrambutanA.clear();
                countmangosteenA.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    getK = d.getKey();
                    clubkey.add(getK);
                    countKey = countKey + 1;
                }
//                for (int i = 0; i < countKey; i++) {
//                    countDurian = 0;
//                    countrambutan =0;
//                    countPineapple =0;
//                    countOrange = 0;
//                    countmangosteen =0;
//                    countLongan=0;
                    callall = database.getReference().child("product").child("preorderProduct").child(clubkey.get(1));
                    callall.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot d : dataSnapshot.getChildren()) {
                                GetData get = d.getValue(GetData.class);
                                fruitcount.add(get.getFruitName());
                            }
                            for (int x = 0; x < fruitcount.size(); x++) {
                                if (fruitcount.get(x).equals("ทุเรียน")) {
                                    countDurian++;
                                }
                                else if (fruitcount.get(x).equals("มังคุด")) {
                                    countmangosteen++;
                                }
                                else if (fruitcount.get(x).equals("ลำไย")) {
                                    countLongan++;
                                }
                                else if (fruitcount.get(x).equals("เงาะ")) {
                                    countrambutan++;
                                }
                                else if (fruitcount.get(x).equals("แตงโม")) {
                                    countPineapple++;
                                }
                                else {
                                    countOrange++;
                                }
                            }
                            countDurianA.add(countDurian);
                            countLonganA.add(countLongan);
                            countOrangeA.add(countOrange);
                            countPineappleA.add(countPineapple);
                            countrambutanA.add(countrambutan);
                            countmangosteenA.add(countmangosteen);

                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    int coun = fruitcount.size();
                    TextView textView =findViewById(R.id.text1);
                textView.setText(""+countDurianA.size());

                }
//                ListView list = (ListView) findViewById(R.id.list);
//                adapter = new CustomAdapterForPreorder(getApplicationContext(),fruitcount);
//                adapter = new CustomAdapterForPreorder(getApplicationContext(), clubkey, countDurianA, countLonganA, countOrangeA, countPineappleA, countrambutanA, countmangosteenA);
//                list.setAdapter(adapter);
//            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
