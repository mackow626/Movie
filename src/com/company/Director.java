package com.company;

public class Director extends Person {
    public Director(String name) {
        super(name);
    }

    @Override
    int payment(int base) {
        return base*3;
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                '}';
    }
}
