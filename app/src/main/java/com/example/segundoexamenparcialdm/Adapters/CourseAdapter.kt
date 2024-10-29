package com.example.segundoexamenparcialdm.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.segundoexamenparcialdm.Models.Course
import com.example.segundoexamenparcialdm.databinding.ItemCourseBinding

class CourseAdapter(private val courses: List<Course>) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(courses[position])
    }

    override fun getItemCount(): Int = courses.size

    class CourseViewHolder(private val binding: ItemCourseBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(course: Course) {
            binding.course = course
            binding.executePendingBindings()
        }
    }
}