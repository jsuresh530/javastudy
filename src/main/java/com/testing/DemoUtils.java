package com.testing;

import java.util.Arrays;
import java.util.List;

public class DemoUtils {
    private String academy = "Suresh academy";
    private String academyDuplicate = academy;
    private String[] firstThreeLetters = {"A","B","C"};
    private List<String> academyList = Arrays.asList ("jaava","code","test");

    public List<String> getAcademyList() {
        return academyList;
    }

    public String getAcademy() { return academy; }

    public String getAcademyDuplicate() {return academyDuplicate; }

    public String[] getFirstThreeLetters() {
        return firstThreeLetters;
    }

    public int add(int a, int b) { return a+b;}

    public int multiply(int a, int b){return a*b; }

    public Object checkNull(Object obj){
        if(obj != null){
            return obj;
        }
        return null;
    }

    public Boolean isGreater (int n1, int n2){
        if(n1 > n2) {
            return true;
        }
        return false;
    }

    public String throwException(int a) throws Exception{
        if(a < 0){
            throw new Exception ("Value shoulb de greater than or equal to zero ");
        }
        return "value is greater than or equal to 0";
    }

    public void checkTimeout() throws InterruptedException {
        System.out.println ("Going to sleep ");
        Thread.sleep (2000);
        System.out.println ("Sleeping over");
    }

}
