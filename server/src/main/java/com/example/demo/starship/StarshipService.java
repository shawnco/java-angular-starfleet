package com.example.demo.starship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class StarshipService {
    private final StarshipRepository repository;

    @Autowired
    public StarshipService(StarshipRepository repository) {
        this.repository = repository;
    }

    public List<Starship> getAll() {
        return repository.findAll();
    }

    public Starship get(int id) {
        boolean exists = repository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Ship not found");
        }
        return repository.findById(id).get();
    }

    public Starship create(Starship s) {
        Optional<Starship> shipByRegistry = repository.findStarshipByRegistry(s.getRegistry());
        if (shipByRegistry.isPresent()) {
            throw new IllegalStateException("Registry in use");
        }
        return repository.save(s);
    }

    @Transactional
    public Starship update(int id, Map<String, String> s) {
        String name = s.get("name");
        String registry = s.get("registry");
        boolean exists = repository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Ship not found with id " + id);
        }
        Starship ship = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Ship not found"));
        if (name != null && name.length() > 0 && !Objects.equals(ship.getName(), name)) {
            ship.setName(name);
        }
        if (registry != null && registry.length() > 0 && !Objects.equals(ship.getRegistry(), registry)) {
            ship.setRegistry(registry);
        }
        return ship;
    }

    public void delete(int id) {
        boolean exists = repository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Ship not found with id " + id);
        }
        repository.deleteById(id);
    }
}
