package com.company;

public class Actors extends Person {
    public Actors(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Actors{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
   public int payment(int base) {
        return base*2;
    }
}
