package com.example.visitorlog;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitorService {
    private List<Visitor> visitors = new ArrayList<>();
    private Integer count = 0;


    public List<Visitor> getAllVisitors(){
        return visitors;
    }

    public Visitor getVisitorById(Long id){
        for(Visitor visitor : visitors){
            if(visitor.getId() == id){
                return visitor;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Visitor not found");
    }

    public Visitor addVisitor(Visitor visitor) {
        boolean exists = visitors.stream()
                .anyMatch(v -> v.getId().equals(visitor.getId()));
        if (exists) {
            throw new RuntimeException("Visitor ID already exists");
        }

        visitors.add(visitor);
        count ++;

        return visitor;
    }

    public void deleteVisitor(Long id) {
        Visitor visitor = getVisitorById(id);

        visitors.remove(visitor);
        count--;
    }

    public String totalVisitors(){
        return "total: " + count;
    }

    public Visitor updateVisitor(long id, Visitor updateVisitor) {
        Visitor visitor = getVisitorById(id);
        visitor.setName(updateVisitor.getName());
        visitor.setCompany(updateVisitor.getCompany());
        visitor.setPurpose(updateVisitor.getPurpose());
        return visitor;
    }

    public List<Visitor> getVisitorsByPurpose(String purpose) {

        List<Visitor> visitorsByPurpose = new ArrayList<>();

        for (Visitor visitor : visitors) {
            if (visitor.getPurpose().equalsIgnoreCase(purpose)) {
                visitorsByPurpose.add(visitor);
            }
        }
        return visitorsByPurpose;
    }

}
