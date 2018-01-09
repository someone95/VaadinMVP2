package georgi.vaadinmvp.student.ui;

import java.util.List;

import org.springframework.stereotype.Component;
import org.vaadin.grid.cellrenderers.client.editoraware.renderers.CheckboxRenderer;
//import org.vaadin.grid.cellrenderers.editoraware.CheckboxRenderer;

import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import georgi.vaadinmvp.student.StudentView;
import georgi.vaadinmvp.student.model.Student;

/**
 * @author Georgi Dinev
 */

@Component
public class StudentViewImpl extends VerticalLayout implements StudentView {

	private Grid<Student> grid;
	private Button deleteBtn;

	private StudentView.Presenter presenter;
	private PopupView popup;
	private Button createUser;
	private VerticalLayout popupCreateUser;
	private Button saveUser;
	private TextField age;
	private TextField name;
	private TextField paid;

	@Override
	public void initializeUI() {
		this.grid = new Grid<>(Student.class);
		this.grid.setColumns(Student.ID, Student.NAME, Student.AGE, Student.HAS_PAID_TAX);
		this.grid.setWidth("100%");
		this.grid.setHeight("100%");

		this.deleteBtn = new Button("Delete");
		deleteBtn.addClickListener(click -> {
			presenter.deleteStudent(this.grid.getSelectedItems().iterator().next());
		});

		popupCreateUser = new VerticalLayout();

		this.popup = new PopupView(null, popupCreateUser);
		createUser = new Button("Create User", click -> popup.setPopupVisible(true));
		this.age = new TextField("Age");
		this.name = new TextField("Name");
		this.paid = new TextField("Paid?");
		popupCreateUser.addComponent(this.age);
		popupCreateUser.addComponent(this.name);
		popupCreateUser.addComponent(this.paid);
		popupCreateUser.addComponent(new Button("Cancel", click -> popup.setPopupVisible(false)));
		Student st = new Student();
		st.setName("vladimir");
		st.setAge(22);
		st.setPaidTax(true);
		this.saveUser = new Button("Save", click -> presenter.createStudent(st));
		popupCreateUser.addComponent(saveUser);
		addComponents(this.grid, this.deleteBtn, this.popup, this.createUser);
	}

	@Override
	public void setStudents(final List<Student> students) {
		this.grid.setItems(students);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
}
