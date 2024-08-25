package main.java.org;

import main.java.org.database.NotesDatabase;
import main.java.org.notes.core.application.ConcreteNoteEditor;
import main.java.org.notes.core.domain.Note;
import main.java.org.notes.infrastructure.persistance.NotesDbContext;
import main.java.org.notes.presentation.queries.controllers.NotesController;
import main.java.org.notes.presentation.queries.views.NotesConsolePresenter;

/**
 * ДЗ6
 * Разработать краткую схему (UML-диаграмму) модулей взаимодействия наших приложений и попытаться отобразить взаимодействие между
 * контроллером, презентером, соответствующим интерфейсом и бизнес-логикой или протянуть какую-то новую фичу, как в ДЗ5,
 * например, в рамках метода main добавить запись или удалить запись (эмуляция работы веб-приложения)
 */


public class Program2 {

    public static void main(String[] args) {
        // Инициализация всех необходимых компонентов
        NotesDatabase notesDatabase = new NotesDatabase();
        NotesDbContext dbContext = new NotesDbContext(notesDatabase);
        NotesConsolePresenter consolePresenter = new NotesConsolePresenter();
        ConcreteNoteEditor noteEditor = new ConcreteNoteEditor(dbContext, consolePresenter);
        NotesController controller = new NotesController(noteEditor);

        // Используем существующие методы для добавления и удаления заметок
        Note existingNote = dbContext.getAll().stream().findFirst().orElse(null); // Получаем первую существующую заметку для теста

        if (existingNote != null) {
            System.out.println("Добавление существующей заметки:");
            controller.routeAddNote(existingNote); // Добавление заметки
            controller.routeGetAll(); // Отображение всех заметок

            System.out.println("Удаление существующей заметки:");
            controller.routeRemoveNote(existingNote); // Удаление заметки
            controller.routeGetAll(); // Отображение всех заметок после удаления
        } else {
            System.out.println("Нет заметок для тестирования.");
        }
    }
}
