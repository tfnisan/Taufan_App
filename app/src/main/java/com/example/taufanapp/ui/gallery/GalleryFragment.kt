/**
 * Tanggal Pengerjaan: 22 Mei 2025
 * NIM: 10123903
 * Nama: Taufan Ikhsan Firdaus
 * Kelas: IF12K
 */

package com.example.taufanapp.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taufanapp.R
import com.example.taufanapp.database.AppDatabase
import com.example.taufanapp.ui.adapter.GalleryAdapter
import kotlinx.coroutines.launch

class GalleryFragment : Fragment() {

    private lateinit var adapter: GalleryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        val rvGallery: RecyclerView = view.findViewById(R.id.rv_gallery)
        adapter = GalleryAdapter(emptyList())
        rvGallery.layoutManager = GridLayoutManager(context, 2)
        rvGallery.adapter = adapter

        loadData()

        return view
    }

    private fun loadData() {
        val db = AppDatabase.getDatabase(requireContext(), lifecycleScope)
        lifecycleScope.launch {
            val data = db.appDao().getAllGallery()
            adapter.updateData(data)
        }
    }
}