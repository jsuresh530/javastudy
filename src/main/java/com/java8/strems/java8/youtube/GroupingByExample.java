package com.java8.strems.java8.youtube;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

class Employee {
    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", Salary='"+salary+'\''+
                ", Dep='"+dep+'\''+
                '}';
    }

    private String id;
    private String name;
    private String city;
    private double salary;
    private String dep;


    public Employee(){}

    public Employee(String id, String name, String city, double salary, String dep){
        this.id = id;
        this.name = name;
        this.city = city;
        this.salary = salary;
        this.dep = dep;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
public class GroupingByExample {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<> ();
        createEmpList(employeeList);

        final Map<String, List<Employee>> empMap = employeeList.stream ().collect (Collectors.groupingBy (Employee::getCity));
        empMap.forEach ((k,v) -> System.out.println ("City: "+k+" : \t value: "+v));

        employeeList.forEach (emp -> System.out.println ("Before : "+emp.getCity ()+": "+emp.getName ()));

        employeeList.sort (Comparator.comparing (Employee::getName).thenComparing (employee -> employee.getCity ()));

        employeeList.forEach (emp -> System.out.println (emp.getCity ()+": "+emp.getName ()));

        employeeList.stream ().map (employee -> employee.getName ()+",").forEach (System.out::print);
        //Max salary of an employee

        final Optional<Employee> higestEmployee = employeeList.stream ().
                collect (Collectors.maxBy (Comparator.comparingDouble (Employee::getSalary)));
        // minBy
        System.out.println ("\n"+higestEmployee.get ());
        //FInd second-highest salary of the employee
        final List<Employee> salaryList = employeeList.stream ().sorted (Comparator.comparingDouble (Employee::getSalary).reversed ())
                .collect (Collectors.toList ());
        System.out.print (salaryList.get (1));

        //max salary of an employee from each department
        final Map<String, Optional<Employee>> collect = employeeList.stream ().collect (Collectors.groupingBy (Employee::getDep,
                Collectors.reducing (BinaryOperator.maxBy (Comparator.comparing (Employee::getSalary)))));

        collect.forEach ((k,v) -> System.out.println ("\n"+k+"  v  \n"+v.get ()));

        //Active and in active emp list :
        final Map<String, Long> collect1 = employeeList.stream ().filter (emp -> emp.getDep ().equalsIgnoreCase ("IT"))
                .collect (Collectors.groupingBy (Employee::getDep, Collectors.counting ()));

        System.out.println (collect1);
        //employee count
        final Map<String, List<Employee>> collect2 = employeeList.stream ().collect
                (Collectors.groupingBy (Employee::getDep));

        System.out.println (collect2);

        final String reduce = employeeList.stream ().map (Employee::getCity).reduce ("", String::concat);
        final String collect3 = employeeList.stream ().map (Employee::getCity).collect (Collectors.joining (","));
        System.out.println ("reduce : "+reduce+" collect3 : "+collect3);
    }

    private static void createEmpList(List<Employee> employeeList) {
        employeeList.add (new Employee ("2","suresh", "Hyd",23000.00, "IT"));
        employeeList.add (new Employee ("9","java", "newyork",56788.00, "IT"));
        employeeList.add (new Employee ("6","gemini", "delhi",2345.00, "IT"));
        employeeList.add (new Employee ("44","octo", "bombay",5678.00, "Global"));
        employeeList.add (new Employee ("14","namo", "oto",12345.966, "Global"));

    }
}
