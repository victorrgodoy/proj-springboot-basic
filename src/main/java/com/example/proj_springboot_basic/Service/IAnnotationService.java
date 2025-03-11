package com.example.proj_springboot_basic.Service;

import com.example.proj_springboot_basic.Entity.Annotation;

import java.util.List;

public interface IAnnotationService {

    //crud
    Annotation searchById(Long id);
    Annotation create(Annotation annotation);
    List<Annotation> read();
    Annotation update(Long id, Annotation annotation);
    void delete(Long id);
}
