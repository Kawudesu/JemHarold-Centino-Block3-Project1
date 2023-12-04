package com.example.centino.jemharold.block3.p1.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.centino.jemharold.block3.p1.quiz.databinding.FragmentHomescreenBinding

class homescreen : Fragment() {

    private lateinit var binding: FragmentHomescreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomescreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener{
            findNavController().navigate(R.id.action_homescreen_to_mini2)
        }

    }
}