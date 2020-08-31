package com.example.inboxapp.Model;

public class Message {
    private String gönderen, konu, ileti;

    public Message(String gönderen,String konu,String ileti){
        this.gönderen = gönderen;
        this.konu = konu;
        this.ileti = ileti;
    }

    public String getGönderen() {
        return gönderen;
    }

    public void setGönderen(String gönderen) {
        this.gönderen = gönderen;
    }

    public String getIleti() {
        return ileti;
    }

    public void setIleti(String ileti) {
        this.ileti = ileti;
    }

    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }
}
