package com.example.proj_springboot_basic.Controller;


import com.example.proj_springboot_basic.Service.AnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.proj_springboot_basic.Entity.Annotation;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/annotation")
public class AnnotationController {

    @Autowired
    private AnnotationService annotationService;

    @PostMapping
    public Annotation create(@RequestBody Annotation annotation){
        return annotationService.create(annotation);
    }

    @GetMapping("/{id}")
    public Annotation searchById(@PathVariable("id") Long id) {
        return annotationService.searchById(id);
    }

    @GetMapping
    public List<Annotation> read() {
        return annotationService.read();
    }

    @PutMapping(value = "/{id}")
    public Annotation update(@PathVariable("id") Long id, @RequestBody Annotation annotation){
        return annotationService.update(id, annotation);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id){
        annotationService.delete(id);
    }

}
