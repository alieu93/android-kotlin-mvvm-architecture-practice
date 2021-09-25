package com.example.android_kotlin_mvvm_architecture_practice.model.repository

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class ToDo (
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("description")
    val description: String = "",
    @SerializedName("dateCreated")
    val dateCreated: LocalDate = LocalDate.now()

)