package com.nurseService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name="nurse_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Nurse {
    @Id
    private String nurseId;
    private String name;
    private String qualification;
    private String contactNo;

    private String joining;

}
