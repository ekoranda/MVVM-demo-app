package com.koranda.mypets.data.repository.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.koranda.mypets.data.repository.model.Pet
import org.json.JSONObject.NULL
import java.util.ArrayList

class PetsRepository {
    val database = Firebase.database.getReference("Pets")

    fun select(): MutableLiveData<List<Pet>>? {

        val mLiveData: MutableLiveData<List<Pet>> = MutableLiveData()
        val data = ArrayList<Pet>()
        database.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val children = snapshot!!.children
                children.forEach{

                    val pet: Pet = Pet()
                    pet.name = it.child("/Name").value.toString()
                    pet.type = it.child("/Type").value.toString()
                    pet.image = it.child("/Image").value.toString()
                    if(pet != null){
                        data.add(pet)
                    }
                }
                mLiveData.postValue(data)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        return mLiveData
    }


}