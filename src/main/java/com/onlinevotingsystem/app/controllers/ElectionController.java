package com.onlinevotingsystem.app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlinevotingsystem.app.models.Election;
import com.onlinevotingsystem.app.services.ElectionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/elections")
public class ElectionController {

    private final ElectionService electionService;

    // Constructor-based dependency injection
    public ElectionController(ElectionService electionService) {
        this.electionService = electionService;
    }

    // Create election
    @PostMapping("/create")
    public String createElection(@RequestParam String question) {
        electionService.createElection(question);
        return "Election created successfully";
    }

    // Get all elections
    @GetMapping("/all")
    public List<Election> getAllElections() {
        return electionService.getAllElections();
    }

    // Vote in an election
    @PostMapping("/vote")
    public String vote(@RequestParam String question, @RequestParam boolean voteYes) {
        electionService.vote(question, voteYes);
        return "Vote recorded successfully";
    }
}
