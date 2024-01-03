package com.example.android3_hw7

import android.os.Parcel
import android.os.Parcelable

class BaseParcelable : Parcelable {

    var value: Any

    constructor(value: Any) {
        this.value = value
    }

    constructor(parcel: Parcel) {
        this.value = Any()
    }

    override fun describeContents(): Int = 0
    override fun writeToParcel(p0: Parcel, p1: Int) {

    }

    companion object CREATOR : Parcelable.Creator<BaseParcelable> {

        override fun createFromParcel(parcel: Parcel): BaseParcelable {
            return BaseParcelable(parcel)
        }

        override fun newArray(size: Int): Array<BaseParcelable?> {
            return arrayOfNulls(size)
        }
    }
}