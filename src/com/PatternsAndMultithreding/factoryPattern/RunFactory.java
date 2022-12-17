package com.PatternsAndMultithreding.factoryPattern;

public class RunFactory {
    public static void main(String[] args) {

        FactoryDeveloper developer = createDevelopers("java");
        developer.createDeveloper().write();
        FactoryDeveloper developerCpp = createDevelopers("cpp");
        developerCpp.createDeveloper().write();
    }


    private static FactoryDeveloper createDevelopers(String str){
        if(str.equalsIgnoreCase("java")){
            return new JavaFactoryDeveloper();
        }else if(str.equalsIgnoreCase("cpp")){
            return new CppFactoryDeveloper();
        }else{
            throw new IllegalCallerException("invalid value!!!");
        }
    }
}
