package com.example.historical1.Service;

import com.example.historical1.Repository.VisitorRepository;
import com.example.historical1.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
@Service
public class VisitorService {
    @Autowired
    private VisitorRepository repository;


    //get visitors
    public List<Visitor>  getVisitors(){
        return repository.findAll();
    }

    //save Visitors

    public  Visitor addVisitor(Visitor visitor){
        return repository.save(visitor);
    }

    // delete visitors

    public String deleteVisitor(int id){
        repository.deleteById(id);
        return "visitor is removed!!"+ id;
    }

   //update visitor

    public Visitor updateVisitor(Visitor visitor){
        Visitor existingVisitor = repository.findById(visitor.getId()).orElse(null);
        existingVisitor.setName(visitor.getName());
        existingVisitor.setAddress(visitor.getAddress());
        existingVisitor.setTotal_no(visitor.getTotal_no());
        existingVisitor.setDate(visitor.getDate());
        return repository.save(existingVisitor);

    }
    //getById method

    public Visitor getVisitorById(int id){
        return repository.findById(id).orElse(null);
    }


}
