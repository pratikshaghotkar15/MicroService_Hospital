package com.nurseService.services;

import com.nurseService.entities.Nurse;

import java.util.List;

public interface  NurseService {
    //create
    Nurse create(Nurse nurse);

    //get
    List<Nurse> getAll();

    //getById
    Nurse GetById(String id);

    //update
    Nurse update(String id,Nurse nurse);

    //delete
    void delete(String id);
}
