package sa.presenters;

import sa.models.Table;

import java.util.Collection;
import java.util.Date;

public interface View {

    /**
     * Отображение списка столиков в приложении
     * @param tables список столиков
     */
    void showTables(Collection<Table> tables);

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер брони
     */
    void showReservationTableResult(int reservationNo);

    /**
     * Отобразить результат изменения бронирования столика
     * @param reservationNo номер нового бронирования
     */
    void showChangeReservationTableResult(int reservationNo);

    /**
     * Установить наблюдателя для представления
     * @param observer наблюдатель
     */
    void setObserver(ViewObserver observer);

    /**
     * Клиент нажал на кнопку резерва столика
     * @param orderDate дата резерва
     * @param tableNo номер столика
     * @param name имя клиента
     */
    void reservationTable(Date orderDate, int tableNo, String name);

    /**
     * Изменение бронирования столика
     * @param oldReservation идентификатор старой брони
     * @param reservationDate новая дата резерва
     * @param tableNo номер нового столика
     * @param name имя клиента
     */
    void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);

    /**
     * Отмена бронирования столика
     * @param reservationNo идентификатор бронирования
     * @return true, если бронирование успешно отменено, иначе false
     */

}
