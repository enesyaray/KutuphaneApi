package com.enesyaray.kutuphaneapi.kutuphaneapi.service;

import com.enesyaray.kutuphaneapi.kutuphaneapi.model.Kitap;
import java.util.List;
import java.util.Optional;

public interface KitapService {
    List<Kitap> tumKitaplariGetir();
    Optional<Kitap> idIleGetir(Long id);
    Kitap ekle(Kitap kitap);
    Optional<Kitap> guncelle(Long id, Kitap kitap);
    boolean sil(Long id);
}