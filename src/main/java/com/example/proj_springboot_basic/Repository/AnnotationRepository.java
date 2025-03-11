package com.example.proj_springboot_basic.Repository;

import com.example.proj_springboot_basic.Entity.Annotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnotationRepository extends JpaRepository<Annotation, Long> { }
