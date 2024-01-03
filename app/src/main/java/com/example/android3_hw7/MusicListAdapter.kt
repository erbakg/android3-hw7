package com.example.android3_hw7

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android3_hw7.databinding.ItemTrackInfoBinding


class MusicListAdapter(private val tracksList: List<Track>, val activity: MainActivity) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTrackInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(tracksList[position], position)
        holder.itemView.setOnClickListener {
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.container1, EmptyFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun getItemCount(): Int {
        return tracksList.size
    }
}

class ViewHolder(val binding: ItemTrackInfoBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(track: Track, position: Int) {
        binding.tvTrackNumber.text = (position + 1).toString()
        binding.tvTrackDuration.text = "${track.nbR}:${track.nbL}${track.score}"
        binding.tvMusicName.text = track.name
        itemView.setOnClickListener {
//            supportFragmentManager.beginTransaction().add(container, fragment)
//                .commit()
        }
//        binding.tvMusicSinger.text = track.pl.name
    }
}