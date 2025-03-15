package com.example.myapplication.Lab3;

public class Fruit {
    private String Ten;
    private String Mota;
    private int HinhUrl;

    public Fruit(int hinhUrl, String ten, String mota) {
        Ten = ten;
        Mota = mota;
        HinhUrl = hinhUrl;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        this.Ten = ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getHinhUrl() { return HinhUrl; }

    public void setHinhUrl(String hinhUrl) { HinhUrl = Integer.parseInt(hinhUrl); }

}
