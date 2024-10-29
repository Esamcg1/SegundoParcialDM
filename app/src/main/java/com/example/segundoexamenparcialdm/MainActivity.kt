package com.example.segundoexamenparcialdm

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.segundoexamenparcialdm.Adapters.StudentAdapter
import com.example.segundoexamenparcialdm.ViewModels.StudentViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerViewStudents)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.students.observe(this, { students ->
            recyclerView.adapter = StudentAdapter(students) { student ->
                val intent = Intent(this, StudentDetailActivity::class.java)
                intent.putExtra("student", student)
                startActivity(intent)
            }
        })
    }
}