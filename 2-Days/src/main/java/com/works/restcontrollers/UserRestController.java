package com.works.restcontrollers;

import com.works.entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

// @RestController
// Bu notasyon sayesinde bu sınıf içindeki methodlar geriye servis datası dönderirler.

@RestController
public class UserRestController {

    List<User> ls = new ArrayList<>();
    public UserRestController() {
        User u1 = new User("Erkan", "Bilsin", "erkan@mail.com", 33);
        User u2 = new User("Ali", "Bilmem", "ali@mail.com", 33);
        User u3 = new User("Serkan", "Bilirler", "serkan@mail.com", 33);
        ls.add(u1);
        ls.add(u2);
        ls.add(u3);
    }

    // @GetMapping -> bu uygulamada get yöntemi ile bir servis yazılacak
    // ve burada geriye servis dataları dönecektir.
    @GetMapping("/user/list")
    public Map list() {
        Map<String, Object> hm = new LinkedHashMap<>();
        String muhammet = "Muhammet";
        hm.put("status", true);
        hm.put("message", "Action Success");
        hm.put("result", ls);
        hm.put("hashcode", muhammet.hashCode());
        return hm;
    }

    // Dışarıdan data alımı
    // Query String
        // name
        // surname
        // email
        // age
    // http://localhost:8080/user/save?name=Zehra&surname=Bil&email=zehra@mail.com&age=30
    // @RequestParam
    @PostMapping("/user/save")
    public Map save(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String mail,
            @RequestParam(defaultValue = "0") int age
    ) {
        Map<String, Object> hm = new LinkedHashMap<>();
        User u = new User(name, surname, mail, age);
        ls.add(u);
        hm.put("status", true);
        hm.put("message", "Action Success");
        return hm;
    }


    // search
    // q
    @GetMapping("/user/search/{q}")
    public Map search(@PathVariable String q  ) {
        Map<String, Object> hm = new LinkedHashMap<>();
        System.out.println( q );
        return hm;
    }

    // @RequestBody -> servisimize gelecek olan json datalarının object haline dönüşümü için kullanılır
    @PostMapping("/user/saveObj")
    public Map search( @RequestBody User u ) {
        Map<String, Object> hm = new LinkedHashMap<>();
        ls.add(u);
        hm.put("status", true);
        hm.put("message", u);
        return hm;
    }

}
