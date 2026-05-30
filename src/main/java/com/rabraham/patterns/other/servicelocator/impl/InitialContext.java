package com.rabraham.patterns.other.servicelocator.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class InitialContext {
    public Object lookup(String jndiName){

        if(StringUtils.equalsIgnoreCase(jndiName, "SERVICE1")){
            log.info("Looking up and creating a new Service1 object");
            return new Service1();
        }
        else if (StringUtils.equalsIgnoreCase(jndiName, "SERVICE2")){
            log.info("Looking up and creating a new Service2 object");
            return new Service2();
        }
        return null;
    }
}
