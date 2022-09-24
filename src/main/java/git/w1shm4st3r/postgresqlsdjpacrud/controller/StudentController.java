package git.w1shm4st3r.postgresqlsdjpacrud.controller;

import git.w1shm4st3r.postgresqlsdjpacrud.model.Student;
import git.w1shm4st3r.postgresqlsdjpacrud.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student, HttpServletResponse httpServletResponse) {
        studentService.addStudent(student);
        return "Student status: ADDED\nHTTP Response: " + httpServletResponse.getStatus();
    }

    @PostMapping("/addList")
    public String addListOfStudents(@RequestBody List<Student> studentList, HttpServletResponse httpServletResponse) {
        studentService.addListOfStudents(studentList);
        return "Student status: ADDED\nHTTP Response: " + httpServletResponse.getStatus();
    }

    @GetMapping("/get/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return student;
        } else {
            throw new RuntimeException("Student status: NOT FOUND");
        }
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        if (!allStudents.isEmpty()) {
            return allStudents;
        } else {
            throw new RuntimeException("Student status: NOT FOUND");
        }
    }

    @PutMapping("/update/{id}")
    public String updateStudentById(@PathVariable("id") Long id, @RequestBody Student student,
                                    HttpServletResponse httpServletResponse) {
        Student studentToUpdate = studentService.getStudentById(id);
        if (studentToUpdate != null) {
            studentToUpdate.setName(student.getName());
            studentToUpdate.setEmail(student.getEmail());
            studentToUpdate.setPhoneNumber(student.getPhoneNumber());
            studentService.updateStudent(studentToUpdate);
            return "Student status: UPDATED\nHTTP Response: " + httpServletResponse.getStatus();
        } else {
            throw new RuntimeException("Student status: NOT FOUND");
        }
    }

    @PatchMapping("/updatePartially/{id}")
    public String updateStudentPartially(@PathVariable("id") Long id, @RequestBody Student student,
                                         HttpServletResponse httpServletResponse) {
        Student studentFromRepository = studentService.getStudentById(id);
        if (studentFromRepository != null) {
            if (student.getName() != null) studentFromRepository.setName(student.getName());
            if (student.getEmail() != null) studentFromRepository.setEmail(student.getEmail());
            if (student.getPhoneNumber() != null) studentFromRepository.setPhoneNumber(student.getPhoneNumber());
            studentService.updateStudent(studentFromRepository);
            return "Student status: UPDATED\nHTTP Response: " + httpServletResponse.getStatus();
        } else {
            return "Student status: NOT FOUND";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable("id") Long id, HttpServletResponse httpServletResponse) {
        if (studentService.getStudentById(id) != null) {
            studentService.deleteStudentById(id);
            return "Student status: DELETED\nHTTP Response: " + httpServletResponse.getStatus();
        } else {
            throw new RuntimeException("Student status: NOT FOUND");
        }
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllStudents(HttpServletResponse httpServletResponse) {
        if (!studentService.getAllStudents().isEmpty()) {
            studentService.deleteAllStudents();
            return "Student status: DELETED\nHTTP Response: " + httpServletResponse.getStatus();
        } else {
            throw new RuntimeException("Student status: NOT FOUND");
        }
    }
}
