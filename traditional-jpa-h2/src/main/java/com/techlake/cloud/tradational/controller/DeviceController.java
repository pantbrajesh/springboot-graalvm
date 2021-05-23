package com.techlake.cloud.tradational.controller;

import com.techlake.cloud.tradational.Device;
import com.techlake.cloud.tradational.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class DeviceController {
    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping("/device/all")
    public List<Device> getDevices(){
        List<Device> devices = new ArrayList<>();
        Iterator<Device> iterator = deviceRepository.findAll().iterator();
        while(iterator.hasNext()){
            devices.add(iterator.next());
        }
        return devices;

    }

    @PutMapping("/device/add")
    public boolean addDevice(@RequestBody  Device device){
        deviceRepository.save(device);
        return true;
    }
}
