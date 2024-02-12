package com.example.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.temperatureconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var f_val = 0
    private var c_val = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.CelsiusSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.CelsiusProgress.text = "$progress°C"
                f_val = (progress * 9/5) + 32
                binding.FahrenheitSeekBar.setProgress(f_val, true)
                updateMessage()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        binding.FahrenheitSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.FahrenheitProgress.text = "$progress°F"
                c_val = (progress - 32) * 5/9
                if (c_val >= 0){
                    binding.CelsiusSeekBar.setProgress(c_val, true)
                }
                else {
                    binding.FahrenheitSeekBar.setProgress(32, true)
                }
                updateMessage()


            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }
    private fun updateMessage(){
        if ( c_val <= 20 ) {
            binding.interestingMessage.setText(R.string.interesting_message_warmer)
        }
        else {
            binding.interestingMessage.setText(R.string.interesting_message_cooler)
        }
    }
}