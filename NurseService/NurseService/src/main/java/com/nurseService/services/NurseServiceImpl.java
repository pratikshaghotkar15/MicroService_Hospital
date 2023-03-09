package com.nurseService.services;

import com.nurseService.entities.Nurse;
import com.nurseService.exceptions.ResouseNotFoundException;
import com.nurseService.repositories.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class NurseServiceImpl implements NurseService{

    @Autowired
    private NurseRepository nurseRepository;
    @Override
    public Nurse create(Nurse nurse) {
        String id=UUID.randomUUID().toString();
        nurse.setNurseId(id);
        return nurseRepository.save(nurse);
    }

    @Override
    public List<Nurse> getAll() {
        return nurseRepository.findAll();
    }

    @Override
    public Nurse GetById(String id) {
        return nurseRepository.findById(id).orElseThrow(()-> new ResouseNotFoundException("nurse not found"+id));
    }

    @Override
    public Nurse update(String id, Nurse nurse) {
        nurse.setNurseId(id);
        Nurse nurse1=nurseRepository.save(nurse);
        return nurse1;
    }

    @Override
    public void delete(String id) {
        nurseRepository.deleteById(id);

    }
}
