package com.multithreads;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person implements Serializable {
    private int id;

    public Person(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
public class ParallelSaveOperation
{

    public static final String DIRECTORY = System.getProperty ("user.dir")+"/test/";
    public static void main(String[] args) throws IOException {
        Files.createDirectories (Paths.get (DIRECTORY));

        ParallelSaveOperation saveOperation = new ParallelSaveOperation ();
        final List<Person> people = saveOperation.generatePerson (1000);

        long time = System.currentTimeMillis ();
        people.stream ().forEach (ParallelSaveOperation::save);
        System.out.println ("Time taken : "+(System.currentTimeMillis ()-time));

        time = System.currentTimeMillis ();
        people.stream ().parallel ().forEach (ParallelSaveOperation::save);
        System.out.println ("Time taken : "+(System.currentTimeMillis ()-time));


    }

    private static void save(Person person){

        try(FileOutputStream fos = new FileOutputStream (new File (DIRECTORY+person.getId ()+".txt"))) {

        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    private List<Person> generatePerson(int num){

        return Stream.iterate (0, n->n+1)
                .limit (num)
                .map (x -> {
                    return  new Person (x);
                }).collect(Collectors.toList());
    }
}
