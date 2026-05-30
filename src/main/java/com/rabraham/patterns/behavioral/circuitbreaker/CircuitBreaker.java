package com.rabraham.patterns.behavioral.circuitbreaker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.concurrent.CircuitBreakingException;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

@Getter @Setter @AllArgsConstructor
public class CircuitBreaker {
    private final CircuitBreakerStateStore stateStore = new CircuitBreakerStateStoreImpl();
    private final Object halfOpenSyncObject = new Object();

    private final long openToHalfOpenWaitTime = 1L;

    public boolean isClosed() {
        return stateStore.isClosed();
    }

    public boolean isOpen() {return !isClosed();}

    private final ReentrantLock lock = new ReentrantLock();

    public void ExecuteAction(Method method, Object object, Object...args) throws Exception {
        if (isOpen()) {
            if (stateStore.getLastStateChangedDateUtc().plusSeconds(openToHalfOpenWaitTime).isBefore(LocalDateTime.now())) {
                try {
                    if (lock.tryLock()) {
                        stateStore.halfOpen();
                        method.invoke(object, args);
                        stateStore.reset();
                        return;
                    }
                } catch (Exception e) {
                    stateStore.trip(e);
                }
                finally {
                    if (lock.tryLock()) {
                        lock.unlock();
                    }
                }
            }
            throw new CircuitBreakingException(stateStore.getLastException());
        }
        try {
            method.invoke(object, args);
        } catch (Exception e) {
            trackException(e);
            throw e;
        }
    }

    private void trackException(Exception ex) {
        System.out.println(ex.getMessage());
    }
}
