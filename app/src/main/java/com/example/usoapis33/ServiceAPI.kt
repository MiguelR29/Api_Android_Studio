package com.example.usoapis33

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Retrofit
import retrofit2.http.GET

interface ServiceAPI{
    @GET("posts")
    suspend fun getUserPost():ArrayList<DataModel>
}