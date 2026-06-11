/**
 * Tanggal Pengerjaan: 22 Mei 2025
 * NIM: 10123903
 * Nama: Taufan Ikhsan Firdaus
 * Kelas: IF12K
 */

package com.example.taufanapp.ui.media

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taufanapp.R
import com.example.taufanapp.database.AppDatabase
import com.example.taufanapp.ui.adapter.MusicAdapter
import kotlinx.coroutines.launch

class MediaFragment : Fragment() {

    private lateinit var musicAdapter: MusicAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_media, container, false)

        // Setup Video
        val videoView: VideoView = view.findViewById(R.id.video_view)
        val mediaController = MediaController(context)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        
        // Menggunakan File Lokal (Sesuai video yang Anda tambahkan)
        val videoPath = "android.resource://" + requireActivity().packageName + "/" + R.raw.video_profil
        videoView.setVideoURI(Uri.parse(videoPath))

        videoView.setOnPreparedListener { 
            videoView.start() 
        }

        videoView.setOnErrorListener { _, _, _ ->
            // Jika error, video tidak akan membuat app crash
            true
        }

        // Setup Music List
        val rvMusic: RecyclerView = view.findViewById(R.id.rv_music)
        musicAdapter = MusicAdapter(emptyList())
        rvMusic.layoutManager = LinearLayoutManager(context)
        rvMusic.adapter = musicAdapter

        loadData()

        return view
    }

    private fun loadData() {
        val db = AppDatabase.getDatabase(requireContext(), lifecycleScope)
        lifecycleScope.launch {
            val music = db.appDao().getAllMusic()
            musicAdapter.updateData(music)
        }
    }
}