package com.rabraham.patterns.other.servicelocator.impl;

import com.rabraham.patterns.other.servicelocator.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Service1 implements Service {
    @Override
    public String getName() {
        return "Service1";
    }

    @Override
    public void execute() {
        log.info("Executing Service1");
    }
}
