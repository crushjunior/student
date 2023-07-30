package ru.charuhsnikov.student.ui;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Setter;
import ru.charuhsnikov.student.entity.Student;
//import ru.charuhsnikov.student.repository.StudentRepository;
import ru.charuhsnikov.student.service.StudentService;

@SpringComponent
@UIScope
public class StudentEditor extends VerticalLayout implements KeyNotifier {
    //private final StudentRepository studentRepository;
    private final StudentService studentService;
    private Student student;

    private TextField name = new TextField("Name");
    private TextField age = new TextField("Age");
    private Checkbox isMale = new Checkbox("Is male?");
    private TextField scholarship = new TextField("Scholarship");


    private Button save = new Button("Save", VaadinIcon.CHECK.create());
    private Button cancel = new Button("Cancel");
    private Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    private HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

    private Binder<Student> binder = new Binder<>(Student.class);

    @Setter
    private ChangeHandler changeHandler;

    public interface ChangeHandler {
        void onChange();
    }

    public StudentEditor(StudentService studentService) {
        //this.studentRepository = studentRepository;
        this.studentService = studentService;

        add(name, age, isMale, scholarship, actions);

        binder.bindInstanceFields(this);

        setSpacing(true);

        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);

        addKeyPressListener(Key.ENTER, e -> save());

        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editStudent(student));
        setVisible(false);

        binder.forField(isMale).bind(Student::isMale, Student::setMale);
    }

    public void editStudent(Student newStudent) {
        if (newStudent == null) {
            setVisible(false);
            return;
        }

//        if (newStudent.getId() != null) {
//            student = studentRepository.findById(newStudent.getId()).orElse(newStudent);
//        } else {
//            student = newStudent;
//        }

        student = studentService.update(newStudent);

        binder.setBean(student);

        setVisible(true);

        name.focus();
    }

    private void delete() {
        //studentRepository.delete(student);
        studentService.delete(student);
        changeHandler.onChange();
    }

    private void save() {
        //studentRepository.save(student);
        studentService.save(student);
        changeHandler.onChange();
    }
}
