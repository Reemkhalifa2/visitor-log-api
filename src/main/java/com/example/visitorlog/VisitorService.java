package com.example.visitorlog;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitorService {
    private List<Visitor> visitors = new ArrayList<>();

    public List<Visitor> getAllVisitors(){
        return visitors;
    }

    public Visitor getAllVisitors(Long id){
        for(Visitor visitor : visitors){
            if(visitor.getId() == id){
                return visitor;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Visitor not found");
    }

}
