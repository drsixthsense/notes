package com.example;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

@UIScope
@SpringComponent
class NotesList extends VerticalLayout implements NotesChangeListener {
    @Autowired
    NotesRepository repository;
    private List<Notes> notes;

    @PostConstruct
    void init() {
        setWidth("80%");

        update();
    }

    private void update() {

        setNotes(repository.findAll());
    }

    private void setNotes(List<Notes> notes) {
        this.notes = notes;
        removeAllComponents();
        notes.forEach(todo -> addComponent(new NotesLayout(todo, this)));
    }

     void addTodo(Notes notes) {
        repository.save(notes);
    }

    @Override
    public void todoChanged(Notes notes) {
        addTodo(notes);
    }


    public void deleteCompleted() {
        repository.deleteByDone(true);
    }
    public void showUndoneOnly(){
        List<Notes> newNotes = repository.findByDone(false);
        setNotes(newNotes);
    }
    public void showDoneOnly(){
        List<Notes> newNotes = repository.findByDone(true);
        setNotes(newNotes);
    }

    public void showAll() {
        setNotes(repository.findAll());
    }
}
