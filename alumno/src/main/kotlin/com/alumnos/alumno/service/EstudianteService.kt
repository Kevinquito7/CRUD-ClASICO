package com.alumnos.alumno.service

import com.alumnos.alumno.model.Estudiante
import com.alumnos.alumno.repository.EstudianteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class EstudianteService {
    @Autowired
    lateinit var estudianteRepository: EstudianteRepository

    fun list ():List<Estudiante>{
        return estudianteRepository.findAll()
    }

    fun save(estudiante:Estudiante): Estudiante {
        try{
            return estudianteRepository.save(estudiante)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(estudiante: Estudiante): Estudiante{
        try {
            estudianteRepository.findById(estudiante.id)
                ?: throw Exception("ID no existe")

            return estudianteRepository.save(estudiante)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun updateName(estudiante: Estudiante): Estudiante{
        try{
            val response = estudianteRepository.findById(estudiante.id)
                ?: throw Exception("ID no existe")
            response.apply {
                nombre=estudiante.nombre

            }
            return estudianteRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = estudianteRepository.findById(id)
                ?: throw Exception("ID no existe")
            estudianteRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}