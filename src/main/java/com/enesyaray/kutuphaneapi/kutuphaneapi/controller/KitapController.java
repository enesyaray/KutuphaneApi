package com.enesyaray.kutuphaneapi.controller;

import com.enesyaray.kutuphaneapi.model.Kitap;
import com.enesyaray.kutuphaneapi.service.KitapService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kitaplar")
public class KitapController {

    private final KitapService kitapService;

    public KitapController(KitapService kitapService) {
        this.kitapService = kitapService;
    }

    @GetMapping
    public ResponseEntity<List<Kitap>> tumKitaplariGetir() {
        return ResponseEntity.ok(kitapService.tumKitaplariGetir());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kitap> idIleGetir(@PathVariable Long id) {
        return kitapService.idIleGetir(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Kitap> kitapEkle(@RequestBody Kitap kitap) {
        Kitap kaydedilen = kitapService.ekle(kitap);
        return ResponseEntity.status(HttpStatus.CREATED).body(kaydedilen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kitap> kitapGuncelle(@PathVariable Long id, @RequestBody Kitap kitap) {
        return kitapService.guncelle(id, kitap)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> kitapSil(@PathVariable Long id) {
        if (kitapService.sil(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}