package com.cilacap.bejo.diagnosapenyakitkulitkucing;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by janisharali on 29/08/16.
 */
public class Penyakit {

    @SerializedName("penyakit")
    @Expose
    private String penyakit;

    @SerializedName("gejala")
    @Expose
    private String gejala;



    public String getPenyakit() {
        return penyakit;
    }

    // public void setName(String name) {
    //     this.name = name;
    // }

    public String getGejala() {
        return gejala ;
    }

    //  public void setText(String text) {
    //      this.text = text;
    //  }

    //  public Integer getAge() {return age;}

    //public void setAge(Integer age) {
    //   this.age = age;
    // }

    //public String getLocation() {
    //    return location;
    // }

    //public void setLocation(String location) {
    //   this.location = location;
    // }
}

