package com.ruckus.cloud.reactive;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("device")
public class Device {

    @Id
    private Integer id;
    private String type;
    private String name;

}
