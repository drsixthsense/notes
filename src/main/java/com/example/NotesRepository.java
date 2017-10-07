package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface NotesRepository extends JpaRepository<Notes, Long> {

    @Transactional
    void deleteByDone(boolean done);

    @Transactional
    List<Notes> findByDone(boolean done);


}
