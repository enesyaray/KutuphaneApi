package com.enesyaray.kutuphaneapi.repository;

import com.enesyaray.kutuphaneapi.model.Kitap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public interface KitapRepository extends JpaRepository<Kitap,Long> {


}