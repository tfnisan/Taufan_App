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
import com.example.taufanapp.database.Friend
import de.hdodenhof.circleimageview.CircleImageView

class FriendAdapter(private var list: List<Friend>) : RecyclerView.Adapter<FriendAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: CircleImageView = view.findViewById(R.id.img_friend)
        val txtName: TextView = view.findViewById(R.id.txt_friend_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_friend, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.txtName.text = item.name
        holder.img.setImageResource(item.imageResId)
    }

    override fun getItemCount() = list.size

    fun updateData(newList: List<Friend>) {
        list = newList
        notifyDataSetChanged()
    }
}