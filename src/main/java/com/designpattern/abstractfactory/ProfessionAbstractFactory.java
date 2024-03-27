package com.designpattern.abstractfactory;

/**
 *
 */
public class ProfessionAbstractFactory extends AbstractFactory{
    @Override
    Profession getProfession(String professionType) {

        if(professionType == null) return null;
        else if(professionType.equalsIgnoreCase("Doctor"))
            return new Doctor();
        else if(professionType.equalsIgnoreCase("Engineer"))
            return new Engineer();
        return null;
    }
}
