/**
 * Tanggal Pengerjaan: 22 Mei 2025
 * NIM: 10123903
 * Nama: Taufan Ikhsan Firdaus
 * Kelas: IF12K
 */

package com.example.taufanapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.taufanapp.databinding.ActivityWalkthroughBinding

class WalkthroughActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWalkthroughBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWalkthroughBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pages = listOf(
            WalkthroughPage("Halo, Saya Taufan!", "Selamat datang di aplikasi profil pribadi saya. Senang berkenalan dengan Anda!", R.drawable.logo_taufan_app),
            WalkthroughPage("Eksplorasi Harian", "Lihat aktivitas harian dan hobi-hobi seru yang saya lakukan.", R.drawable.logo_taufan_app),
            WalkthroughPage("Mari Terhubung", "Temukan kontak saya dan jangan ragu untuk berdiskusi tentang desain atau IT.", R.drawable.logo_taufan_app)
        )

        val adapter = WalkthroughAdapter(pages)
        binding.viewPager.adapter = adapter
        binding.dotsIndicator.attachTo(binding.viewPager)

        binding.btnNext.setOnClickListener {
            if (binding.viewPager.currentItem + 1 < pages.size) {
                binding.viewPager.currentItem += 1
            } else {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }

    data class WalkthroughPage(val title: String, val desc: String, val image: Int)

    class WalkthroughAdapter(private val pages: List<WalkthroughPage>) : RecyclerView.Adapter<WalkthroughAdapter.ViewHolder>() {
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val title: TextView = view.findViewById(R.id.txt_title)
            val desc: TextView = view.findViewById(R.id.txt_desc)
            val image: ImageView = view.findViewById(R.id.img_walkthrough)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_walkthrough, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val page = pages[position]
            holder.title.text = page.title
            holder.desc.text = page.desc
            holder.image.setImageResource(page.image)
        }

        override fun getItemCount() = pages.size
    }
}