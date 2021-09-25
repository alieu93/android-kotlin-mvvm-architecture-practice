package com.example.android_kotlin_mvvm_architecture_practice.view

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_kotlin_mvvm_architecture_practice.R
import com.example.android_kotlin_mvvm_architecture_practice.databinding.ActivityMainBinding
import com.example.android_kotlin_mvvm_architecture_practice.model.repository.MainRepository
import com.example.android_kotlin_mvvm_architecture_practice.model.repository.ToDo
import com.example.android_kotlin_mvvm_architecture_practice.viewmodel.MainViewModel
import com.example.android_kotlin_mvvm_architecture_practice.viewmodel.MainViewModelFactory
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mSharedPreferences: SharedPreferences
    val mAdapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initSharedPreferences()
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        viewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository(mSharedPreferences))).get(MainViewModel::class.java)
        mBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        mBinding.recyclerView.addItemDecoration(DividerItemDecoration(mBinding.recyclerView.context, (mBinding.recyclerView.layoutManager as LinearLayoutManager).orientation))
        mBinding.recyclerView.adapter = mAdapter
        viewModel.getToDoList().observe(this, {
            renderList(it)
        })

    }

    private fun renderList(toDoList: List<ToDo>) {
        mAdapter.setToDoList(toDoList)
    }

    private fun initSharedPreferences() {
        mSharedPreferences = this.getPreferences(Context.MODE_PRIVATE) ?: return
    }
}