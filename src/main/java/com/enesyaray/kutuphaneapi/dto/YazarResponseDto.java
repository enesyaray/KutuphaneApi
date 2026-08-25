package com.enesyaray.kutuphaneapi.dto;



public class YazarResponseDto {

    private Long id;
    private String ad;

    public YazarResponseDto(Long id,String ad){
        this.ad=ad;
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
}
