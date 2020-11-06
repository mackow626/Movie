package com.company;

public abstract class Person {
    String name;

    abstract int payment(int base);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }
}
