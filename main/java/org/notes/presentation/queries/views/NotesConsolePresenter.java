package main.java.org.notes.presentation.queries.views;

import main.java.org.notes.core.application.interfaces.NotesPresenter;
import main.java.org.notes.core.domain.Note;

import java.util.Collection;

public class NotesConsolePresenter implements NotesPresenter{
    @Override
    public void printAll(Collection<Note> notes) {
        for (Note note: notes) {
            System.out.println(note);
        }

    }
}
