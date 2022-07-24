package com.example.restcontrollers;

import com.example.entities.Note;
import com.example.services.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/note")
public class NoteRestController {

    final NoteService noteService;
    public NoteRestController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Note note) {
        return noteService.save(note);
    }

    /*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handler( MethodArgumentNotValidException ex ) {
        Map<String, Object> hm = new LinkedHashMap<>();

        List<FieldError> errorList = ex.getFieldErrors();
        List<Map<String, String>> ls = new ArrayList<>();
        for ( FieldError item : errorList ) {
            Map<String , String > hmx = new HashMap<>();
            String field = item.getField();
            String message = item.getDefaultMessage();
            hmx.put( field, message );
            ls.add(hmx);
        }
        hm.put("errors", ls);
        return new ResponseEntity( hm, HttpStatus.BAD_REQUEST );
    }
     */



}
