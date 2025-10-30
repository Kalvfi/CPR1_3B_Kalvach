package org.example;

import com.google.inject.AbstractModule;

import java.util.Scanner;

public class BankInjector extends AbstractModule {
    protected void configure() {
        bind(Scanner.class).toInstance(new Scanner(System.in));
    }
}
