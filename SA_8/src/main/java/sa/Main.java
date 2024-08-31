package sa;

import sa.presenters.BookingPresenter;
import sa.presenters.Model;
import sa.presenters.View;
import sa.views.BookingView;
import sa.models.TableModel;
import java.util.Date;

public class Main {

    /**
     * TODO: ДЗ: Метод changeReservationTable ДОЛЖЕН ЗАРАБОТАТЬ
     * @param args
     */
    public static void main(String[] args) {

        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);

        presenter.updateUIShowTables();

        view.reservationTable(new Date(), 2, "Станислав");

        // Исправление вызова конструктора Date
        view.changeReservationTable(1001, new Date(), 3, "Станислав");
    }
}

