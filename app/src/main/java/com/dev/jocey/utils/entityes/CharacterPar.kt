package com.dev.jocey.utils.entityes

import android.os.Parcel
import android.os.Parcelable

class CharacterPar(
    var name: String,
    var birth_year: String,
    var gender: String,
    var films: List<String>,
    var url: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.createStringArray()!!.toList(),
        parcel.readString().toString(),
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(birth_year)
        parcel.writeString(gender)
        parcel.writeStringArray(films.toTypedArray())
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CharacterPar> {
        override fun createFromParcel(parcel: Parcel): CharacterPar {
            return CharacterPar(parcel)
        }

        override fun newArray(size: Int): Array<CharacterPar?> {
            return arrayOfNulls(size)
        }
    }

}