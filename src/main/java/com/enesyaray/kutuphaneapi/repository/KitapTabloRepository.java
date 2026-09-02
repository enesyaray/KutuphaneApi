package com.enesyaray.kutuphaneapi.repository;

import com.enesyaray.kutuphaneapi.model.KitapTablo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitapTabloRepository extends JpaRepository<KitapTablo,Long> {
}
