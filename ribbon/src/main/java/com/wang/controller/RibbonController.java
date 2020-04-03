package com.wang.controller;

import com.wang.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {
    
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("http://provider/student/findAll",Collection.class).getBody();
    }

    @GetMapping("/findAll2")
    public Collection<Student> findAll2(){
        return restTemplate.getForObject("http://provider/student/findAll",Collection.class);
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Long id){
        return restTemplate.getForObject("http://provider/student/findById/{id}", Student.class,id);
    }

    @GetMapping("/findById2/{id}")
    public Student findById2(@PathVariable("id") Long id){
        return restTemplate.getForEntity("http://provider/student/findById/{id}",Student.class,id).getBody();
    }


    @PostMapping("/save")
    public void save(@RequestBody Student student){
        restTemplate.postForEntity("http://provider/student/save", student, Void.class);
    }


    @PostMapping("/save2")
    public void save2(@RequestBody Student student){
        restTemplate.postForObject("http://provider/student/save", student, Void.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://provider/student/update", student);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        restTemplate.delete("http://provider/student/delete/{id}",id);
    }

    @GetMapping("/index")
    public String index(){
        return restTemplate.getForObject("http://provider/student/index", String.class);
    }
}
