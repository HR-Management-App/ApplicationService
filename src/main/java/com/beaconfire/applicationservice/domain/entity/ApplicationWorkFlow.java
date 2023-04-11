package com.beaconfire.applicationservice.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "application_work_flow")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationWorkFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "employee_id")
    private int employee_id;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "last_modification_date")
    private Date last_modification_date;

    @Column(name = "status")
    private String status;

    @Column(name = "comment")
    private String comment;
}