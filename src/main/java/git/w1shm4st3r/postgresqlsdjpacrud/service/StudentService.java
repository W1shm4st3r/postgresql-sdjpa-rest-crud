package git.w1shm4st3r.postgresqlsdjpacrud.service;

import git.w1shm4st3r.postgresqlsdjpacrud.model.Student;
import git.w1shm4st3r.postgresqlsdjpacrud.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void addListOfStudents(List<Student> studentsList) {
        studentRepository.saveAll(studentsList);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findStudentById(id);
    }

    @Transactional
    public void deleteStudentById(Long id) {
        studentRepository.deleteStudentById(id);
    }

    @Transactional
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

}
