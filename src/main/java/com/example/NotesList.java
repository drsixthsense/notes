package com.example;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;

@UIScope
@SpringComponent
class NotesList extends VerticalLayout implements NotesChangeListener {
    @Autowired
    NotesRepository repository;
    private Comparator comparator;
    private List<Notes> notes;

    @PostConstruct
    void init() {
        setWidth("80%");

        update();

        comparator = new DateComparator();
    }

    private void update() {

        setNotes(repository.findAll());
    }

    private void setNotes(List<Notes> notes) {
        this.notes = notes;
        removeAllComponents();
        notes.forEach(todo -> {
            addComponent(new NotesLayout(todo, this));

        });
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

    public void changeSortMethod(){
        List<Notes> newList = repository.findAll();
        newList.sort(comparator);
        setNotes(newList);


    }

    public void showAll() {
        setNotes(repository.findAll());
    }

    class DateComparator implements Comparator<Notes>{

        @Override
        public int compare(Notes o1, Notes o2) {
            return o2.getDateForCompare().compareTo(o1.getDateForCompare());
        }
    }
}
