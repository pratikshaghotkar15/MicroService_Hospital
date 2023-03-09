package com.medicine.service.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="medicines")
public class Medicine {
    @Id
    private String medicineId;
    private String nameOfMedicine;
    private String useOfMedicine;
    private String contentsUsed;
}
