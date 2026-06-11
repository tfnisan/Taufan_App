package com.example.taufanapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PindahDenganDataActivity : AppCompatActivity() {

    private lateinit var txtData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_dengan_data)

        txtData = findViewById(R.id.txt_data)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        val text = "Nama: $name, Umur: $age"
        txtData.text = text
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_AGE = "extra_age"
    }
}
