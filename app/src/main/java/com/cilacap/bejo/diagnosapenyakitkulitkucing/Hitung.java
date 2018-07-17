package com.cilacap.bejo.diagnosapenyakitkulitkucing;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Gremory on 7/27/2017.
 */

public class Hitung {
    private static final String TAG = "Hitung";
    static int jumlah_pertanyaan = 43;
    static int jumlah_penyakit = 14;
    static int i;
    static int[] jwb = new int[jumlah_pertanyaan];
    static ArrayList<String> gjl = new ArrayList<String>();
    static ArrayList<String> pny = new ArrayList<String>();
    volatile boolean doStop = false;
    static String penyakit=null;


    public int tambah() {
        i++;
        return i;
    }

    public void pilihan() {
        int jumlah = 0;
        for (int i = 0; i < jwb.length; i++) {
            if (jwb[i] == 1) {
                jumlah = jumlah + 1;
            }
        }

        System.out.println(jumlah);

    }

    public int catat(int hasil) {
        jwb[i] = hasil;
        i++;
        Log.d("array ", Arrays.toString(jwb));

        return i;
    }

    public int getLastPoint(){
        return i;
    }

    public int getJumlah_pertanyaan(){
        return jumlah_pertanyaan;
    }

    public String getPenyakit(){
        return penyakit;
    }

    public String test(Context context) {
        String json = null;
        try {
            JSONArray array = new JSONArray(loadJSONFromAsset(context, "penyakit.json"));

            for (int i = 0; i < array.length(); i++) {
                JSONObject test = array.getJSONObject(i);
                pny.add(String.valueOf(test.get("penyakit")));
                gjl.add(String.valueOf(test.getJSONArray("gejala")));
                //Log.d("arrayooooooooo ", String.valueOf(test.get("penyakit")));
                // Log.d("arrayooooooooo ", String.valueOf(test.getJSONArray("gejala")));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return "o";
    }

    private static String loadJSONFromAsset(Context context, String jsonFileName) {
        String json = null;
        InputStream is = null;
        try {
            AssetManager manager = context.getAssets();
            Log.d(TAG, "path " + jsonFileName);
            is = manager.open(jsonFileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void cari() {
        int hasil2=0;
        System.out.println("hasil dostop " + doStop);
        try {
            for (int i = 0; i<=jumlah_penyakit&&!doStop; i++) {
                System.out.println("panjang array awal " + gjl.get(i));
                System.out.println("penyakit awal " + pny.get(i));
                JSONArray array = new JSONArray(gjl.get(i)); // 2,3,4,5
                for(int j=0; j<array.length();j++){
                    System.out.println("panjang array " + array.length());
                    System.out.println("panggil gejala ke " + array.get(j));
                    String jawab = toString().valueOf(array.get(j));
                    int jawabint = Integer.parseInt(jawab);
                    System.out.println(jawabint);
                    if(jwb[jawabint-1]==1){
                        System.out.println("gejala ketemu");
                        hasil2= hasil2+1;
                        System.out.println("hasil cocokan "+hasil2);
                    }
                    if(hasil2==array.length()){
                        System.out.println("penyakit adalah " + pny.get(i));
                        penyakit=pny.get(i);
                        hasil2=0;
                        doStop=true;
                    }else{
                        System.out.println("panjang array dan hasil tidak sama");
                    }
                }
                hasil2=0;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void clear(){
        for(int i=0;i<jumlah_pertanyaan;i++){
            jwb[i]=0;
        }
        i=0;
        boolean doStop = false;

    }
}
