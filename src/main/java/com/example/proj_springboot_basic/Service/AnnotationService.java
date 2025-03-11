package com.example.proj_springboot_basic.Service;

import com.example.proj_springboot_basic.Entity.Annotation;
import com.example.proj_springboot_basic.Repository.AnnotationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AnnotationService implements IAnnotationService {

    @Autowired
    private AnnotationRepository annotationRepository;

    @Override
    public Annotation searchById(Long id){
        Optional<Annotation> optionalUser = annotationRepository.findById(id);
        if (optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!");
        }
        return optionalUser.get();
    }

    @Transactional
    public Annotation create(Annotation annotation) {
        if (annotation.getAuthor() == null
                || annotation.getAuthor().isEmpty()
                || annotation.getText() == null
                || annotation.getText().isEmpty()
        ) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Author and Text cannot be empty!");
        return  annotationRepository.save(annotation);
    }

    @Override
    public List<Annotation> read() {
        return annotationRepository.findAll();
    }

    @Override
    public Annotation update(Long id, Annotation updateAnnotation) {
        Annotation annotation = searchById(id);

        if (annotation.getAuthor() != null && !annotation.getAuthor().trim().isEmpty()) {
            annotation.setAuthor(updateAnnotation.getAuthor());
        }

        if (annotation.getText() != null && !annotation.getText().trim().isEmpty()) {
            annotation.setText(updateAnnotation.getText());
        }

        return annotationRepository.saveAndFlush(annotation);
    }

    @Override
    public void delete(Long id) {
        Annotation annotation = searchById(id);
        annotationRepository.delete(annotation);
    }
}
