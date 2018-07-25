package com.cilacap.bejo.diagnosapenyakitkulitkucing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Survey extends AppCompatActivity {
    Hitung hitung=new Hitung();
    Gejala gejala = new Gejala();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(null);
        setContentView(R.layout.hasil);
        TextView tampil = (TextView) findViewById(R.id.tampilpenyakit);
        if(hitung.getPenyakit() == null ){

            tampil.setText("Penyakit tidak ditemukan");

        }else {
            tampil.setText(hitung.getPenyakit());


        }

    findViewById(R.id.diagnosaulang).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), DiagnosaActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    });

        findViewById(R.id.kembalikemenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Survey.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });



    }
   // @Override
   // public void onStop() {
     //   super.onStop();
       // startActivity(new Intent(Survey.this, DiagnosaActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    //}

}

