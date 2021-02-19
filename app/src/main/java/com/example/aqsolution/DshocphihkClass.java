package com.example.aqsolution;

public class DshocphihkClass {
    private String ten_nhom_ct;
    private String ten_hoc_ky;
    private float hoc_phi;
    private float mien_giam;
    private float phai_thu;
    private float da_thu;
    private float con_no;

    public DshocphihkClass(String ten_nhom_ct, String ten_hoc_ky, float hoc_phi, float mien_giam, float phai_thu, float da_thu, float con_no) {
        this.ten_nhom_ct = ten_nhom_ct;
        this.ten_hoc_ky = ten_hoc_ky;
        this.hoc_phi = hoc_phi;
        this.mien_giam = mien_giam;
        this.phai_thu = phai_thu;
        this.da_thu = da_thu;
        this.con_no = con_no;
    }

    public String getTen_nhom_ct() {
        return ten_nhom_ct;
    }

    public String getTen_hoc_ky() {
        return ten_hoc_ky;
    }

    public float getHoc_phi() {
        return hoc_phi;
    }

    public float getMien_giam() {
        return mien_giam;
    }

    public float getPhai_thu() {
        return phai_thu;
    }

    public float getDa_thu() {
        return da_thu;
    }

    public float getCon_no() {
        return con_no;
    }
}
