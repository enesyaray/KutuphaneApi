package com.enesyaray.kutuphaneapi.service;

import com.enesyaray.kutuphaneapi.dto.KitapResponseDto;
import com.enesyaray.kutuphaneapi.model.Kitap;
import java.util.List;
import java.util.Optional;

public interface KitapService {
    List<KitapResponseDto> tumKitaplariGetir();
    KitapResponseDto idIleGetir(Long id);
    public KitapResponseDto ekle(Kitap kitap);
    Optional<KitapResponseDto> guncelle(Long id, Kitap kitap);
    boolean sil(Long id);
}