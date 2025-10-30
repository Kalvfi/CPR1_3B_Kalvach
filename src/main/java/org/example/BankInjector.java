package org.example;

import com.google.inject.AbstractModule;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class BankInjector extends AbstractModule {
    protected void configure() {
        bind(Scanner.class).toInstance(new Scanner(System.in));
        bind(ScheduledExecutorService.class).toInstance(Executors.newSingleThreadScheduledExecutor());
    }
}
