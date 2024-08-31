package sa.models;

import sa.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    /**
     * Получение списка всех столиков
     */
    public Collection<Table> loadTables() {

        if (tables == null){
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    /**
     * Бронирование столика
     * @param reservationDate Дата бронирования
     * @param tableNo Номер столика
     * @param name Имя
     */
    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        // Правильное использование цикла for
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }

        // Бросаем исключение, если бронирование не удалось
        throw new RuntimeException("Ошибка бронирования столика. Повторите попытку позже.");
    }

    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        return 0;
    }
}

