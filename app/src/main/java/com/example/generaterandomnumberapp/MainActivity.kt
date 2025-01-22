package com.example.generaterandomnumberapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.generaterandomnumberapp.databinding.ActivityMainBinding
import kotlin.math.round
import kotlin.random.Random
import kotlin.random.nextUInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//    code block
        binding.buttonGenerate.setOnClickListener() {
            val from = binding.rangeSlider.values[0]
            val to = binding.rangeSlider.values[1]

            val randomNumber = Random.nextDouble(from.toDouble(), to.toDouble())

            binding.generatedNumber.text =
                String.format("Generated Number is:    %.3f", randomNumber)
            if (binding.isInt.isChecked) {
            Toast.makeText(this, "num is:   $randomNumber", Toast.LENGTH_SHORT).show()

            } else {
                Log.i("Msg", "This is msg")
            }
        }
    }
}