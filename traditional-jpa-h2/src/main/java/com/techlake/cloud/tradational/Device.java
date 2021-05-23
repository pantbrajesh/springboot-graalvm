package com.techlake.cloud.tradational;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "device")
public class Device {

    @Id
    private Integer id;

    @Column(name = "device_type")
    private String deviceType;

    @Column(name = "device_name")
    private String deviceName;
}
