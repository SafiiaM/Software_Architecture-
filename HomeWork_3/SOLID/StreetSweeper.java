// Интерфейс iWiping отвечает только за задачи, связанные с протиркой стекол, фар и зеркал, и его не нужно изменять.
//Для задачи подметания улиц создан отдельный интерфейс iStreetCleaning, что соответствует принципу SRP.
// Есть автомобиль, который должен подметать улицы, реализован интерфейс iStreetCleaning в классе StreetSweeper.
// Таким образом, метод sweepStreet будет ответственностью отдельного интерфейса StreetCleaning, что соответствует принципу SRP.

package HomeWork_3.SOLID;

import java.awt.*;

public class StreetSweeper extends Car implements iStreetCleaning {

    public StreetSweeper(String make, String model, Color color, int numberWheels, TypeFuel fuel, TypeGearbox gearbox, float engineCap) {
        super(make, model, color, TypeCar.SEDAN, numberWheels, fuel, gearbox, engineCap);
    }

    @Override
    public void movement() {
        System.out.println("The street sweeper is moving.");
    }

    @Override
    public void maintenance() {
        System.out.println("The street sweeper is being serviced.");
    }

    @Override
    public int gearShift(int gear) {
        System.out.println("The street sweeper has shifted to gear " + gear);
        return gear;
    }

    @Override
    public void sweepStreet() {
        System.out.println("The street sweeper is sweeping the street.");
    }
}
