package com.tieorange.leanmvpdatabinding.domain.model

import android.os.Parcel
import android.os.Parcelable


data class Address(
        val city: String,
        val street: String,
        val buildingNumber: String,
        val apartmentNumber: String,
        val postalCode: String) : Parcelable {

    val streetAddress: String
        get() = if (apartmentNumber.isNullOrEmpty()) "$street $buildingNumber"
        else "$street $buildingNumber/$apartmentNumber"


    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()
    )

    override fun describeContents(): Int = 0

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(city)
        parcel.writeString(street)
        parcel.writeString(buildingNumber)
        parcel.writeString(apartmentNumber)
        parcel.writeString(postalCode)
    }

    companion object {
        val EMPTY_OBJECT = Address("?", "?", "?", "?", "?")

        @JvmField val CREATOR: Parcelable.Creator<Address> = object : Parcelable.Creator<Address> {

            override fun newArray(size: Int): Array<Address?> {
                return arrayOfNulls<Address>(size)
            }

            override fun createFromParcel(parcel: Parcel): Address {
                return Address(parcel)
            }
        }
    }
}