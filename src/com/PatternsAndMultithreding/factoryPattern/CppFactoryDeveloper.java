package com.PatternsAndMultithreding.factoryPattern;

public class CppFactoryDeveloper implements FactoryDeveloper{
    @Override
    public Developer createDeveloper() {
        return new CppDeveloper();
    }
}
