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
public class TodoUI extends UI {

    private VerticalLayout layout;

    @Autowired
    TodoList todoList;

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
        Label header = new Label("TODO");
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
            todoList.addTodo(new Todo(taskField.getValue()));
            taskField.setValue("");
            taskField.focus();
        });
        addButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
    }

    private void addTodoList() {
        layout.addComponent(todoList);
    }

    private void addActionButtons() {
        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setWidth("80%");

        Button deleteButton = new Button("Delete completed items");
        Button showUndoneButton = new Button("Show only Undone tasks");
        Button showAllButton = new Button("Show All");

        deleteButton.addClickListener(click->todoList.deleteCompleted());
        showUndoneButton.addClickListener(click -> todoList.showCompleted());
        showAllButton.addClickListener(click -> todoList.init());

        formLayout.addComponent(showUndoneButton);
        formLayout.addComponent(showAllButton);
        formLayout.addComponent(deleteButton);

        layout.addComponent(formLayout);

    }
}
