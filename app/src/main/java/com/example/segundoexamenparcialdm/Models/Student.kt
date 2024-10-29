package com.example.segundoexamenparcialdm.Models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Student(
    val id: Int,
    val primerNombre: String,
    val segundoNombre: String?,
    val primerApellido: String,
    val segundoApellido: String?,
    val carrera: String,
    val numeroCarnet: String,
    val sede: String,
    val jornada: String,
    val fotoPerfil: String,
    val cursosMatriculados: List<Course>
) : Parcelable

@Parcelize
data class Course(
    val semestre: Int,
    val semestrePensum: Int,
    val creditos: Int,
    val nombre: String,
    val prerequisitos: List<String>,
    val codigo: String,
    val docente: String
) : Parcelable