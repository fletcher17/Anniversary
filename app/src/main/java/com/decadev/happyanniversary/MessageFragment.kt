package com.decadev.happyanniversary

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.decadev.happyanniversary.databinding.FragmentMessageBinding


class MessageFragment : Fragment() {
        private var _binding: FragmentMessageBinding? = null
        private val binding get() = _binding!!

        private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMessageBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.timi_dakolo)

        val play = binding.playButton
        val stop = binding.stopButton

        if(mediaPlayer.isPlaying){
            play.text = getString(R.string.pause)
        } else {
            play.setOnClickListener {
                if (mediaPlayer.isPlaying) {
                    mediaPlayer.pause()
                    play.text = getString(R.string.play)
                } else {
                    mediaPlayer.start()
                    play.text = getString(R.string.pause)
                }
            }
        }


        stop.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.prepare()
            play.text = "PLAY"
        }

        return view
    }

//    override fun onResume() {
//        super.onResume()
//        val mediaPlayer: MediaPlayer = MediaPlayer.create(requireContext(), R.raw.timi_dakolo)
//
//        val play = binding.playButton
//        val stop = binding.stopButton
//
//        if(mediaPlayer.isPlaying){
//            play.text = getString(R.string.pause)
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}