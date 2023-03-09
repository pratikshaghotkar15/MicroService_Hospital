package com.medicine.service.controllers;

import com.medicine.service.entities.Medicine;
import com.medicine.service.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;

    @PostMapping("/")
    public ResponseEntity<Medicine> create(@RequestBody Medicine medicine){
        return ResponseEntity.status(HttpStatus.CREATED).body(medicineService.create(medicine));
    }

    @GetMapping("/")
    public ResponseEntity<List<Medicine>> getall(){
        return ResponseEntity.ok(medicineService.getall());
    }

    @GetMapping("/{medicineId}")
    public ResponseEntity<Medicine> getById(@PathVariable("medicineId") String medicineId){
        return ResponseEntity.ok(medicineService.getById(medicineId));
    }

    @PutMapping("/{medicineId}")
    public ResponseEntity<Medicine> updateById(@PathVariable("medicineId") String medicineId,@RequestBody Medicine medicine){
        return ResponseEntity.ok(medicineService.update(medicineId,medicine));
    }

    @DeleteMapping("/{medicineId}")
    public void delete(@PathVariable("medicineId") String medicineId){
        medicineService.delete(medicineId);
    }


}
