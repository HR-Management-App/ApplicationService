package com.beaconfire.applicationservice.domain.request;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationUpdateRequest {

    private int id;

    private String status;

    private String comment;
}