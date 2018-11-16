package com.example.admin.preorder;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PreListDay extends AppCompatActivity {
    public DatabaseReference callDataPre;
    String order;
    GetData getData;
    ArrayList<String> fruitID = new ArrayList<String>();
    ArrayList<String> fruitName = new ArrayList<String>();
    ArrayList<Integer> price = new ArrayList<Integer>();
    ArrayList<String> productName = new ArrayList<String>();
    ArrayList<Integer> quantity = new ArrayList<Integer>();
    ArrayList<String> unitPro = new ArrayList<String>();
    CustomAdapterForPreorder adapterCus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_list_day);

        Bundle extras = getIntent().getExtras();
        order = extras.getString("DayPre");
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        callDataPre = database.getReference().child("product").child("preorderProduct").child(order);
        callDataPre.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    getData = d.getValue(GetData.class);
                    fruitID.add(getData.getFruitID());
                    fruitName.add(getData.getFruitName());
                    price.add(getData.getPrice());
                    productName.add(getData.getProductName());
                    quantity.add(getData.getQuantity());
                    unitPro.add(getData.getUnitPro());
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
