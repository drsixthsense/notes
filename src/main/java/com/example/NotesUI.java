package com.example;

import com.vaadin.annotations.Theme;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI
@Theme("valo")
public class NotesUI extends UI {

    private Button deleteButton;
    private Button showUndoneButton;
    private Button showAllButton;
    private Button showDoneButton;
    private Button sortByDate;
    private VerticalLayout layout;

    @Autowired
    NotesList notesList;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupLayout();
        addHeader();
        addForm();
        addActionButtons();
        addTodoList();
    }

    private void setupLayout() {
        layout = new VerticalLayout();
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(layout);
    }

    private void addHeader() {
        Label header = new Label("NOTES");
        header.addStyleName(ValoTheme.LABEL_H1);
        layout.addComponent(header);

    }

    private void addForm() {
        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setWidth("80%");

        TextField taskField = new TextField();
        taskField.focus();
        Button addButton = new Button("");

        formLayout.addComponentsAndExpand(taskField);
        formLayout.addComponent(addButton);
        layout.addComponent(formLayout);

        addButton.addStyleName(ValoTheme.BUTTON_PRIMARY);
        addButton.setIcon(VaadinIcons.PLUS);

        addButton.addClickListener(click -> {
            notesList.addTodo(new Notes(taskField.getValue()));
            taskField.setValue("");
            taskField.focus();
            showAllButton.setEnabled(true);
            showAllButton.click();
        });
        addButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
    }

    private void addTodoList() {
        layout.addComponent(notesList);
    }

    private void addActionButtons() {
        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setWidth("80%");

        deleteButton = new Button("Удалить выполненные");
        showUndoneButton = new Button("Только невыполненные");
        showAllButton = new Button("Все заметки");
        showDoneButton = new Button("Только выполненные");
        sortByDate = new Button("Показать свежие");
        showAllButton.setEnabled(false);

        deleteButton.addClickListener(click-> {
            notesList.deleteCompleted();
            showAllButton.click();
        });

        sortByDate.addClickListener(clickEvent -> {
            notesList.changeSortMethod();
        });

        showUndoneButton.addClickListener(click -> {
            notesList.showUndoneOnly();
            showUndoneButton.setEnabled(false);
            showDoneButton.setEnabled(true);
            showAllButton.setEnabled(true);});

        showAllButton.addClickListener(click -> {
            notesList.showAll();
            showUndoneButton.setEnabled(true);
            showDoneButton.setEnabled(true);
            showAllButton.setEnabled(false);});

        showDoneButton.addClickListener(clickEvent -> {
            notesList.showDoneOnly();
            showDoneButton.setEnabled(false);
            showUndoneButton.setEnabled(true);
            showAllButton.setEnabled(true);
        });

        formLayout.addComponent(showUndoneButton);
        formLayout.addComponent(showDoneButton);
        formLayout.addComponent(showAllButton);
        formLayout.addComponent(sortByDate);
        formLayout.addComponent(deleteButton);

        layout.addComponent(formLayout);

    }
}
