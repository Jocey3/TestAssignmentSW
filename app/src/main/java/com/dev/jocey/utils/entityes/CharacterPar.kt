package com.dev.jocey.utils.entityes

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

class CharacterPar(
    var name: String,
    var birth_year: String,
    var gender: String,
    var films: List<String?>,
    var url: String,
    var favorite: Int

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.createStringArray()!!.toList(),
        parcel.readString().toString(),
        parcel.readInt()
    )


    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(birth_year)
        parcel.writeString(gender)
        parcel.writeStringArray(films.toTypedArray())
        parcel.writeString(url)
        parcel.writeInt(favorite)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CharacterPar> {
        @RequiresApi(Build.VERSION_CODES.Q)
        override fun createFromParcel(parcel: Parcel): CharacterPar {
            return CharacterPar(parcel)
        }

        override fun newArray(size: Int): Array<CharacterPar?> {
            return arrayOfNulls(size)
        }
    }

}