package com.cilacap.bejo.diagnosapenyakitkulitkucing;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Gremory on 7/26/2017.
 */

public class Gejala {
    @SerializedName("g")
    @Expose
    private String gjl;

    public String getGejala() {
        return gjl;
    }
}
