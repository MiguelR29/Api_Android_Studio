package com.example.usoapis33

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.annotations.SerializedName

data class  DataModel(
    @SerializedName("serId")
	val userId: Int,
	@SerializedName("id")
	val id: Int,
	@SerializedName("title")
	val title: String,
	@SerializedName("body")
	val body: String,
)