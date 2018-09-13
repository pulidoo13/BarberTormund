package com.macguffinco.barbertormund.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.TextView;

import com.macguffinco.barbertormund.R;
import com.macguffinco.barbertormund.fragments.dummy.DummyContent;

import static java.security.AccessController.getContext;

public class DetailBarberActivity extends AppCompatActivity {


    TextView close_detail;
    GridView      gridView;
    RecyclerView recyclerViewCustomerComments;
    int[] images={R.mipmap.sample_foto,R.mipmap.sample_foto,R.mipmap.sample_foto,R.mipmap.sample_foto,R.mipmap.sample_foto,R.mipmap.sample_foto,R.mipmap.sample_foto,R.mipmap.sample_foto};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail_barber);

        close_detail= findViewById(R.id.close_detail);
        gridView=findViewById(R.id.gridGallery);
        recyclerViewCustomerComments=findViewById(R.id.customer_comments);

        GridGalleryAdapter gridAdapter=new GridGalleryAdapter(this,images);

        gridView.setAdapter(gridAdapter);

        recyclerViewCustomerComments.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCustomerComments.setAdapter(new LastCustomerAppointmentRecyclerAdapter(DummyContent.ITEMS, new LastCustomerAppointmentRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DummyContent.DummyItem item) {

            }

        }));


        close_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }
}
