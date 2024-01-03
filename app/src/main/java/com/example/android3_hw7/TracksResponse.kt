package com.example.android3_hw7

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TracksResponse(
    @SerializedName("hasMore")
    val hasMore: HasMore,
    @SerializedName("tracks")
    val tracks: List<Track>
)

data class PL(
    @SerializedName("id")
    val uId: Int,
    @SerializedName("name")
    val name: String,
)

data class HasMore(
    @SerializedName("skip")
    val skip: Int
)


data class Track(
    @SerializedName("_id")
    val id: String?,
    @SerializedName("eId")
    val eId: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("img")
    val img: String?,
    @SerializedName("uId")
    val uId: String?,
    @SerializedName("uNm")
    val uNm: String?,
    @SerializedName("pl")
    val pl: PL,
    @SerializedName("pId")
    val pId: String?,
    @SerializedName("nbR")
    val nbR: Int,
    @SerializedName("nbL")
    val nbL: Int,
    @SerializedName("score")
    val score: Int,
    @SerializedName("trackUrl")
    val trackUrl: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        TODO("pl"),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(eId)
        parcel.writeString(name)
        parcel.writeString(img)
        parcel.writeString(uId)
        parcel.writeString(uNm)
        parcel.writeString(pId)
        parcel.writeInt(nbR)
        parcel.writeInt(nbL)
        parcel.writeInt(score)
        parcel.writeString(trackUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Track> {
        override fun createFromParcel(parcel: Parcel): Track {
            return Track(parcel)
        }

        override fun newArray(size: Int): Array<Track?> {
            return arrayOfNulls(size)
        }
    }
}

