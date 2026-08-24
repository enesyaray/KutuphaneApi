package com.enesyaray.kutuphaneapi.kutuphaneapi.controller;

import com.enesyaray.kutuphaneapi.kutuphaneapi.model.Kitap;
import com.enesyaray.kutuphaneapi.kutuphaneapi.service.KitapService;
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

    // 1. Endpoint: GET /api/kitaplar -> Tüm kitapları listeleme
    @GetMapping
    public ResponseEntity<List<Kitap>> tumKitaplariGetir() {
        return ResponseEntity.ok(kitapService.tumKitaplariGetir());
    }

    // 2. Endpoint: GET /api/kitaplar/{id} -> Tek kitap getirme
    @GetMapping("/{id}")
    public ResponseEntity<Kitap> idIleGetir(@PathVariable Long id) {
        return kitapService.idIleGetir(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 3. Endpoint: POST /api/kitaplar -> Yeni kitap ekleme
    @PostMapping
    public ResponseEntity<Kitap> kitapEkle(@RequestBody Kitap kitap) {
        Kitap kaydedilen = kitapService.ekle(kitap);
        return ResponseEntity.status(HttpStatus.CREATED).body(kaydedilen);
    }

    // 4. Endpoint: PUT /api/kitaplar/{id} -> Kitap güncelleme
    @PutMapping("/{id}")
    public ResponseEntity<Kitap> kitapGuncelle(@PathVariable Long id, @RequestBody Kitap kitap) {
        return kitapService.guncelle(id, kitap)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 5. Endpoint: DELETE /api/kitaplar/{id} -> Kitap silme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> kitapSil(@PathVariable Long id) {
        if (kitapService.sil(id)) {
            return ResponseEntity.noContent().build(); // HTTP 204 No Content
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // HTTP 404 Not Found
    }
}