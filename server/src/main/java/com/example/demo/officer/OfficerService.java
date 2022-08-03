package com.example.demo.officer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class OfficerService {
    private final OfficerRepository repository;

    @Autowired
    public OfficerService(OfficerRepository repository) {
        this.repository = repository;
    }

    public List<Officer> getAll() {
        return repository.findAll();
    }

    public Officer get(int id) {
        boolean exists = repository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Officer not found");
        }
        return repository.findById(id).get();
    }

    public Officer create(Officer o) {
        Optional<Officer> officerByName = repository.findOfficerByName(o.getName());
        if (officerByName.isPresent()) {
            throw new IllegalStateException("Name in use");
        }
        return repository.save(o);
    }

    @Transactional
    public Officer update(int id, Map<String, String> o) {
        String name = o.get("name");
        String rank = o.get("rank");
        boolean exists = repository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Officer not found with id " + id);
        }
        Officer officer = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Officer not found"));
        if (name != null && name.length() > 0 && !Objects.equals(officer.getName(), name)) {
            officer.setName(name);
        }
        if (rank != null && rank.length() > 0 && !Objects.equals(officer.getRank(), rank)) {
            officer.setRank(rank);
        }
        return officer;
    }

    public void delete(int id) {
        boolean exists = repository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Officer not found with id " + id);
        }
        repository.deleteById(id);
    }
}
