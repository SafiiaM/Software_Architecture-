package main.java.org.notes.core.application.interfaces;

import main.java.org.notes.core.domain.Note;

import java.util.Collection;

public interface NotesPresenter {
    void printAll (Collection<Note> notes);

}
