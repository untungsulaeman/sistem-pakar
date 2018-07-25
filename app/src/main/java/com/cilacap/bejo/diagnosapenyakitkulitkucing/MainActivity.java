package com.cilacap.bejo.diagnosapenyakitkulitkucing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView diagnosa, daftar, about, simulasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);



      diagnosa = (CardView) findViewById(R.id.diagnosa);
        daftar = (CardView) findViewById(R.id.daftarPenyakit);
       about = (CardView) findViewById(R.id.about);
       simulasi = (CardView) findViewById(R.id.petunjuk);

       diagnosa.setOnClickListener(this);
       daftar.setOnClickListener(this);
       about.setOnClickListener(this);
       simulasi.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){

        Intent i;

        switch (v.getId()){

            case R.id.diagnosa : i = new Intent(this, DiagnosaActivity.class);
            startActivity(i);
            break;

            case R.id.petunjuk : i = new Intent(this, SimulasiActivity.class);
            startActivity(i);
            break;

            case R.id.about : i = new Intent(this, AboutActivity.class);
            startActivity(i);
            break;

            case  R.id.daftarPenyakit : i = new Intent(this, DaftarActivity.class);
            startActivity(i);
            break;

            default:break;
        }

    }
}
