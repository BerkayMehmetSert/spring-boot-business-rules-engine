package com.bms.businessrulesengine.core.utilities.services;


import java.util.function.Supplier;


public class BusinessRules {
    public static void run(Runnable... logics) {
        for (var logic : logics) {
            logic.run();
        }
    }

    public static <T> T run(Supplier<T>... logics) {
        for (var logic : logics) {
            return logic.get();
        }
        return null;
    }
}
