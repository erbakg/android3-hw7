package com.example.android3_hw7
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("hot?format=json")
    fun getTracks() : Call<TracksResponse>
}