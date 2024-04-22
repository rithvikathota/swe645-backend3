package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.NoRepositoryBean;

import net.javaguides.springboot.model.Student;

//@NoRepositoryBean
public interface StudentRepository extends JpaRepository<Student, Long> {

}

