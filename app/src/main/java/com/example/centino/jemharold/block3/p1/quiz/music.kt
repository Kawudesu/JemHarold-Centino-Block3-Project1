package com.example.centino.jemharold.block3.p1.quiz

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.centino.jemharold.block3.p1.quiz.databinding.FragmentMusicBinding

class music : Fragment() {

    private lateinit var binding: FragmentMusicBinding
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mediaPlayer = MediaPlayer()

        try {
            mediaPlayer.setDataSource(resources.openRawResourceFd(R.raw.whistle).fileDescriptor)
            mediaPlayer.prepare()

            binding.backButton.setOnClickListener {
                findNavController().navigate(R.id.action_music_to_mini2)
            }

            binding.playMusic.setOnClickListener {
                if (!mediaPlayer.isPlaying) {
                    mediaPlayer.start()
                    binding.playMusic.isEnabled = false
                }
            }
            mediaPlayer.setOnCompletionListener {
                binding.playMusic.isEnabled = true
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        mediaPlayer.release()
        super.onDestroy()
    }
}
