package com.semana3.semana3.controller;

import com.semana3.semana3.model.Alumno;
import com.semana3.semana3.repository.AlumnoRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
    private final AlumnoRepository alumnoData;
    
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarAlumno(@RequestBody Alumno request){
        alumnoData.save(request);
        alumnoData.flush();

        return new ResponseEntity<String>(request.getId(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> findById(@PathVariable String id){
        Optional<Alumno> optAlumno = alumnoData.findById(id);
        if(optAlumno.isPresent()){
            Alumno alumno = optAlumno.get();
            return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
        }

    }

}
