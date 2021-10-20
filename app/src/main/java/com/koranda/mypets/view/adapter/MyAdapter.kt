package com.koranda.mypets.view.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.Image
import android.text.Spannable
import android.text.style.ForegroundColorSpan
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.koranda.mypets.R
import com.koranda.mypets.data.repository.model.Pet
import java.util.*
import android.graphics.BitmapFactory

import android.graphics.Bitmap
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class MyAdapter(private val mList: List<Pet>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    val storage = FirebaseStorage.getInstance()



    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.model, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {



        val petData = mList[position]

        holder.nameViewText.text = petData.name
        holder.typeViewText.text = petData.type
        Glide.with(holder.photo.context).load(petData.image).into(holder.photo)




    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val nameViewText: TextView = itemView.findViewById(R.id.tv_name)
        val typeViewText: TextView = itemView.findViewById(R.id.tv_type)
        val photo: ImageView = itemView.findViewById(R.id.iconSection)


    }


}