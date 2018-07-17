package com.cilacap.bejo.diagnosapenyakitkulitkucing;

public class WikiPenyakit {

    private String penyakit;
    private String info;

    public String getInfoPenyakit() {
        return penyakit;
    }

    public String getInfo() {
        return info;
    }


    public WikiPenyakit(String penyakit, String info) {
        this.penyakit = penyakit;
        this.info = info;
    }
}
