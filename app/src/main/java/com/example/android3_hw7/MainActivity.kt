package com.example.android3_hw7

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.android3_hw7.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding;
    private var tracksList :List<Track>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        if(tracksList != null){

        } else {
            Toast.makeText(applicationContext, R.string.toast_error, Toast.LENGTH_LONG).show()
        }
    }
    private fun prepareAndShowFragment(fragment: Fragment, passedTracksList: List<Track>, container: Int) {

        val bundle = Bundle()
        bundle.putParcelable(CONSTANTS.TRACK, passedTracksList[0] as Parcelable)
        fragment.arguments = bundle

        showFragment(fragment, container)
    }

    private fun showFragment(fragment: Fragment, container: Int) {
        supportFragmentManager.beginTransaction().add(container, fragment)
            .commit()
    }

    private fun loadData() {
        val call = ApiClient.apiService.getTracks()
        call.enqueue(object: retrofit2.Callback<TracksResponse> {
            override fun onResponse(
                call: Call<TracksResponse>,
                response: Response<TracksResponse>
            ) {
                if (response.isSuccessful) {
                    tracksList = response.body()?.tracks ?: null
                    prepareAndShowFragment(MusicInfoFragment(), response.body()?.tracks!!, R.id.container1)
                    showFragment(MusicListFragment(), R.id.container2)
                }

            }

            override fun onFailure(call: Call<TracksResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
    }
