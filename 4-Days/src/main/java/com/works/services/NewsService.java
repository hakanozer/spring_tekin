package com.works.services;

import com.works.entities.News;
import com.works.repositories.NewsRepository;
import com.works.utils.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class NewsService {

    final NewsRepository nRepo;
    public NewsService(NewsRepository nRepo) {
        this.nRepo = nRepo;
    }


    public ResponseEntity save(News news) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        //news.setDate( new Date());
        News n = nRepo.save(news);
        System.out.println( "n : " + n.getClass().hashCode() );
        System.out.println( "news : " + news.getClass().hashCode() );
        hm.put(REnum.status, true);
        hm.put(REnum.result, news );
        return new ResponseEntity(hm, HttpStatus.OK);
    }


}
