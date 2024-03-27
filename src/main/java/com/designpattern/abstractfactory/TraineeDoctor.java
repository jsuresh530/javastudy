package com.designpattern.abstractfactory;

public class TraineeDoctor implements Profession{
    @Override
    public void Print() {
        System.out.println("I am from Trainee Doctor class");
    }
}
