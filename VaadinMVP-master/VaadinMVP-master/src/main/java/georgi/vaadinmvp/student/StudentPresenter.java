package georgi.vaadinmvp.student;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import georgi.vaadinmvp.student.model.Student;
import georgi.vaadinmvp.student.service.StudentService;

/**
 * @author Georgi Dinev
 */

@Component
public class StudentPresenter implements StudentView.Presenter {

	@Resource
	private StudentView studentView;

	@Resource
	private StudentService studentService;

	@PostConstruct
	public void init() {
		this.studentView.setPresenter(this);
		this.studentView.initializeUI();
		this.studentView.setStudents(this.studentService.findAll());
	}

	@Override
	public StudentView getView() {
		return this.studentView;
	}

	@Override
	public void deleteStudent(Student student) {
		System.out.println("----------------------------PRESENTER DELETE-----------------");
		this.studentService.delete(student);
		this.studentView.setStudents(this.studentService.findAll());

	}

	@Override
	public long createStudent(Student student) {
		this.studentService.create(student);
		this.studentView.setStudents(this.studentService.findAll());
		return student.getId();
	}
}
