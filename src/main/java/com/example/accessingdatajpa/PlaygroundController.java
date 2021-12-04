package com.example.accessingdatajpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PlaygroundController {

    @Autowired
    PlaygroundService playgroundService;

    @Autowired
    PlaygroundManagedService playgroundManagedService;

    @RequestMapping(value = "/playgrounds/{id}", method = RequestMethod.GET)
    public Playground find(@PathVariable("id") long id) throws Exception {
        return playgroundService.getPlayground(id);
    }

    @RequestMapping(value = "/playgrounds/", method = RequestMethod.POST)
    public Long add(@RequestBody Playground playground) throws Exception {
        return playgroundService.add(playground);
    }

    @RequestMapping({ "/playgrounds" })
    public List<Playground> find() {
        List<Playground> all = playgroundService.getAll();
        return all;
    }


    @RequestMapping({ "/jalla" })
    public void findManaghed() throws Exception {
        playgroundManagedService.jalla();

    }


}
