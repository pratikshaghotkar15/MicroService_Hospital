package com.medicine.service.services;

import com.medicine.service.entities.Medicine;

import java.util.List;

public interface MedicineService {

    //create
    Medicine create(Medicine medicine);

    //getall
    List<Medicine> getall();

    //getById
    Medicine getById(String id);

    //update
    Medicine update(String id,Medicine medicine);

    //delete
    void delete(String id);


}
