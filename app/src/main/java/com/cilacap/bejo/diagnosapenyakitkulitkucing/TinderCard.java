package com.cilacap.bejo.diagnosapenyakitkulitkucing;


import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

/**
 * Created by janisharali on 19/08/16.
 */
@Layout(R.layout.cardview_diagnosa)
public class TinderCard {

    @View(R.id.textView)
    private TextView textView;

    //@View(R.id.nameAgeTxt)
    //private TextView nameAgeTxt;

    //@View(R.id.locationNameTxt)
    //private TextView locationNameTxt;

    private Penyakit mPenyakit;
    private Gejala mGejala;
    private Context mContext;
    private SwipePlaceHolderView mSwipeView;
    Hitung hitung = new Hitung();


    public TinderCard(Context context, Gejala gejala, SwipePlaceHolderView swipeView) {
        mContext = context;
        mGejala = gejala;
        mSwipeView = swipeView;
    }

    @Resolve
    private void onResolved(){
        //Glide.with(mContext).load(mPenyakit.getText()).bitmapTransform(new RoundedCornersTransformation(mContext, Utils.dpToPx(7), 0, RoundedCornersTransformation.CornerType.TOP)).into(textView);

        textView.setText(mGejala.getGejala());
        //nameAgeTxt.setText(mPenyakit.getName() + ", " + mPenyakit.getAge());
        //locationNameTxt.setText(mPenyakit.getLocation());
    }

    @Click(R.id.textView)
    private void onClick(){
        //Log.d("EVENT", "test json "+ hitung.test());
        Log.d("EVENT", "text view click "+ mGejala.getGejala());
//        mSwipeView.addView(this);
    }

    @SwipeOut
    private void onSwipedOut(){
        Log.d("EVENT", "onSwipedOut " + mGejala.getGejala() + hitung.catat(0));
//        mSwipeView.addView(this);
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn(){
        Log.d("EVENT", "onSwipedIn " + mGejala.getGejala() + hitung.catat(1));
    }

    @SwipeInState
    private void onSwipeInState(){
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState(){
        Log.d("EVENT", "onSwipeOutState");
    }
}

