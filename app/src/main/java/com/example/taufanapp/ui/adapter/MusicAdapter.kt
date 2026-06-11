/**
 * Tanggal Pengerjaan: 22 Mei 2025
 * NIM: 10123903
 * Nama: Taufan Ikhsan Firdaus
 * Kelas: IF12K
 */

package com.example.taufanapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taufanapp.R
import com.example.taufanapp.database.Music

class MusicAdapter(private var list: List<Music>) : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtTitle: TextView = view.findViewById(R.id.txt_music_title)
        val txtArtist: TextView = view.findViewById(R.id.txt_music_artist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.txtTitle.text = item.title
        holder.txtArtist.text = item.artist
    }

    override fun getItemCount() = list.size

    fun updateData(newList: List<Music>) {
        list = newList
        notifyDataSetChanged()
    }
}