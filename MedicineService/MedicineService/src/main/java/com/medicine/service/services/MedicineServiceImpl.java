package com.medicine.service.services;

import com.medicine.service.entities.Medicine;
import com.medicine.service.exceptions.ResourceNotFoundException;
import com.medicine.service.repositories.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class MedicineServiceImpl implements MedicineService{
    @Autowired
    private MedicineRepository medicineRepository;
    @Override
    public Medicine create(Medicine medicine) {
        String randomId= UUID.randomUUID().toString();
        medicine.setMedicineId(randomId);
        return medicineRepository.save(medicine);
    }

    @Override
    public List<Medicine> getall() {
        return medicineRepository.findAll();
    }

    @Override
    public Medicine getById(String id) {
        return medicineRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("medicine with this id doesnt exist"+id));
    }

    @Override
    public Medicine update(String id, Medicine medicine) {
        medicine.setMedicineId(id);
        Medicine medicine1=medicineRepository.save(medicine);
        return medicine1;
    }

    @Override
    public void delete(String id) {
        medicineRepository.deleteById(id);

    }
}
