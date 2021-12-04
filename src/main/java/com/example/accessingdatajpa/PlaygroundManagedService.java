package com.example.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.Status;
import static org.assertj.core.api.Assertions.assertThat;
@Service
public class PlaygroundManagedService {


        public void jalla() throws Exception {

            HibernateLifecycleUtil.init();


            SessionFactory sessionFactory = HibernateLifecycleUtil.getSessionFactory();
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = HibernateLifecycleUtil.startTransaction(session);

                Playground n = new Playground("red");


                session.save(n);
                assertThat(HibernateLifecycleUtil.getManagedEntities(session)).size().isEqualTo(1);
                assertThat(n.getEquip_id()).isNotNull();

                int count = HibernateLifecycleUtil.queryCount("select count(*) from Playground where color='red'");
                assertThat(count).isEqualTo(0);
                System.out.println(count);

                transaction.commit();

                count = HibernateLifecycleUtil.queryCount("select count(*) from Playground where color='red'");
                assertThat(count).isEqualTo(1);
                System.out.println(count);

                transaction = HibernateLifecycleUtil.startTransaction(session);
                session.delete(n);
                transaction.commit();
            }
        }


    }
