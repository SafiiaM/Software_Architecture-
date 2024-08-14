//1. Абстрактный класс Car


package Homework_3.SOLID;

import java.awt.*;

public abstract class Car {
    private String make;
    private String model;
    private Color color;
    private TypeCar bodyType;
    private int numberWheels;
    private TypeFuel fuel;
    private TypeGearbox gearbox;
    private float engineCap;

    public Car(String make,
               String model,
               Color color,
               TypeCar bodyType,
               int numberWheels,
               TypeFuel fuel,
               TypeGearbox gearbox,
               float engineCap) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.bodyType = bodyType;
        this.numberWheels = numberWheels;
        this.fuel = fuel;
        this.gearbox = gearbox;
        this.engineCap = engineCap;
    }

    // Getters and setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public TypeCar getBodyType() {
        return bodyType;
    }

    public void setBodyType(TypeCar bodyType) {
        this.bodyType = bodyType;
    }

    public int getNumberWheels() {
        return numberWheels;
    }

    public void setNumberWheels(int numberWheels) {
        this.numberWheels = numberWheels;
    }

    public TypeFuel getFuel() {
        return fuel;
    }

    public void setFuel(TypeFuel fuel) {
        this.fuel = fuel;
    }

    public TypeGearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(TypeGearbox gearbox) {
        this.gearbox = gearbox;
    }

    public float getEngineCap() {
        return engineCap;
    }

    public void setEngineCap(float engineCap) {
        this.engineCap = engineCap;
    }

    // Abstract methods for specific actions
    public abstract void movement();  // Абстрактный метод для движения

    public abstract void maintenance();  // Абстрактный метод для обслуживания

    public abstract int gearShift(int gear);  // Абстрактный метод для переключения передач

    public boolean turnLights() {  // Метод для включения фар
        return true;
    }

    public boolean turnWipers() {  // Метод для включения дворников
        return true;
    }
}
