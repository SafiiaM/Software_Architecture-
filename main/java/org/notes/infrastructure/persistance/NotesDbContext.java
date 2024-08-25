package main.java.org.notes.infrastructure.persistance;

import main.java.org.database.NotesDatabase;
import main.java.org.database.NotesRecord;
import main.java.org.notes.core.application.interfaces.NotesDatabaseContext;
import main.java.org.notes.core.domain.Note;
import main.java.org.notes.infrastructure.persistance.configurations.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class NotesDbContext extends DbContext implements NotesDatabaseContext {

    @Override
    public Collection<Note> getAll() {
        Collection<Note> notesList = new ArrayList<>();
        //TODO: Этого кастинга быть не должно, тут должен работать внутренний механизм фреймворка
        for (NotesRecord record : ((NotesDatabase)database).getNotesTable().getRecords()){
            notesList.add(new Note(
                    record.getId(),
                    record.getUserId(),
                    record.getTitle(),
                    record.getDetails(),
                    record.getCreationDate()
            ));
        }
        return notesList;
    }

    public NotesDbContext(Database database) {
        super(database);
    }


    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }

}
