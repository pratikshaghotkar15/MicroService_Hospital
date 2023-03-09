package com.nurseService.controllers;

import com.nurseService.entities.Nurse;
import com.nurseService.services.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurses")
public class NurseController {
    @Autowired
    private NurseService nurseService;

    @PostMapping("/")
    public ResponseEntity<Nurse> create(@RequestBody Nurse nurse){
        return ResponseEntity.status(HttpStatus.CREATED).body(nurseService.create(nurse));
    }

    @GetMapping("/")
    public ResponseEntity<List<Nurse>> getall(){
        return ResponseEntity.ok(nurseService.getAll());
    }

    @GetMapping("/{nurseId}")
    public ResponseEntity<Nurse> getById(@PathVariable("nurseId") String nurseId){
        return ResponseEntity.ok(nurseService.GetById(nurseId));
    }

    @PutMapping("/{nurseId}")
    public ResponseEntity<Nurse> updateById(@PathVariable("nurseId") String nurseId,@RequestBody Nurse nurse){
        return ResponseEntity.ok(nurseService.update(nurseId,nurse));
    }

    @DeleteMapping("/{nurseId}")
    public void delete(@PathVariable("nurseId") String nurseId){
        nurseService.delete(nurseId);
    }




}
