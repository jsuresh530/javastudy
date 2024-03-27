package com.designpattern.abstractfactory;

public class Engineer implements Profession{
    @Override
    public void Print() {
        System.out.println("I am from Engineer class");
    }
}
