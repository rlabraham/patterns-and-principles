package com.rabraham.patterns.servicelocator.impl;

import com.rabraham.patterns.servicelocator.Service;

public class ServiceLocator {
    private static Cache cache;

    static {
        cache = new Cache();
    }

    public static Service getService(String jndiName){

        Service service = cache.getService(jndiName);

        if (service == null){
            InitialContext context = new InitialContext();
            service = (Service) context.lookup(jndiName);
            cache.addService(service);
        }

        return service;
    }
}
