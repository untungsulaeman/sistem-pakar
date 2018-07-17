package com.cilacap.bejo.diagnosapenyakitkulitkucing;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

public class DiagnosaActivity extends AppCompatActivity {

    private SwipePlaceHolderView mSwipeView;
    private Context mContext;
    Hitung hitung = new Hitung();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(null);

        setContentView(R.layout.activity_diagnosa);


        mSwipeView = (SwipePlaceHolderView)findViewById(R.id.swipeView);
        mContext = getApplicationContext();

        int bottomMargin = Utils.dpToPx(160);
        Point windowSize = Utils.getDisplaySize(getWindowManager());
        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setIsUndoEnabled(true)
                .setHeightSwipeDistFactor(10)
                .setWidthSwipeDistFactor(5)
                .setSwipeDecor(new SwipeDecor()
                                .setViewWidth(windowSize.x)
                                .setViewHeight(windowSize.y - bottomMargin)
                                .setViewGravity(Gravity.TOP)
                                .setPaddingTop(20)
                                .setRelativeScale(0.01f));


        hitung.test(this.getApplicationContext());
        for(Gejala gejala : Utils.loadGejala(this.getApplicationContext()))
        {
            hitung.clear();
            mSwipeView.addView(new TinderCard(mContext, gejala, mSwipeView));
        }
        findViewById(R.id.tidak).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( hitung.getLastPoint()==hitung.getJumlah_pertanyaan()) {

                }else{
                    System.out.println("sini dulu");
                    mSwipeView.doSwipe(false);
                }
            }
        });


        findViewById(R.id.iya).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    System.out.println("sini dulu");
                    mSwipeView.doSwipe(true);

                }
        });

    findViewById(R.id.kembali).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(DiagnosaActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    });

        findViewById(R.id.hitung).setOnClickListener(new View.OnClickListener() {
          @Override
            public void onClick(View v) {

              Intent intent = new Intent(DiagnosaActivity.this, Survey.class);
              intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                  startActivity(intent);
                  hitung.pilihan();
                  hitung.cari();
                  finish();
          }


        });

    }


    //@Override
    //public void onStop() {
 //super.onStop();
//startActivity(new Intent(DiagnosaActivity.this, Survey.class).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
//}

}

