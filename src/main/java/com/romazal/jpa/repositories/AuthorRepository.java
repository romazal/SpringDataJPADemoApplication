package com.romazal.jpa.repositories;

import com.romazal.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {

    @Transactional
    List<Author> findByNamedQuery (@Param("age") int age);

    @Modifying
    @Transactional
    void updateByNamedQuery (@Param("age") int age);



    @Modifying
    @Transactional
    @Query("UPDATE Author a SET a.age = :age WHERE a.id = :id")
    int updateAgeById(int age, int id);

    @Modifying
    @Transactional
    @Query("UPDATE Author a SET a.age = :age")
    int updateAllAges(int age);

    List<Author> findAllByFirstName (String firsName);

    List<Author> findAllByFirstNameIgnoreCase (String firsName);

    List<Author> findAllByFirstNameContainingIgnoreCase(String firsName);


}
