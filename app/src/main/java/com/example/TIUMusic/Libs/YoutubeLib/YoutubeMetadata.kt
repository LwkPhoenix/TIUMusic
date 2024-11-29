package com.example.TIUMusic.Libs.YoutubeLib

import android.graphics.Bitmap

data class YoutubeMetadata (
    val title : String,
    val artist : String,
    val artBitmap : Bitmap? = null,
    val displayTitle : String = "TIUMusic",
    val displaySubtitle : String = "TIUMusic",
)