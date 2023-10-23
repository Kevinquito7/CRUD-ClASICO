package com.alumnos.alumno.repository

import com.alumnos.alumno.model.Estudiante
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface EstudianteRepository : JpaRepository<Estudiante, Long?> {

    fun findById (id: Long?): Estudiante?

}
