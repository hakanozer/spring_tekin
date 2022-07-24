package com.example.services;

import com.example.entities.Note;
import com.example.repositories.NoteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class NoteService {

    final NoteRepository nRepo;
    public NoteService(NoteRepository nRepo) {
        this.nRepo = nRepo;
    }

    public ResponseEntity save(Note note) {
        Map<String, Object> hm = new LinkedHashMap<>();
        nRepo.save(note);
        hm.put("status", true);
        hm.put("result", note);
        return new ResponseEntity(hm, HttpStatus.OK);
    }


}
