package com.designpattern.factory.pattern;

public class Teacher implements Profession{
    @Override
    public void print() {
        System.out.println("I am from Teacher class");
    }
}
