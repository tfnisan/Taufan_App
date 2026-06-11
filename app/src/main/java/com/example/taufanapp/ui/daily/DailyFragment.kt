/**
 * Tanggal Pengerjaan: 22 Mei 2025
 * NIM: 10123903
 * Nama: Taufan Ikhsan Firdaus
 * Kelas: IF12K
 */

package com.example.taufanapp.ui.daily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taufanapp.R
import com.example.taufanapp.database.AppDatabase
import com.example.taufanapp.ui.adapter.DailyAdapter
import com.example.taufanapp.ui.adapter.FriendAdapter
import kotlinx.coroutines.launch

class DailyFragment : Fragment() {

    private lateinit var dailyAdapter: DailyAdapter
    private lateinit var friendAdapter: FriendAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_daily, container, false)

        // Setup Friend List (Horizontal)
        val rvFriends: RecyclerView = view.findViewById(R.id.rv_friends)
        friendAdapter = FriendAdapter(emptyList())
        rvFriends.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvFriends.adapter = friendAdapter

        // Setup Daily List (Vertical)
        val rvDaily: RecyclerView = view.findViewById(R.id.rv_daily)
        dailyAdapter = DailyAdapter(emptyList())
        rvDaily.layoutManager = LinearLayoutManager(context)
        rvDaily.adapter = dailyAdapter

        loadData()

        return view
    }

    private fun loadData() {
        val db = AppDatabase.getDatabase(requireContext(), lifecycleScope)
        lifecycleScope.launch {
            val friends = db.appDao().getAllFriends()
            friendAdapter.updateData(friends)

            val activities = db.appDao().getAllActivities()
            dailyAdapter.updateData(activities)
        }
    }
}