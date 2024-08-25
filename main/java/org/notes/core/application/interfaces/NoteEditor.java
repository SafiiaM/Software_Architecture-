package main.java.org.notes.core.application.interfaces;


import main.java.org.notes.core.domain.Note;

public interface NoteEditor extends Editor<Note,Integer> {

    void printAll();

}