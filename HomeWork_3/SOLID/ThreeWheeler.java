// 5. Создание автомобиля с числом колёс = 3 и проверка принципа LSP
//Создадим класс ThreeWheeler с тремя колесами.
// Этот класс не нарушает принцип подстановки Лисков (LSP), так как поведение остается логичным для трехколесного автомобиля.

package HomeWork_3.SOLID;

import java.awt.*;

class ThreeWheeler extends Car {
    public ThreeWheeler(String make, String model, Color color, TypeFuel fuel, TypeGearbox gearbox, float engineCap) {
        super(make, model, color, TypeCar.THREE_WHEELER, 3, fuel, gearbox, engineCap);
    }

    @Override
    public void movement() {
        System.out.println("The three-wheeler is moving.");
    }

    @Override
    public void maintenance() {
        System.out.println("The three-wheeler is undergoing maintenance.");
    }

    @Override
    public int gearShift(int gear) {
        System.out.println("The three-wheeler has shifted to gear " + gear);
        return gear;
    }
}



