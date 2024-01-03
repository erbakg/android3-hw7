package com.example.android3_hw7

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.android3_hw7.databinding.FragmentEmptyBinding


class EmptyFragment : Fragment() {
    private lateinit var container: FrameLayout;
    private lateinit var binding: FragmentEmptyBinding;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmptyBinding.inflate(layoutInflater)
        if (activity != null && activity is MainActivity) {
            val mainActivity = activity as MainActivity?

            // Access the FrameLayout from the MainActivity's binding
            val frameLayout: FrameLayout = mainActivity!!.binding.container1
            val params = frameLayout.layoutParams as LinearLayout.LayoutParams
            params.weight= 2F; // Set the new layout weight here
            frameLayout.setLayoutParams(params);
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}