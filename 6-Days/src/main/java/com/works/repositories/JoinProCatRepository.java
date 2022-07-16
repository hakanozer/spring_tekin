package com.works.repositories;

import com.works.entities.JoinProCat;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinProCatRepository extends JpaRepository<JoinProCat, Integer> {

    @Query(value = "SELECT count(*) as total FROM product as p INNER JOIN category as c ON p.cid = c.cid WHERE p.ptitle LIKE ?1 ", nativeQuery = true)
    int countAllProCat(String q);

    @Query(value = "SELECT p.pid, p.cid, p.price, p.ptitle, c.title FROM product as p INNER JOIN category as c ON p.cid = c.cid WHERE p.ptitle LIKE ?1 ", nativeQuery = true)
    List<JoinProCat> allProCat(String q, Pageable pageable);


}