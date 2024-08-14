// 7. Интерфейс «Заправочная станция» и реализация метода заправки
// 8. Добавление методов в интерфейс и проверка принципа ISP


package HomeWork_3.SOLID;

import java.awt.*;

public class SUV extends Car implements iRefueling, iCleaning {
    public SUV(String make, String model, Color color, TypeFuel fuel, TypeGearbox gearbox, float engineCap) {
        super(make, model, color, TypeCar.SUV, 4, fuel, gearbox, engineCap);
    }

    @Override
    public void movement() {
        System.out.println("The SUV is driving off-road.");
    }

    @Override
    public void maintenance() {
        System.out.println("The SUV is undergoing maintenance.");
    }

    @Override
    public int gearShift(int gear) {
        System.out.println("The SUV has shifted to gear " + gear);
        return gear;
    }

    @Override
    public void fuel() {
        System.out.println("The SUV is being refueled with " + getFuel() + ".");
    }

    @Override
    public void cleanWindshield() {
        System.out.println("The SUV's windshield is being cleaned.");
    }

    @Override
    public void cleanHeadlights() {
        System.out.println("The SUV's headlights are being cleaned.");
    }

    @Override
    public void cleanMirrors() {
        System.out.println("The SUV's mirrors are being cleaned.");
    }
}
