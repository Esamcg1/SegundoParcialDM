package com.example.segundoexamenparcialdm.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.segundoexamenparcialdm.Models.Student
import com.example.segundoexamenparcialdm.R


class StudentAdapter(
    private val students: List<Student>,
    private val onClick: (Student) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val studentName: TextView = view.findViewById(R.id.studentName)
        val studentId: TextView = view.findViewById(R.id.studentId)
        val viewButton: Button = view.findViewById(R.id.viewButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.studentName.text = "${student.primerNombre} ${student.primerApellido}"
        holder.studentId.text = student.numeroCarnet
        holder.viewButton.setOnClickListener { onClick(student) }
    }

    override fun getItemCount(): Int = students.size
}