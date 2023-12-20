package com.logic;

import java.io.IOException;

interface Test {
int a =10;
}
//Runtime error, when there was no static to main method,
//can't assign interface values in main method. final values can be modified.
//A. We can have static block in a class. it gets executed only once when class loads
//

class Super {
    private void foo() {
        System.out.println("Super");
    }
}

class Subclass extends Super {
    public void foo() {
        System.out.println("Subclass");
    }
}
public class InterfaceTest {

    public static void main(String[] args, int u) {
        Object o = new Object ();
    }

    public String toString() {
        System.out.println("Test toString called");
        return "";
    }
    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = "abc";
        System.out.println("s1 == s2 is:" + s1 == s2);

        try {
            throw new IOException ("Hello");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            throw new Exception("Hello ");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } finally {
            System.out.println("World");
        }

   // Test.a =20;
        Subclass s5 = new Subclass();
        s5.foo(); // line 6
        Super s = new Subclass();
        //s.foo(); // line 8

    }
}
