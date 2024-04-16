package com.microservice.student.service;

import com.microservice.student.entity.Student;
import com.microservice.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    /**
     * @return
     */
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Student findById(Long id) {
        return studentRepository.getReferenceById(id);
    }

    /**
     * @param student
     * @return
     */
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    /**
     * @param idCourse
     * @return
     */
    @Override
    public List<Student> findByIdCourse(Long idCourse) {
        return studentRepository.findAllStudent(idCourse);
    }
}
