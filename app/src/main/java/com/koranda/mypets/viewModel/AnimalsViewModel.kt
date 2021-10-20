package com.koranda.mypets.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.koranda.mypets.data.repository.repository.PetsRepository
import com.koranda.mypets.data.repository.model.Pet


class AnimalsViewModel(application: Application) : AndroidViewModel(application) {
    //TODO: make repository
    private val petsRepository: PetsRepository
    //TODO: make data class



    init {
        petsRepository = PetsRepository()
    }

    fun getAllPets(): MutableLiveData<List<Pet>>? {
        return petsRepository.select()
    }
}
