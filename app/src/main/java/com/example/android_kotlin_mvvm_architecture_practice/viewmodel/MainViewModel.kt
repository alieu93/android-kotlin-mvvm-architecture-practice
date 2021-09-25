package com.example.android_kotlin_mvvm_architecture_practice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_kotlin_mvvm_architecture_practice.model.repository.MainRepository
import com.example.android_kotlin_mvvm_architecture_practice.model.repository.ToDo
import java.time.LocalDate

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {
    private val mToDoList = MutableLiveData<List<ToDo>>()

    init {
        fetchToDoList()
    }

    private fun fetchToDoList() {
        mToDoList.postValue(repository.getToDoList().toList())
    }

    fun getToDoList(): LiveData<List<ToDo>> {
        return mToDoList
    }
}