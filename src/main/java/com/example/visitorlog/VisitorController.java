package com.example.visitorlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class VisitorController {



    VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }


    @GetMapping("/visitors")
    public ResponseEntity<List<Visitor>> getAllVisitors() {
        return ResponseEntity.ok(visitorService.getAllVisitors());
    }


    @GetMapping("/visitors/{id}")
    public ResponseEntity<Visitor> getVisitorById(@PathVariable Long id) {

        return ResponseEntity.ok(
                visitorService.getVisitorById(id)
        );
    }


    @PostMapping("/visitors")
    public ResponseEntity<Visitor> addVisitor(@RequestBody Visitor visitor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(visitorService.addVisitor(visitor));
    }


    @DeleteMapping("/visitors/{id}")
    public void deleteVisitor(@PathVariable Long id) {
        visitorService.deleteVisitor(id);
    }


    @GetMapping("/visitors/count")
    public String countVisitors() {
        return visitorService.totalVisitors();
    }


    @GetMapping("/health")
    public Map<String, String> health() {

        return Map.of(
                "status", "UP",
                "developer", "Reem Khalifa"
        );
    }


    @PutMapping("/visitors/{id}")
    public Visitor updateVisitor(
            @PathVariable long id,
            @RequestBody Visitor updateVisitor
    ) {

        return visitorService.updateVisitor(
                id,
                updateVisitor
        );
    }

    @GetMapping
    public ResponseEntity<List<Visitor>> getVisitors(
            @RequestParam String purpose) {

        return ResponseEntity.ok(
                visitorService.getVisitorsByPurpose(purpose)
        );
    }


}