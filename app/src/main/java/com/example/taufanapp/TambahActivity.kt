package com.example.taufanapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class TambahActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnSimpan: Button
    private lateinit var rgGender: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)

        btnSimpan = findViewById(R.id.btn_simpan)
        rgGender = findViewById(R.id.rg_gender)

        btnSimpan.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_simpan) {
            val checkedId = rgGender.checkedRadioButtonId
            if (checkedId > 0) {
                var value = ""
                when (checkedId) {
                    R.id.radio_laki -> value = "Laki-laki"
                    R.id.radio_perempuan -> value = "Perempuan"
                }

                // Mengemas data balikan ke Intent kosong
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(Activity.RESULT_OK, resultIntent)
                finish() // Menghancurkan activity untuk memicu callback launcher di MainActivity
            }
        }
    }

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }
}
