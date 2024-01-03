package com.example.android3_hw7

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android3_hw7.databinding.FragmentMusicListBinding
import retrofit2.Call
import retrofit2.Response

class MusicListFragment : Fragment() {
    private lateinit var binding: FragmentMusicListBinding
    private lateinit var adapter: MusicListAdapter
    private lateinit var musicList: List<Track>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMusicListBinding.inflate(layoutInflater)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    private fun loadData() {
        val call = ApiClient.apiService.getTracks()
        call.enqueue(object : retrofit2.Callback<TracksResponse> {
            override fun onResponse(
                call: Call<TracksResponse>,
                response: Response<TracksResponse>
            ) {
                if (response.isSuccessful) {
                    musicList = (response.body()?.tracks ?: null)!!
                    if(response.body()?.tracks !== null){
                        adapter = response.body()?.tracks?.let { MusicListAdapter(it, (activity as MainActivity)) }!!
                        binding.rvTracksList.layoutManager = LinearLayoutManager(context)
                        binding.rvTracksList.adapter = adapter
                    }

                }
            }

            override fun onFailure(call: Call<TracksResponse>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}
