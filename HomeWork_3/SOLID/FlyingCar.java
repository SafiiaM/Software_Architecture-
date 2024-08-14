// 6. Создание автомобиля с методом move = "полёт" и проверка принципа LSP
// Этот класс FlyingCar может нарушить принцип LSP, если считать, что поведение "полёт" нарушает ожидаемое поведение
// автомобильного передвижения. То есть использование этого класса вместо обычного автомобиля может привести к неожиданным последствиям.


package HomeWork_3.SOLID;

import java.awt.*;

class FlyingCar extends Car {
    public FlyingCar(String make, String model, Color color, TypeFuel fuel, TypeGearbox gearbox, float engineCap) {
        super(make, model, color, TypeCar.FLYING_CAR, 4, fuel, gearbox, engineCap);
    }

    @Override
    public void movement() {
        System.out.println("The flying car is flying in the air.");
    }

    @Override
    public void maintenance() {
        System.out.println("The flying car is undergoing maintenance.");
    }

    @Override
    public int gearShift(int gear) {
        System.out.println("The flying car has shifted to gear " + gear + " while flying.");
        return gear;
    }

    public void takeOff() {
        System.out.println("The flying car is taking off.");
    }

    public void land() {
        System.out.println("The flying car is landing.");
    }
}
