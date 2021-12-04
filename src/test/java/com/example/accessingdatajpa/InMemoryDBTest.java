package com.example.accessingdatajpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { PlaygroundJPAConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class InMemoryDBTest {

    @Resource
    private PlaygroundRepository playgroundRepository;

    @Test
    public void givenStudent_whenSave_thenGetOk() {
        Playground p = new Playground(1, "john");
        playgroundRepository.save(p);

        List<Playground> p1 = playgroundRepository.findByColor("john");
        assertEquals(1, p1.size());
    }
}
