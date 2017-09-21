package com.katsura.annotations;

@Description("I am class annotation")
public class Child implements Person{

    @Description("I am method annotation")
    @Override
    public String name() {
        return null;
    }

    @Description("I am method annotation")
    @Override
    public int age() {
        return 0;
    }

    @Description("I am method annotation")
    @Override
    public void sing() {

    }
}
