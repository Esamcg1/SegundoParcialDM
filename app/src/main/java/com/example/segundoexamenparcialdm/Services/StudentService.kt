package com.example.app.services

import com.example.segundoexamenparcialdm.Models.Student
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface StudentApi {
    @GET("estudiantes")
    suspend fun getStudents(): List<Student>
}

object RetrofitInstance {
    private const val BASE_URL = "http://localhost:3000/"

    val api: StudentApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StudentApi::class.java)
    }
}

class StudentService {
    private val api = RetrofitInstance.api

    suspend fun fetchStudents(): List<Student>? {
        return try {
            api.getStudents()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}