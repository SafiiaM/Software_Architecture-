// 9. Реализация заправки автомобилей с бензиновым и дизельным двигателями
//Создадим два класса автомобилей и реализуем метод заправки соответствующим топливом
// Получим классы автомобилей, которые заправляются подходящим топливом, что соответствует принципам SOLID.
// Метод DIP

package HomeWork_3.SOLID;

import java.awt.*;

public class DieselTruck extends Car implements iRefueling {
    public DieselTruck(String make, String model, Color color, TypeGearbox gearbox, float engineCap) {
        super(make, model, color, TypeCar.DIESEL_TRUCK, 6, TypeFuel.DIESEL, gearbox, engineCap);
    }

    @Override
    public void movement() {
        System.out.println("The diesel truck is hauling heavy loads.");
    }

    @Override
    public void maintenance() {
        System.out.println("The diesel truck is undergoing maintenance.");
    }

    @Override
    public int gearShift(int gear) {
        System.out.println("The diesel truck has shifted to gear " + gear);
        return gear;
    }

    @Override
    public void fuel() {
        System.out.println("The diesel truck is being refueled with diesel.");
    }
}
