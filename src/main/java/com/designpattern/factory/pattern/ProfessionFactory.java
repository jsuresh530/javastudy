package com.designpattern.factory.pattern;

public class ProfessionFactory {

    public Profession getProfession(String professionType){
        if(professionType == null)
            return null;
        if(professionType.equalsIgnoreCase("Doctor"))
            return new Doctor();
        else if (professionType.equalsIgnoreCase("Teacher")) {
            return new Teacher();
        } else if (professionType.equalsIgnoreCase("Engineer")) {
            return new Doctor();
        }
        return  null;
    }

    public static void main(String[] args) {
        ProfessionFactory professionFactory = new ProfessionFactory();
        Profession profession = professionFactory.getProfession("Doctor");

        profession.print();

    }
}
