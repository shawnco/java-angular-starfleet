package com.example.demo.officer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping(path = "api/v1/officer")
public class OfficerController {
    private final OfficerService service;

    @Autowired
    public OfficerController(OfficerService  service) {
        this.service = service;
    }

    @GetMapping(path = "all")
    public List<Officer> getAll() { return service.getAll(); }

    @GetMapping(path = "{id}")
    public Officer get(@PathVariable("id") int id) {
        return service.get(id);
    }

    @PostMapping(path = "add")
    public Officer create(@RequestBody Officer s) {
        return service.create(s);
    }

    @PutMapping(path = "{id}/edit")
    public Officer update(@PathVariable("id") int id, @RequestBody Map<String, String> s) {
        return service.update(id, s);
    }

    @DeleteMapping(path = "{id}/delete")
    public HashMap<String, Boolean> delete(@PathVariable("id") int id) {
        service.delete(id);
        // Return something that can be read as JSON on the frontend
        HashMap<String, Boolean> output = new HashMap<String, Boolean>();
        output.put("deleted", true);
        return output;
    }
}
