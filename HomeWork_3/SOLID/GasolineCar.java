/* 9. Реализация заправки автомобилей с бензиновым и дизельным двигателями
Создадим два класса автомобилей и реализуем метод заправки соответствующим топливом
Получим классы автомобилей, которые заправляются подходящим топливом, что соответствует принципам SOLID.
Метод DIP*/

package HomeWork_3.SOLID;

import java.awt.*;

public class GasolineCar extends Car implements iRefueling {
    public GasolineCar(String make, String model, Color color, TypeGearbox gearbox, float engineCap) {
        super(make, model, color, TypeCar.GASOLINE_CAR, 4, TypeFuel.GASOLINE, gearbox, engineCap);
    }

    @Override
    public void movement() {
        System.out.println("The gasoline car is driving smoothly on the highway.");
    }

    @Override
    public void maintenance() {
        System.out.println("The gasoline car is undergoing maintenance.");
    }

    @Override
    public int gearShift(int gear) {
        System.out.println("The gasoline car has shifted to gear " + gear);
        return gear;
    }

    @Override
    public void fuel() {
        System.out.println("The gasoline car is being refueled with gasoline.");
    }
}

    /* У меня есть два новых типа автомобилей (DIESEL_TRUCK и GASOLINE_CAR), каждый из которых реализует заправку
     соответствующим типом топлива, что демонстрирует соблюдение принципа SRP (Single Responsibility Principle) и
     обеспечивает поддержку принципа OCP (Open/Closed Principle), поскольку добавление новых типов автомобилей происходит
     через расширение классов.

     Для проверки принципа DIP (Dependency Inversion Principle) в контексте вашей задачи необходимо обратить внимание на следующие моменты:

     Интерфейсы вместо конкретных реализаций:

     Принцип DIP гласит, что высокоуровневые модули не должны зависеть от низкоуровневых модулей. Оба должны зависеть от абстракций (интерфейсов).
     В данном случае, класс Car (или его наследники) должны зависеть не от конкретных классов заправки (например, дизельной или бензиновой станции), а от абстрактного интерфейса iRefueling.
     Имплементация интерфейсов:

     Каждый класс автомобиля (например, бензиновый или дизельный) имплементирует интерфейс iRefueling, который определяет метод fuel().
     В этом случае автомобили зависят от интерфейса заправки, а не от конкретной реализации, что и проверяет принцип DIP.
     Внедрение зависимостей:

     Для полного соблюдения принципа DIP нужно, чтобы зависимость от интерфейса iRefueling внедрялась извне (например, через конструктор или сеттеры), а не создавалась внутри классов автомобилей.
     Таким образом, проверка принципа DIP будет достигнута, если:

     Автомобили не зависят от конкретных классов заправки.
     Зависимости внедряются через абстракции (интерфейсы).*/