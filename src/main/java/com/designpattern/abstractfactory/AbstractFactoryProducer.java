package com.designpattern.abstractfactory;

public class AbstractFactoryProducer {

    public static AbstractFactory getProfession(boolean isTrainee){
        if(isTrainee){
            return new TraineeProfessionAbstractFactory();
        }else{
            return  new ProfessionAbstractFactory();
        }
    }


    public static void main(String[] args) {
        AbstractFactory profession = getProfession(true);

        Profession doctor = profession.getProfession("Doctor");

        doctor.Print();
    }
}
