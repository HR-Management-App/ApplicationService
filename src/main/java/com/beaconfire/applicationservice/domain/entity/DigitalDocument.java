package com.beaconfire.applicationservice.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "digitaldocument")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DigitalDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int digitalDocumentID;

    @Column(name = "type")
    private String type;
    @Column(name = "is_required")
    private boolean isRequired;
    @Column(name = "path")
    private String path;
    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title;
}