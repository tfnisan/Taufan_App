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
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taufanapp.R
import com.example.taufanapp.database.DailyActivity

class DailyAdapter(private var list: List<DailyActivity>) : RecyclerView.Adapter<DailyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.img_activity)
        val txtTime: TextView = view.findViewById(R.id.txt_time)
        val txtActivity: TextView = view.findViewById(R.id.txt_activity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_daily, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.txtTime.text = item.time
        holder.txtActivity.text = item.activity
        holder.img.setImageResource(item.imageResId)
    }

    override fun getItemCount() = list.size

    fun updateData(newList: List<DailyActivity>) {
        list = newList
        notifyDataSetChanged()
    }
}