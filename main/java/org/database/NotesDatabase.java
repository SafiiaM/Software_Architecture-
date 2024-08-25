package main.java.org.database;

import main.java.org.notes.infrastructure.persistance.Database;

public  class NotesDatabase implements Database {

    private NotesTable notesTable;

    public NotesTable getNotesTable() {
        if (notesTable == null)
            notesTable = new NotesTable();
        return notesTable;
    }
}