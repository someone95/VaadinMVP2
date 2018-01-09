package georgi.vaadinmvp.student.service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import georgi.vaadinmvp.student.model.Student;
import georgi.vaadinmvp.student.service.repository.StudentRepository;

/**
 * @author Georgi Dinev
 */

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentRepository studentRepository;


    @Override
    public void delete(final Student student) {
    	System.out.println("----------------------------STUDENT SERVICE DELETE-----------------");

        this.studentRepository.delete(student.getId());
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public long create(final Student student) {
        return this.studentRepository.create(student);
    }

    @Override
    public void update(final Student student) {
        this.studentRepository.update(student);
    }
}
