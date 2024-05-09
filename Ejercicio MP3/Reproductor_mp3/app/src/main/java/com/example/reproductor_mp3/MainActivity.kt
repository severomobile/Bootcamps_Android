package com.example.reproductor_mp3

import android.media.MediaPlayer
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.reproductor_mp3.AppConstants.Companion.CURRENT_SONG_INDEX
import com.example.reproductor_mp3.AppConstants.Companion.IS_PLAYING
import com.example.reproductor_mp3.AppConstants.Companion.LOG_MAIN_ACTIVITY
import com.example.reproductor_mp3.AppConstants.Companion.MEDIA_PLAYER_POSITION
import com.example.reproductor_mp3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mediaPlayer: MediaPlayer? = null
    private var posicionCancion: Int = 0
    private var currentSongIndex: Int = 0
    private lateinit var currentSong: Song
    private var isPlaying: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(LOG_MAIN_ACTIVITY, "onCreate()")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savedInstanceState?.let {
            posicionCancion = it.getInt(MEDIA_PLAYER_POSITION)
            currentSongIndex = it.getInt(CURRENT_SONG_INDEX)
            isPlaying = it.getBoolean(IS_PLAYING)
        }

        currentSong = AppConstants.songs[currentSongIndex]

        updateUISong()

        binding.playPauseButton.setOnClickListener { playOrPuaseMusic() }

        binding.playNextButton.setOnClickListener { playNextSong() }

        binding.playPreviousButton.setOnClickListener { playPreviousSong() }
    }

    override fun onStart() {
        super.onStart()
        Log.i(LOG_MAIN_ACTIVITY, "onStart()")
        mediaPlayer = MediaPlayer.create(this, currentSong.audioId)
        if (isPlaying)
            mediaPlayer?.start()
    }

    override fun onResume() {
        super.onResume()
        Log.i(LOG_MAIN_ACTIVITY, "onResume()")
        mediaPlayer?.seekTo(posicionCancion)
        if (isPlaying) {
            mediaPlayer?.start()
            isPlaying = !isPlaying
        }
    }

    override fun onPause() {
        super.onPause()
        Log.i(LOG_MAIN_ACTIVITY, "onPause()")
        isPlaying = false
        mediaPlayer?.seekTo(posicionCancion)
        if (mediaPlayer != null) {
            posicionCancion = mediaPlayer!!.currentPosition
        }
        mediaPlayer?.pause()
    }

    override fun onStop() {
        super.onStop()
        Log.i(LOG_MAIN_ACTIVITY, "onStop()")
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(LOG_MAIN_ACTIVITY, "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(LOG_MAIN_ACTIVITY, "onDestroy()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(MEDIA_PLAYER_POSITION, posicionCancion)
        outState.putInt(CURRENT_SONG_INDEX, currentSongIndex)
        outState.putBoolean(IS_PLAYING, isPlaying)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        posicionCancion = savedInstanceState.getInt(MEDIA_PLAYER_POSITION)
        currentSongIndex = savedInstanceState.getInt(CURRENT_SONG_INDEX)
        isPlaying = savedInstanceState.getBoolean(IS_PLAYING)
        currentSong = AppConstants.songs[currentSongIndex]
        updateUISong()
    }

    private fun updateUISong() {
        binding.titleTextView.text = currentSong.title
        binding.albumCoverImageView.setImageResource(currentSong.imageId)
        updatePlayPauseButton()
    }

    private fun playOrPuaseMusic() {
        if (isPlaying) {
            mediaPlayer?.pause()
        } else {
            mediaPlayer?.start()
        }
        isPlaying = !isPlaying
        updatePlayPauseButton()
    }

    private fun updatePlayPauseButton() {
        binding.playPauseButton.text = if (isPlaying) "Pause" else "Play"
    }

    private fun playNextSong() {
        currentSongIndex = (currentSongIndex + 1) % AppConstants.songs.size
        currentSong = AppConstants.songs[currentSongIndex]
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(this, currentSong.audioId)
        mediaPlayer?.start()
        isPlaying = true
        updateUISong()
    }

    private fun playPreviousSong() {
        currentSongIndex = (currentSongIndex - 1 + AppConstants.songs.size) % AppConstants.songs.size
        currentSong = AppConstants.songs[currentSongIndex]
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(this, currentSong.audioId)
        mediaPlayer?.start()
        isPlaying = true
        updateUISong()
    }
}
