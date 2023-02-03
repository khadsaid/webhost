package com.example.historical1.Controller;

import com.example.historical1.Service.VisitorService;
import com.example.historical1.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class VisitorController {
    @Autowired
    private VisitorService service;
    @GetMapping("/visitors")
    public List<Visitor> getvisitor(){
        return service.getVisitors();
    }
    @PostMapping("/visitors")
    public Visitor addVisitor(@RequestBody Visitor visitor){
        return service.addVisitor(visitor);
    }
    @DeleteMapping("/visitors/{id}")
    public String deleteVisitor(@PathVariable int id){
        return service.deleteVisitor(id);

    }
    @PutMapping("/visitors/{id}")
    public Visitor updateVisitor(Visitor visitor){
        return service.updateVisitor(visitor);
    }
    @GetMapping("/visitors/{id}")
    public  Visitor getVisitorById(@PathVariable int id){
        return service.getVisitorById(id);
    }
}
