package com.example.android_kotlin_mvvm_architecture_practice.model.repository

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.time.LocalDate

class MainRepository (val mSharedPreferences: SharedPreferences){
    private lateinit var mToDoSet: MutableSet<ToDo>

    private fun makeGenericToDoList(): List<ToDo> {
        return listOf(ToDo(1, "Whatever"),
            ToDo(2, "Whatever2"),
            ToDo(3, "Whatever2"),
            ToDo(4, "Whatever2"),
            ToDo(5, "Whatever2"),
            ToDo(6, "Whatever2"),
            ToDo(7, "Whatever2"),
            ToDo(8, "Backwards?", LocalDate.now().minusDays(10)))
    }

    fun getToDoList(): MutableSet<ToDo> {
        return makeGenericToDoList().toMutableSet()
    }

//    fun addToDoList(toDo: ToDo) {
//        mToDoSet = getToDoSharedPreferences()
//        mToDoSet.add(toDo)
//        saveToDoToSharedPreferences(mToDoSet)
//    }
//
//    private fun saveToDoToSharedPreferences(toDoSet: MutableSet<ToDo>) {
//        with(mSharedPreferences.edit()) {
//            val gson = Gson()
//            val serializedToDo = gson.toJson(toDoSet)
//            putString(TO_DO_SET_KEY, serializedToDo)
//            apply()
//        }
//    }
//
//    private fun getToDoSharedPreferences(): MutableSet<ToDo> {
//        if (mSharedPreferences.contains(TO_DO_SET_KEY)) {
//            val gson = Gson()
//            val listType: Type = object : TypeToken<MutableSet<String?>?>() {}.type
//            return gson.fromJson(mSharedPreferences.getString(TO_DO_SET_KEY, ""), listType)
//        }
//        return emptySet<ToDo>() as MutableSet<ToDo>
//    }


    companion object {
        private const val TO_DO_SET_KEY = "TO_DO_SET_KEY"
    }
}