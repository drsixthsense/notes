package com.example;

import com.vaadin.data.Binder;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;


public class NotesLayout extends HorizontalLayout {
    private final CheckBox done;
    private final TextField text;
    private final DateTimeField date;

    public NotesLayout(Notes notes, NotesChangeListener changeListener) {
        setWidth("100%");
        setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

        done = new CheckBox();
        text = new TextField();
        date = new DateTimeField();
        date.setDateFormat("yyyy-MMM-dd HH:mm:ss");

        date.setEnabled(false);
        text.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        text.setValueChangeMode(ValueChangeMode.BLUR);

        Binder<Notes> binder = new Binder<>(Notes.class);
        //Binds fields in this class to those in Notes based on their names
        binder.bindInstanceFields(this);
        // The following does the same more explicitly
        // binder.bind(text, Notes::getText, Notes::setText);
        // binder.bind(done, Notes::isDone, Notes::setDone);
//        binder.bind(dateTimeField, "date");


        binder.setBean(notes);

        addComponent(done);
        addComponentsAndExpand(text);
        addComponent(date);

        binder.addValueChangeListener(event -> changeListener.todoChanged(notes));
    }


}
