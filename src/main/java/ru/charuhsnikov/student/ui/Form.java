package ru.charuhsnikov.student.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import ru.charuhsnikov.student.entity.Student;
//import ru.charuhsnikov.student.repository.StudentRepository;
import ru.charuhsnikov.student.service.StudentService;

@Route
public class Form extends VerticalLayout {

    //private final StudentRepository studentRepository;

    private final StudentService studentService;

    private final StudentEditor studentEditor;

    private Grid<Student> grid = new Grid<>(Student.class);

    private final TextField filter = new TextField("", "Find");

    private final Button addNewBtn = new Button("Add new Student");

    private final HorizontalLayout horizontalLayout = new HorizontalLayout(filter, addNewBtn);

    public Form(StudentService studentService, StudentEditor studentEditor) {
        //this.studentRepository = studentRepository;
        this.studentService = studentService;
        this.studentEditor = studentEditor;

        add(horizontalLayout, grid, studentEditor);

        filter.setValueChangeMode(ValueChangeMode.LAZY);
        filter.addValueChangeListener(e -> showStudents(e.getValue()));

        grid.asSingleSelect().addValueChangeListener(e ->
            studentEditor.editStudent(e.getValue())
        );

        addNewBtn.addClickListener(e -> studentEditor.editStudent(new Student()));

        studentEditor.setChangeHandler(() -> {
            studentEditor.setVisible(false);
            showStudents(filter.getValue());
        });

        showStudents("");

    }

    private void showStudents(String name) {
//        if (name.isEmpty()) {
//            grid.setItems(studentRepository.findAll());
//        } else {
//            grid.setItems(studentRepository.findByNameIgnoreCase(name));
//        }
        studentService.findAllOrOne(name);
    }

}
