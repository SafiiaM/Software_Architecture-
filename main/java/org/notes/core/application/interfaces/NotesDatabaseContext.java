package main.java.org.notes.core.application.interfaces;

import main.java.org.notes.core.domain.Note;

import java.util.Collection;

public interface NotesDatabaseContext {

    Collection<Note> getAll();

    boolean saveChanges();


}
