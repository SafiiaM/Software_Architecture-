package main.java.org.notes.presentation.queries.controllers;

import main.java.org.notes.presentation.queries.views.Presenter;

public abstract class Controller {
    public <T extends Presenter> void view (T presenter) {

    }
}
