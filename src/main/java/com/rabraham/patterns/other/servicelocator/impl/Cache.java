package com.rabraham.patterns.other.servicelocator.impl;

import com.rabraham.patterns.other.servicelocator.Service;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Cache {
    private List<Service> services;

    public Cache(){
        services = new ArrayList<Service>();
    }

    public Service getService(String serviceName){
        for (Service service : services) {
            if(StringUtils.equalsIgnoreCase(service.getName(), serviceName)){
                log.info("Returning cached {} object", serviceName);
                return service;
            }
        }
        return null;
    }

    public void addService(Service newService){
        final List<String> serviceNames = services.stream().map(Service::getName).collect(Collectors.toList());
        final boolean exists = serviceNames.stream().anyMatch(newService.getName()::equalsIgnoreCase);

        if(!exists){
            services.add(newService);
        }
    }
}
