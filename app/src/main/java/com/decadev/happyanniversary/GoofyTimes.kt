package com.decadev.happyanniversary

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.decadev.happyanniversary.databinding.FragmentGoofyTimesBinding
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.upstream.RawResourceDataSource
import com.google.android.exoplayer2.util.Util


class GoofyTimes : Fragment() {
    private var _binding: FragmentGoofyTimesBinding? = null
    private val binding get() = _binding!!
    private var player: SimpleExoPlayer? = null
    private var playWhenIsReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentGoofyTimesBinding.inflate(layoutInflater, container, false)
        val view = binding.root



        return view
    }

    private fun initializePlayer() {
        player = SimpleExoPlayer.Builder(requireContext())
            .build()
            .also{exoPlayer ->
                binding.videoView.player = exoPlayer
                val videoPath = RawResourceDataSource.buildRawResourceUri(R.raw.videofromme).toString()
              //  val uri = RawResourceDataSource.buildRawResourceUri(R.raw.timi_dakolo)
                val mediaItem = MediaItem.fromUri(videoPath)
                exoPlayer.setMediaItem(mediaItem)

                exoPlayer.playWhenReady = playWhenIsReady
                exoPlayer.seekTo(currentWindow, playbackPosition)
                exoPlayer.prepare()
            }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT >= 24) {
            initializePlayer()
        }
    }

    override fun onResume() {
        super.onResume()
     //   hideSystemUi()
        if (Util.SDK_INT < 24 || player == null) {
            initializePlayer()
            releasePlayer()
        }
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT < 24) {
            releasePlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT >= 24) {
            releasePlayer()
        }
    }

    private fun releasePlayer() {
        player?.run {
            playbackPosition = this.currentPosition
            currentWindow = this.currentWindowIndex
            playWhenIsReady = this.playWhenReady
            release()
        }
        player = null
    }

//    @SuppressLint("InlinedApi")
//    private fun hideSystemUi() {
//        binding.videoView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
//                or View.SYSTEM_UI_FLAG_FULLSCREEN
//                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}