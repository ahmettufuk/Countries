package com.ahmettufuk.countrieskt.model

import android.widget.ImageView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity
data class Country(

    @ColumnInfo(name= "name")
    @SerializedName("name")
    val countryName: String?,
    @ColumnInfo(name = "capital")
    @SerializedName("capital")
    val capitalName: String?,
    @ColumnInfo(name = "region")
    @SerializedName("region")
    val regionName: String?,
    @ColumnInfo(name = "currency")
    @SerializedName("currency")
    val currencyName: String?,
    @ColumnInfo(name = "flag")
    @SerializedName("flag")
    val flagImageUrl : String,
    @ColumnInfo(name = "language")
    @SerializedName("language")
    val Language: String?) {

    @PrimaryKey(autoGenerate = true)
    var uuid : Int = 0
}

