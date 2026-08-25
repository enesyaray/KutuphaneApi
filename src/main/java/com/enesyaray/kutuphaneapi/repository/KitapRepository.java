package com.enesyaray.kutuphaneapi.repository;

import com.enesyaray.kutuphaneapi.model.Kitap;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class KitapRepository {

    private final List<Kitap> kitapListesi = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Kitap> tumKitaplariGetir() {
        return new ArrayList<>(kitapListesi);
    }

    public Optional<Kitap> idIleGetir(Long id) {
        return kitapListesi.stream()
                .filter(kitap -> kitap.getId().equals(id))
                .findFirst();
    }

    public Kitap kaydet(Kitap kitap) {
        if (kitap.getId() == null) {
            kitap.setId(idGenerator.getAndIncrement());
        }
        kitapListesi.add(kitap);
        return kitap;
    }

    public Optional<Kitap> guncelle(Long id, Kitap yeniKitap) {
        return idIleGetir(id).map(mevcutKitap -> {
            mevcutKitap.setBaslik(yeniKitap.getBaslik());
            mevcutKitap.setYazar(yeniKitap.getYazar());
            mevcutKitap.setSayfaSayisi(yeniKitap.getSayfaSayisi());
            mevcutKitap.setBasimYili(yeniKitap.getBasimYili());
            return mevcutKitap;
        });
    }

    public boolean sil(Long id) {

        return kitapListesi.removeIf(kitap -> kitap.getId().equals(id));
    }
}