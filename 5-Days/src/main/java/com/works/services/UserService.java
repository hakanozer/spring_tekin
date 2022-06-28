package com.works.services;

import com.works.entities.User;
import com.works.repositories.UserRepository;
import com.works.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    final UserRepository uRepo;
    public UserService(UserRepository uRepo) {
        this.uRepo = uRepo;
    }

    public ResponseEntity signUp(User user) {
        Map<String, Object> hm = new LinkedHashMap<>();
        String newPass = Util.md5( user.getPassword() );
        user.setPassword( newPass );
        uRepo.save( user );
        hm.put("status", true);
        hm.put("result", user);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity signIn( User user ) {
        Map<String, Object> hm = new LinkedHashMap<>();
        String newPass = Util.md5( user.getPassword() );
        Optional<User> optionalUser = uRepo.findByEmailEqualsIgnoreCaseAndPasswordEqualsIgnoreCase(user.getEmail(), newPass);
        if ( optionalUser.isPresent() ) {
            // kullanıcı giriş yaptı
            hm.put("status", true);
            hm.put("message", "Login Success");
            hm.put("result", optionalUser.get() );
        }else {
            // kullanıcı bilgileri hatalı
            hm.put("status", false);
            hm.put("message", "Login Fail");
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity search( String q ) {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<User> ls = uRepo.findByNameContainsOrSurnameContainsAllIgnoreCase(q,q);
        hm.put("status", false);
        hm.put("result", ls);
        if ( ls.size() > 0 ) {
            hm.put("status", true);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }


}
