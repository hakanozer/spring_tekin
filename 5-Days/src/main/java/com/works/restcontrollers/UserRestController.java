package com.works.restcontrollers;

import com.works.entities.User;
import com.works.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRestController {

    final UserService uService;
    public UserRestController(UserService uService) {
        this.uService = uService;
    }

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody User user) {
        return uService.signUp(user);
    }

    @PostMapping("/signIn")
    public ResponseEntity signIn(@RequestBody User user) {
        return uService.signIn(user);
    }

    @GetMapping("/search")
    public ResponseEntity search( @RequestParam String q ) {
        return uService.search(q);
    }

}
