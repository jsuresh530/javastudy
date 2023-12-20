package com.coreexamples.CoreJava;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ServiceStartStop {
    public static void main(String args[]) {
        String[] command = {"cmd.exe", "/c", "sc", "start", "1027"};
        try {
            Process process = new ProcessBuilder(command).start();
            InputStream inputStream = process.getInputStream(); 
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception ex) {
        	ex.printStackTrace();
            System.out.println("Exception : "+ex);
        }
    }
}