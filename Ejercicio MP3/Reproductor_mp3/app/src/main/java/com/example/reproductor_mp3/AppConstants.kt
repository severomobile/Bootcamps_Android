package com.example.reproductor_mp3

import android.adservices.adid.AdId

data class Song(
    val title: String,
    val audioId: Int,
    val imageId: Int
)

class AppConstants {
    companion object {

        const val LOG_MAIN_ACTIVITY = "MainActivityReproductor"
        const val MEDIA_PLAYER_POSITION = "mp3Posicion"
        const val CURRENT_SONG_INDEX = "currentSongIndex"
        const val IS_PLAYING = "isPlaying"

        val songs = listOf(
            Song("Pretty Please Remix - Dua Lipa", R.raw.pp_remix, R.drawable.pretty_please),
            Song("Summertime Sadness Remix - Lana del Rey", R.raw.lr_ss, R.drawable.lr_ss),
            Song("In the end Remix - Linkin Park", R.raw.lp_in_the_end_remix, R.drawable.lp_in_the_emd_remix)
        )
    }
}
