package com.cilacap.bejo.diagnosapenyakitkulitkucing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class DaftarActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerAdapter adapter = new RecyclerAdapter(this);

        recyclerView.setAdapter(adapter);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
