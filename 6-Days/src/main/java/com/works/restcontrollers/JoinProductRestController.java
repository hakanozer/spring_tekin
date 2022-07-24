package com.works.restcontrollers;

import com.works.services.JoinProCatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/joinProduct")
public class JoinProductRestController {

    final JoinProCatService jService;
    public JoinProductRestController(JoinProCatService jService) {
        this.jService = jService;
    }

    @GetMapping("/list")
    public ResponseEntity list(@RequestParam(defaultValue = "") String q, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "asc") String sort) {
        return jService.list(q, page, sort);
    }


}
