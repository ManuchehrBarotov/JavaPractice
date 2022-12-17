package com.PatternsAndMultithreding.factoryPattern;

public class JavaFactoryDeveloper implements FactoryDeveloper{
    @Override
    public Developer createDeveloper() {
        return new JavaDeveloper();
    }
}
