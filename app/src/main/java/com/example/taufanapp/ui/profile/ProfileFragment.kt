/**
 * Tanggal Pengerjaan: 22 Mei 2025
 * NIM: 10123903
 * Nama: Taufan Ikhsan Firdaus
 * Kelas: IF12K
 */

package com.example.taufanapp.ui.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.taufanapp.R

class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        view.findViewById<View>(R.id.btn_call).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:085794555701"))
            startActivity(intent)
        }

        view.findViewById<View>(R.id.btn_email).setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:taufanikhsan20@gmail.com"))
            startActivity(intent)
        }

        view.findViewById<View>(R.id.btn_instagram).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/tfnisan"))
            startActivity(intent)
        }

        view.findViewById<View>(R.id.btn_find_me).setOnClickListener {
            // Koordinat Cangkuang, Bandung (Approx)
            val gmmIntentUri = Uri.parse("geo:0,0?q=Ciluncat, Cangkuang, Bandung")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        view.findViewById<View>(R.id.btn_about).setOnClickListener {
            showAboutDialog()
        }

        return view
    }

    private fun showAboutDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("About Application")
        builder.setMessage("Taufan App v1.0\nCreated for Mobile Programming Assignment\n\nNIM: 10123903\nNama: Taufan Ikhsan Firdaus\nKelas: IF12K")
        builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        builder.show()
    }
}