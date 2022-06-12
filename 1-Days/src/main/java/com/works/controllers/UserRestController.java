package com.works.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    public UserRestController() {
        System.out.println("UserRestController Call");
    }

    // GET -> güvenlikle ilgili dataların olmadığı ve payşıma uygun servislerin yazılımında kullanılır. belirli bir data gönderim sınırı vardır. Parametrelerdinde Büyük verilerde kullanılmaz.
    // POST -> İçerisinde güvenli olması gereken tüm data olayları post yöntemi ile gönderim sağlamalıdır. Büyük data gönderimleri ve bu dataların işlenmesi post ile gerçekleşir. Resim, PDF vb dosyalar.
    // PUT -> güncelleme
    // DELETE -> silme işlemlerinde kullanılan method

    // SSL -> Dataların gönderimşi sırasında araya giren modem yöneticisinin dataları görmemesi için kullanılan bir sertifikadır.

}
