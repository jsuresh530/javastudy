package com.designpattern.abstractfactory;

public class Doctor implements Profession{

    @Override
    public void Print() {
        System.out.println("I am from Doctor Class");
    }
}
