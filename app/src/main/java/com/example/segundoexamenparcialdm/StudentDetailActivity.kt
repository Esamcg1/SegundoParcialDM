package com.example.segundoexamenparcialdm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.segundoexamenparcialdm.Models.Student
import com.example.segundoexamenparcialdm.databinding.ActivityStudentDetailBinding

class StudentDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityStudentDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_student_detail)

        val student = intent.getParcelableExtra<Student>("student")
        binding.student = student

        val recyclerViewCourses = findViewById<RecyclerView>(R.id.recyclerViewCourses)
        recyclerViewCourses.layoutManager = GridLayoutManager(this, 2)
        recyclerViewCourses.adapter = CourseAdapter(student?.cursosMatriculados ?: listOf())
    }
}