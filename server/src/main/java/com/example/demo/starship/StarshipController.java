package com.example.demo.starship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping(path = "api/v1/starship")
public class StarshipController {
    private final StarshipService service;

    @Autowired
    public StarshipController(StarshipService service) {
        this.service = service;
    }

    @GetMapping(path = "all")
    public List<Starship> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "{id}")
    public Starship get(@PathVariable("id") int id) {
        return service.get(id);
    }

    @PostMapping(path = "add")
    public Starship create(@RequestBody Starship s) {
        return service.create(s);
    }

    @PutMapping(path = "{id}/edit")
    public Starship update(@PathVariable("id") int id, @RequestBody Map<String, String> s) {
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
