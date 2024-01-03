package com.example.android3_hw7

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.transition.Transition
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.bumptech.glide.request.target.SimpleTarget
import com.example.android3_hw7.databinding.FragmentMusicInfoBinding
import kotlin.reflect.KClass


class MusicInfoFragment : Fragment() {
    private lateinit var binding: FragmentMusicInfoBinding;
    private lateinit var track : Track

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retrieveData()
        binding.tvMusicName.text = track.name.toString()
        binding.tvMusicSinger.text = track.pl.name.toString()
        context?.let {
            Glide.with(it)
                .load(track.img)
                .into(object : SimpleTarget<Drawable?>() {
                    override fun onResourceReady(
                        resource: Drawable,
                        transition: com.bumptech.glide.request.transition.Transition<in Drawable?>?
                    ) {
                        binding.musicImageBg.background = resource
                    }
                })
        }

    }

    private fun retrieveData() {
        track = arguments?.let { Track::class.getParcelable(it, CONSTANTS.TRACK) }!!

    }

    inline fun <reified T : Any> KClass<T>.getParcelable(bundle: Bundle, key: String): T? =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            bundle.getParcelable(key, T::class.java)
        else
            bundle.getParcelable(key)
}