package com.enesyaray.kutuphaneapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class KitapRequestDto {

    @NotBlank(message = "başlık alanı boş bırakılamaz")
    @Size(min=1,max = 230,message = "başlık 230 karakterle sınırlıdır")
    private String baslik;

    @NotBlank(message = "kitap sayfa içermeli")
    @Min(value=10,message = "kitap en az 10 sayfa olmalı")
    private int sayfaSayisi;

    @NotBlank(message = "yazar id olmalı")
    private Long yazarId;

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public int getSayfaSayisi() {
        return sayfaSayisi;
    }

    public void setSayfaSayisi(int sayfaSayisi) {
        this.sayfaSayisi = sayfaSayisi;
    }

    public Long getYazarId() {
        return yazarId;
    }

    public void setYazarId(Long yazarId) {
        this.yazarId = yazarId;
    }
}
