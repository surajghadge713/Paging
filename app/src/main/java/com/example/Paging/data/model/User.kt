package com.example.acenutition.data.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name")
    var name: String,
    @SerializedName("foodie_level")
    var foodieLevel: String,
    @SerializedName("foodie_level_num")
    var foodieLevelNum: Int,
    @SerializedName("foodie_color")
    var foodieColor: String,
    @SerializedName("profile_url")
    var profileUrl: String,
    @SerializedName("profile_image")
    var profileImage: String,
    @SerializedName("profile_deeplink")
    var profileDeeplink: String
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readInt(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(foodieLevel)
        writeInt(foodieLevelNum)
        writeString(foodieColor)
        writeString(profileUrl)
        writeString(profileImage)
        writeString(profileDeeplink)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User = User(source)
            override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
        }
    }
}