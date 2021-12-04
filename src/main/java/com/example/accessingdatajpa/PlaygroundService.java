package com.example.accessingdatajpa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.util.Assert.notNull;
import static org.springframework.util.Assert.isNull;


@Service
public class PlaygroundService {

    @Autowired
    PlaygroundRepository playgroundRepository;

   // @PersistenceContext
   // private EntityManager entityManager;


    public String hello() {
        return "Hello World";
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = {SQLException.class})
    public List<Playground> getAll() {
        List<Playground> all = playgroundRepository.findAll();
        return all;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = {Exception.class})
    public Playground getPlayground(long id) throws Exception {
        return playgroundRepository.findById(id).orElseThrow(Exception::new);
    }

    @Transactional(readOnly = true)
    public Long add(Playground playground) {
        try {
            return playgroundRepository.save(playground).getEquip_id();

        } catch (Exception ex) {
            System.out.println("EXEC" + ex.getMessage());
            return 1L;
        }
    }



}
