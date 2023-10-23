package com.alumnos.alumno.controller

import com.alumnos.alumno.model.Estudiante
import com.alumnos.alumno.service.EstudianteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/estudiante")   //endpoint
class EstuianteController {
    @Autowired
    lateinit var estudianteService: EstudianteService

    @GetMapping
    fun list ():List <Estudiante>{
        return estudianteService.list()
    }
    @PostMapping
    fun save (@RequestBody estudiante: Estudiante):ResponseEntity<Estudiante>{
        return ResponseEntity(estudianteService.save(estudiante), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody estudiante: Estudiante):ResponseEntity<Estudiante>{
        return ResponseEntity(estudianteService.update(estudiante), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName (@RequestBody estudiante: Estudiante):ResponseEntity<Estudiante>{
        return ResponseEntity(estudianteService.updateName(estudiante), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return estudianteService.delete(id)
    }
}