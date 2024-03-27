package com.designpattern.factory.pattern;

public class Doctor implements Profession{
    @Override
    public void print() {
        System.out.println("I am from Doctor Class");
    }
}
