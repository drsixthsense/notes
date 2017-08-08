package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Transactional
    void deleteByDone(boolean done);

    @Transactional
    List<Todo> findByDone(boolean done);
}
