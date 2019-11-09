package com.example.Paging.data.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PhotoX(
    @SerializedName("id")
    var id: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("thumb_url")
    var thumbUrl: String,
    @SerializedName("user")
    var user: User,
    @SerializedName("res_id")
    var resId: Int,
    @SerializedName("caption")
    var caption: String,
    @SerializedName("timestamp")
    var timestamp: Int,
    @SerializedName("friendly_time")
    var friendlyTime: String,
    @SerializedName("width")
    var width: Int,
    @SerializedName("height")
    var height: Int
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readParcelable<User>(User::class.java.classLoader),
        source.readInt(),
        source.readString(),
        source.readInt(),
        source.readString(),
        source.readInt(),
        source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(id)
        writeString(url)
        writeString(thumbUrl)
        writeParcelable(user, 0)
        writeInt(resId)
        writeString(caption)
        writeInt(timestamp)
        writeString(friendlyTime)
        writeInt(width)
        writeInt(height)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<PhotoX> = object : Parcelable.Creator<PhotoX> {
            override fun createFromParcel(source: Parcel): PhotoX = PhotoX(source)
            override fun newArray(size: Int): Array<PhotoX?> = arrayOfNulls(size)
        }
    }
}