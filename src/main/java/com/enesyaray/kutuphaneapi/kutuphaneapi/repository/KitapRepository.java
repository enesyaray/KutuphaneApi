package com.enesyaray.kutuphaneapi.kutuphaneapi.repository;

import com.enesyaray.springdemo1.kutuphaneapi.model.Kitap;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class KitapRepository {

    private final List<Kitap> kitapListesi = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    // 1. Tüm kitapları listele
    public List<Kitap> tumKitaplariGetir() {
        return new ArrayList<>(kitapListesi);
    }

    // 2. ID ile tek kitap bul
    public Optional<Kitap> idIleGetir(Long id) {
        return kitapListesi.stream()
                .filter(kitap -> kitap.getId().equals(id))
                .findFirst();
    }

    // 3. Yeni kitap kaydet (Otomatik artan ID atar)
    public Kitap kaydet(Kitap kitap) {
        if (kitap.getId() == null) {
            kitap.setId(idGenerator.getAndIncrement());
        }
        kitapListesi.add(kitap);
        return kitap;//a
    }

    // 4. Var olan kitabı güncelle
    public Optional<Kitap> guncelle(Long id, Kitap yeniKitap) {
        return idIleGetir(id).map(mevcutKitap -> {
            mevcutKitap.setBaslik(yeniKitap.getBaslik());
            mevcutKitap.setYazar(yeniKitap.getYazar());
            mevcutKitap.setSayfaSayisi(yeniKitap.getSayfaSayisi());
            mevcutKitap.setBasimYili(yeniKitap.getBasimYili());
            return mevcutKitap;
        });
    }

    // 5. Kitap sil
    public boolean sil(Long id) {
        return kitapListesi.removeIf(kitap -> kitap.getId().equals(id));
    }
}