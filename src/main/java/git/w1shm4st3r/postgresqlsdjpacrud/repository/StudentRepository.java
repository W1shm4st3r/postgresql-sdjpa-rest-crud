package git.w1shm4st3r.postgresqlsdjpacrud.repository;

import git.w1shm4st3r.postgresqlsdjpacrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentById(Long id);

    void deleteStudentById(Long id);
}
