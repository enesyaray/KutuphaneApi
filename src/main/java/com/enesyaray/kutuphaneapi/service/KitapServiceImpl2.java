package com.enesyaray.kutuphaneapi.service;

import com.enesyaray.kutuphaneapi.model.Kitap;
import com.enesyaray.kutuphaneapi.repository.KitapRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KitapServiceImpl2 implements KitapService {

    private final KitapRepository kitapRepository;

    public KitapServiceImpl2(KitapRepository kitapRepository) {
        this.kitapRepository = kitapRepository;
    }

    @Override
    public List<Kitap> tumKitaplariGetir() {
        return kitapRepository.tumKitaplariGetir();
    }

    @Override
    public Optional<Kitap> idIleGetir(Long id) {
        return kitapRepository.idIleGetir(id);
    }

    @Override
    public Kitap ekle(Kitap kitap) {
        return kitapRepository.kaydet(kitap);
    }

    @Override
    public Optional<Kitap> guncelle(Long id, Kitap kitap) {
        return kitapRepository.guncelle(id, kitap);
    }

    @Override
    public boolean sil(Long id) {
        return kitapRepository.sil(id);
    }
}