package com.example.TIUMusic.Libs.YoutubeLib.models.TIUMusic

import android.util.Log
import com.example.TIUMusic.SongData.MusicItem
import kotlin.math.min

data class Chart(
    val videoPlaylist : TrendingVideoPlaylist,
    val songs : List<TrendingSong>
) {
    data class TrendingVideoPlaylist (
        val playlistId : String,
        val videos : List<TrendingVideo>
    )

    fun songsToMusicItem(rowSize: Int) : List<List<MusicItem>> {
        Log.d("HERE", songs.size.toString());
        val musicItems = mutableListOf<List<MusicItem>>();
        val columnSize = songs.size / rowSize;
        for (i in 0 until columnSize) {
            val rowItems = mutableListOf<MusicItem>();
            for (j in i * rowSize until min((i + 1) * rowSize, songs.size)) {
                rowItems.add(
                    MusicItem(
                        id = songs[j].videoId,
                        title = songs[j].title,
                        artist = songs[j].artists?.firstOrNull()?.name ?: "",
                        imageUrl = songs[j].thumbnail
                    )
                );
            }
            musicItems.add(rowItems);
        }
        if (musicItems.isEmpty() && songs.isNotEmpty()) {
            val rowItems = mutableListOf<MusicItem>();
            for (i in 0 until songs.size) {
                rowItems.add(MusicItem(
                        id = songs[i].videoId,
                        title = songs[i].title,
                        artist = songs[i].artists?.firstOrNull()?.name ?: "",
                        imageUrl = songs[i].thumbnail
                    )
                );
            }
            musicItems.add(rowItems);
        }
        return musicItems;
    }
}