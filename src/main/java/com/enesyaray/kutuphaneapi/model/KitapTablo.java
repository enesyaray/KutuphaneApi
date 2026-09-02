package com.enesyaray.kutuphaneapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Kitaplar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KitapTablo {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String baslik;


    @Column(nullable = false)
    private String yazar;


    @Column(name="sayfa_sayisi")
    private Integer sayfaSayisi;


    @Column
    private Integer basimYili;

}
