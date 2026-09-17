package com.enesyaray.kutuphaneapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kitap")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kitap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String baslik;
    private String yazar;
    private Integer sayfaSayisi;
    private Integer basimYili;


}