package com.enesyaray.kutuphaneapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KitapResponseDto {
    private Long id;
    private String isbn;
    private String baslik;
    private int sayfaSayisi;
    private YazarResponseDto yazar;

}
