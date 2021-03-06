/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Thriftshop.Thriftshop;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author muham
 */
@CrossOrigin
@RestController
@RequestMapping("/thrift")

public class DatabaseController {
    @Autowired
    RepositoryThrift repositoryThrift;
            
    @PostMapping("/addthrift")
    public Thrift addthrift(@RequestBody Thrift Param)
    {
        repositoryThrift.save(Param);
        return Param;
    }
    
    @GetMapping("/allthrift")
    public List<Thrift> allthrift()
    {
        return repositoryThrift.findAll();
    }
    
    @GetMapping("/allthriftbyid")
    public Thrift getthrift(@RequestParam int id)
    {
        return repositoryThrift.findById(id).get();
    }
    
    @PutMapping("/updatethrift")
    public Thrift updatethrift(@RequestBody Thrift Param)
    {
       return repositoryThrift.save(Param);
    }
    
    @DeleteMapping("/hapusthrift")
    public List<Thrift> hapusthrift(@RequestParam int id)
    {
        repositoryThrift.deleteById(id);
        List<Thrift> thriftlist = repositoryThrift.findAll();
        return thriftlist;
    }
}
