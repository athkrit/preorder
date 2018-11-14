package com.example.admin.preorder;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public DatabaseReference callPre;
    ArrayList<String> fruitId= new ArrayList<String>();
    ArrayList<String> fruitName= new ArrayList<String>();
    ArrayList<String> price= new ArrayList<String>();
    ArrayList<String> productName= new ArrayList<String>();
    ArrayList<String> quantity= new ArrayList<String>();
    ArrayList<String> unit= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listday);

        int[] fruit = {R.drawable.mangosteen,R.drawable.longan,R.drawable.orange,R.drawable.pineapple,R.drawable.rambutan,R.drawable.durian};
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        callPre = database.getReference().child("product").child("preorderProduct");
        callPre.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                String data = String.valueOf(map.get("-LR5McbfvCY5cZgZNVwf"));
                //                for (DataSnapshot d : dataSnapshot.getChildren()) {
//                    GetDataPre P = d.getValue(GetDataPre.class);
//
//                    fruitId.add(P.getFruitId());
//                    fruitName.add(P.getFruitName());
//                    price.add(P.getPrice());
//                    productName.add(P.getProductName());
//                    quantity.add(P.getQuantity());
//                    unit.add(P.getUnit());
                    TextView text = findViewById(R.id.test);
                    text.setText(data);
//
//                }
                //TextView text = findViewById(R.id.text1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                TextView text = findViewById(R.id.text1);
                text.setText("data not found");
            }
        });
    }
}
