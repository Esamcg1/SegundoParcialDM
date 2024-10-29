package com.example.segundoexamenparcialdm.ViewModels

import androidx.lifecycle.LiveData
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.services.RetrofitInstance
import com.example.segundoexamenparcialdm.Models.Student

class StudentViewModel : ViewModel() {

    private val _students = MutableLiveData<List<Student>>()
    val students: LiveData<List<Student>> get() = _students

    init {
        fetchStudents()
    }

    private fun fetchStudents() {
        viewModelScope.launch {
            try {
                _students.value = RetrofitInstance.api.getStudents()
            } catch (e: Exception) {
                // Maneja errores
                _students.value = listOf()
            }
        }
    }
}