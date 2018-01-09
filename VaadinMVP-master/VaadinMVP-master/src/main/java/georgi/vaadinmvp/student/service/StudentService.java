package georgi.vaadinmvp.student.service;

import java.util.List;

import georgi.vaadinmvp.student.model.Student;

/**
 * @author Georgi Dinev
 */

public interface StudentService {

    void delete(Student student);

    List<Student> findAll();

    long create(Student student);

    void update (Student student);
}
