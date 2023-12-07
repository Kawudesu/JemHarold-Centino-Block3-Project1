package com.example.centino.jemharold.block3.p1.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.centino.jemharold.block3.p1.quiz.databinding.FragmentCalculatorBinding

class calculator : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding
    private lateinit var firstNumber_et: EditText
    private lateinit var secondNumber_et: EditText
    private lateinit var result_tv: TextView
    private lateinit var additionButton_btn: Button
    private lateinit var subtractionButton_btn: Button
    private lateinit var multiplicationButton_btn: Button
    private lateinit var divisionButton_btn: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstNumber_et = binding.firstNumber
        secondNumber_et = binding.secondNumber
        result_tv = binding.calcu
        additionButton_btn = binding.additionButton
        subtractionButton_btn = binding.subtractionButton
        multiplicationButton_btn = binding.multiplicationButton
        divisionButton_btn = binding.division

        additionButton_btn.setOnClickListener {
            performOperation('+')
        }
        subtractionButton_btn.setOnClickListener {
            performOperation('-')
        }
        multiplicationButton_btn.setOnClickListener {
            performOperation('*')
        }
        divisionButton_btn.setOnClickListener {
            performOperation('/')
        }

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_calculator_to_homescreen)
        }
    }

    private fun performOperation(operator: Char){
        val num1 = firstNumber_et.text.toString().toDoubleOrNull()
        val num2 = secondNumber_et.text.toString().toDoubleOrNull()


        if(num1 != null && num2 != null){
            val result = when (operator){
                '+' -> (num1 + num2).toInt()
                '-' -> (num1 - num2).toInt()
                '*' -> (num1 * num2).toInt()
                '/' -> if(num2 != 0.0) num1 / num2 else Double.NaN
                else -> Double.NaN
            }
            result_tv.text = "Result: $result"
        } else{
            result_tv.text = "Invalid Input"
        }
    }
}