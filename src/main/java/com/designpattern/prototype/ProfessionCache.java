package com.designpattern.prototype;

import java.util.Hashtable;

public class ProfessionCache {

    private static Hashtable<Integer, Profession> professionHashtable = new Hashtable<>();

    private static Profession getCloneNewProfession(int id){
        Profession profession = professionHashtable.get(id);
        return (Profession) profession.cloningMethod();
    }

    public static void loadCache(){
        Doctor doctor = new Doctor();
        doctor.id = 1;

        professionHashtable.put(doctor.id, doctor);

        Engineer engineer = new Engineer();
        engineer.id = 2;

        professionHashtable.put(engineer.id, engineer);
    }

    public static void main(String[] args) {
        ProfessionCache.loadCache();

        Profession docProfession = ProfessionCache.getCloneNewProfession(1);
        System.out.println(docProfession);

        Profession engProfession =ProfessionCache.getCloneNewProfession(2);
        System.out.println(engProfession);

        Profession doc2Profession = ProfessionCache.getCloneNewProfession(1);
        System.out.println(doc2Profession);
    }
}
