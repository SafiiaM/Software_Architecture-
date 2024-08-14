//2. Создание конкретного класса автомобиля
package HomeWork_3.SOLID;

import java.awt.*;

public class Sedan extends Car {

    public Sedan(String make, String model, Color color, int numberWheels, TypeFuel fuel, TypeGearbox gearbox, float engineCap) {
        super(make, model, color, TypeCar.SEDAN, numberWheels, fuel, gearbox, engineCap);
    }

    @Override
    public void movement() {
        System.out.println("The sedan is moving smoothly on the road.");
    }

    @Override
    public void maintenance() {
        System.out.println("The sedan is undergoing routine maintenance.");
    }

    @Override
    public int gearShift(int gear) {
        System.out.println("The sedan has shifted to gear " + gear);
        return gear;
    }

    @Override
    public boolean turnLights() {
        System.out.println("The sedan's lights are turned on.");
        return true;
    }

    @Override
    public boolean turnWipers() {
        System.out.println("The sedan's wipers are turned on.");
        return true;
    }
}
