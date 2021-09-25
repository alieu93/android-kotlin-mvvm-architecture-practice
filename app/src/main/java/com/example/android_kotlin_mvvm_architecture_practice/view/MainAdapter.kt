package com.example.android_kotlin_mvvm_architecture_practice.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_kotlin_mvvm_architecture_practice.R
import com.example.android_kotlin_mvvm_architecture_practice.model.repository.ToDo

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    var mToDoList = mutableListOf<ToDo>()

    fun setToDoList(toDoList: List<ToDo>) {
        this.mToDoList = toDoList.toMutableList()
        notifyDataSetChanged()
    }

    class MainViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val toDoDescriptionTextView: TextView = view.findViewById(R.id.to_do_description)

        fun bind(text: String) {
            toDoDescriptionTextView.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MainViewHolder(inflater.inflate(R.layout.list_to_do_item, parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val toDo = mToDoList[position]
        holder.bind(toDo.description)
    }

    override fun getItemCount(): Int = mToDoList.size
}