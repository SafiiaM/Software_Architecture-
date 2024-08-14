// 4. Расширение абстрактного класса Car, добавление методов включения противотуманных фар и перевозки груза, проверка
// принципа OCP
//В данном случае добавление новых методов можно реализовать через расширение функциональности без изменения
// базового класса, что соответствует принципу OCP (Open-Closed Principle).

package HomeWork_3.SOLID;

import java.awt.*;

public class Pickup extends Car {
    private boolean fogLightsOn;
    private int cargoWeight;

    public Pickup(String make, String model, Color color, int numberWheels, TypeFuel fuel, TypeGearbox gearbox, float engineCap) {
        super(make, model, color, TypeCar.PICKUP, numberWheels, fuel, gearbox, engineCap);
        this.fogLightsOn = false;
        this.cargoWeight = 0;
    }

    @Override
    public void movement() {
        System.out.println("The pickup is driving off-road.");
    }

    @Override
    public void maintenance() {
        System.out.println("The pickup is being serviced.");
    }

    @Override
    public int gearShift(int gear) {
        System.out.println("The pickup has shifted to gear " + gear);
        return gear;
    }

    public void turnFogLightsOn() {
        this.fogLightsOn = true;
        System.out.println("Fog lights are turned on.");
    }

    public void turnFogLightsOff() {
        this.fogLightsOn = false;
        System.out.println("Fog lights are turned off.");
    }

    public void loadCargo(int weight) {
        this.cargoWeight += weight;
        System.out.println(weight + " kg of cargo loaded. Total cargo: " + this.cargoWeight + " kg.");
    }

    public void unloadCargo(int weight) {
        this.cargoWeight -= weight;
        System.out.println(weight + " kg of cargo unloaded. Remaining cargo: " + this.cargoWeight + " kg.");
    }
}
