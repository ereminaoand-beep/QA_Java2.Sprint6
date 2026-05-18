package com.example;

import java.util.List;

public class Lion extends Feline {
    private final boolean hasMane;
    private final Feline feline;


    public Lion(Feline feline, String sex) throws Exception {
        super();
        this.feline = feline;

        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public boolean doesHaveMane() {
        return hasMane;
    }


    public int getKittens() {
        return feline.getKittens(); // делегируем feline
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}