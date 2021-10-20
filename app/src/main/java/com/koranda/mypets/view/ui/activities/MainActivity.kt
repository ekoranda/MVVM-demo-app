package com.koranda.mypets.view.ui.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.koranda.mypets.R
import com.koranda.mypets.data.repository.model.Pet
import com.koranda.mypets.databinding.ActivityMainBinding
import com.koranda.mypets.view.adapter.MyAdapter
import com.koranda.mypets.viewModel.AnimalsViewModel

class MainActivity : AppCompatActivity() {
    private var rv: RecyclerView? = null


    private fun initializeViews() {
        rv = findViewById(R.id.mRecyclerView)
    }


    private fun setupRecyclerView(pets: List<Pet>) {
        rv!!.layoutManager = LinearLayoutManager(this)
        //TODO: add adapter
        val adapter = MyAdapter(pets)
        rv!!.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
       bindData()


    }


    private fun bindData() {
        val animalsViewModel: AnimalsViewModel =
            ViewModelProviders.of(this).get(AnimalsViewModel::class.java)
           animalsViewModel.getAllPets()?.observe(this) { mPets ->
            setupRecyclerView(mPets)

        }
    }

}