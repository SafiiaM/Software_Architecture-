package sa.views;

import sa.models.Table;
import sa.presenters.View;
import sa.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private ViewObserver observer;

    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Столик успешно забронирован. Номер Вашей брони: Столик №%d\n", reservationNo);
        } else {
            System.out.println("Что-то пошло не так, попробуйте повторить попытку позже");
        }
    }

    @Override
    public void showChangeReservationTableResult(int reservationNo) {

    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования)
     * @param orderDate Дата бронирования
     * @param tableNo Номер столика
     * @param name Имя
     */
    public void reservationTable(Date orderDate, int tableNo, String name) {
        if (observer != null) {
            observer.onReservationTable(orderDate, tableNo, name);
        }
    }

    /**
     * Доработать самостоятельно в рамках домашней работы
     * Действие клиента: пользователь нажал на кнопку изменения резерва
     * @param oldReservation идентификатор бронирования (старый)
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        System.out.printf("Номер бронирования %d изменен на столик %d для %s на %s%n", oldReservation, tableNo, name, reservationDate.toString());
    }
}
