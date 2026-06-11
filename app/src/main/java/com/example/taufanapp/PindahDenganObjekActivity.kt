package com.example.taufanapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PindahDenganObjekActivity : AppCompatActivity() {

    private lateinit var txtObject: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_dengan_objek)

        txtObject = findViewById(R.id.txt_object)

        // Menerima Objek Parcelable
        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON)

        if (person != null) {
            val text = "Nama: ${person.name}\nEmail: ${person.email}\nUmur: ${person.age}\nKota: ${person.city}"
            txtObject.text = text
        }
    }

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
}
