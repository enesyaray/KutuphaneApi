package com.enesyaray.kutuphaneapi.service.Impl;

import com.enesyaray.kutuphaneapi.dto.KitapResponseDto;
import com.enesyaray.kutuphaneapi.model.Kitap;
import com.enesyaray.kutuphaneapi.repository.KitapRepository;
import com.enesyaray.kutuphaneapi.service.KitapService;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Service
@Transactional
public class KitapServiceImpl implements KitapService {

    private final KitapRepository kitapRepository;

    public KitapServiceImpl(KitapRepository kitapRepository) {
        this.kitapRepository = kitapRepository;
    }

    @Override
    public List<KitapResponseDto> tumKitaplariGetir() {

        List<KitapResponseDto> kitapDtoCevaplari= new ArrayList<>();
        List<Kitap> Kitaplar = kitapRepository.findAll();

        for(Kitap kitap:Kitaplar){
            KitapResponseDto kitapResponseDto= new KitapResponseDto();
            BeanUtils.copyProperties(kitap, kitapResponseDto);
            kitapDtoCevaplari.add(kitapResponseDto);
        }

        return kitapDtoCevaplari;
    }

    @Override
    public KitapResponseDto idIleGetir(Long id) {
        Kitap kitap =kitapRepository.findById(id).orElseThrow(()->
                new RuntimeException("kitp kulunamadı id si : "+id));
        KitapResponseDto responseDto= new KitapResponseDto();
        BeanUtils.copyProperties(kitap,responseDto);
        return responseDto;


    }

    @Override
    public KitapResponseDto ekle(Kitap kitap) {
        KitapResponseDto kitapResponseDto = new KitapResponseDto();
        kitapRepository.save(kitap);
        BeanUtils.copyProperties(kitap,kitapResponseDto);
        return kitapResponseDto;
    }

    @Override
    public Optional<KitapResponseDto> guncelle(Long id, Kitap kitap) {
        Kitap mevcutKitap = kitapRepository.findById(id).orElseThrow(()->
                new RuntimeException("kitap bulunamadı id si : "+id));

        KitapResponseDto kitapResponseDto=new KitapResponseDto();
        mevcutKitap.setBaslik(kitap.getBaslik());
        mevcutKitap.setYazar(kitap.getYazar());
        mevcutKitap.setSayfaSayisi(kitap.getSayfaSayisi());
        mevcutKitap.setBasimYili(kitap.getBasimYili());

        kitapRepository.save(mevcutKitap);
        BeanUtils.copyProperties(mevcutKitap,kitapResponseDto);
        return Optional.of(kitapResponseDto);

    }

    @Override
    public boolean sil(Long id) {
        if(!kitapRepository.existsById(id)){
            return false;
        }
        kitapRepository.deleteById(id);
        return true;
    }
}