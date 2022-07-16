package com.works.services;

import com.works.repositories.JoinProCatRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class JoinProCatService {

    final JoinProCatRepository jRepo;
    public JoinProCatService(JoinProCatRepository jRepo) {
        this.jRepo = jRepo;
    }

    public ResponseEntity list( String q, int page, String sort ) {
        Map<String, Object> hm = new LinkedHashMap<>();

        Sort orders = Sort.by("price").ascending();
        if ( sort.equals("desc") ) {
            orders = Sort.by("price").descending();
        }
        Pageable pageable = PageRequest.of(page, 5, orders);

        hm.put("status", true);
        hm.put("total", jRepo.countAllProCat( "%"+q+"%" ) );
        hm.put("result",jRepo.allProCat( "%"+q+"%", pageable ) );
        return new ResponseEntity(hm, HttpStatus.OK);
    }


}
