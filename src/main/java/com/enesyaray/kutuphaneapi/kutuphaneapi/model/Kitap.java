package com.enesyaray.kutuphaneapi.kutuphaneapi.model;

public class Kitap {
    private Long id;
    private String baslik;
    private String yazar;
    private Integer sayfaSayisi;
    private Integer basimYili;

    public Kitap() {
    }

    public Kitap(Long id, String baslik, String yazar, Integer sayfaSayisi, Integer basimYili) {
        this.id = id;
        this.baslik = baslik;
        this.yazar = yazar;
        this.sayfaSayisi = sayfaSayisi;
        this.basimYili = basimYili;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBaslik() { return baslik; }
    public void setBaslik(String baslik) { this.baslik = baslik; }

    public String getYazar() { return yazar; }
    public void setYazar(String yazar) { this.yazar = yazar; }

    public Integer getSayfaSayisi() { return sayfaSayisi; }
    public void setSayfaSayisi(Integer sayfaSayisi) { this.sayfaSayisi = sayfaSayisi; }

    public Integer getBasimYili() { return basimYili; }
    public void setBasimYili(Integer basimYili) { this.basimYili = basimYili; }
}