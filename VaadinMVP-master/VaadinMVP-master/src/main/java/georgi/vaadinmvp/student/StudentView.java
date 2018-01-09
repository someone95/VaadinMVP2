package georgi.vaadinmvp.student;

import java.util.List;

import com.vaadin.ui.Component;

import georgi.vaadinmvp.student.model.Student;

/**
 * @author Georgi Dinev
 */


public interface StudentView extends Component {

    void initializeUI();

    void setStudents(List<Student> students);
    
    void setPresenter(Presenter presenter);
    
     interface Presenter {
    	 void deleteStudent(Student student);
    	 long createStudent(Student student);
         StudentView getView();
    }
}
