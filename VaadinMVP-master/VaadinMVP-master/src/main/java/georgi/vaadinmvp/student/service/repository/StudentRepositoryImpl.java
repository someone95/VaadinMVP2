package georgi.vaadinmvp.student.service.repository;

import org.springframework.stereotype.Repository;

import georgi.vaadinmvp.student.model.Student;

/**
 * @author
 */

@Repository
public class StudentRepositoryImpl extends BaseRepository<Student> implements StudentRepository{
	public StudentRepositoryImpl() {
		super(Student.class);
		// TODO Auto-generated constructor stub
	}
}
