package com.mokito2;

public class TestApp {

    CalculatorService service;

    public void setCalculatorService(CalculatorService service) {
        this.service = service;
    }

    public double add(double a, double b) {
        return service.add(a, b);
    }

    public double sub(double a, double b) {
        return service.sub(a, b);
    }

    public double multi(double a, double b) {
        return service.mul(a, b);
    }

    public double divide(double a, double b) {
        return service.div(a, b);
    }
}
