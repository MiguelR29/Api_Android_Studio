package com.example.usoapis33

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var service: ServiceAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(ServiceAPI::class.java)

        val url = retrofit.baseUrl().toString() + "posts"
        println("URL: $url")

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = service.getUserPost()
                println("Response from API: $response")
                response.forEach {
                    println("User ID: ${it.userId}, ID: ${it.id}, Title: ${it.title}, Body: ${it.body}")
                }
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }
}
