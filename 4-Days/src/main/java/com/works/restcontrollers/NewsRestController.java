package com.works.restcontrollers;

import com.works.entities.News;
import com.works.services.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsRestController {

    final NewsService nService;
    public NewsRestController(NewsService nService) {
        this.nService = nService;
    }

    @PostMapping("/save")
    public ResponseEntity save( @RequestBody News news ) {
        return nService.save(news);
    }

}
