package com.example.trafficsignal

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.trafficsignal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFrontStop.setOnClickListener {
            turnOnn(TrafficLight.FRONT_RED)
        }

        binding.btnFrontGo.setOnClickListener {
            turnOnn(TrafficLight.RIGHT_RED)
            turnOnn(TrafficLight.FRONT_GREEN)
        }

        binding.btnFrontSlowDown.setOnClickListener {
            turnOnn(TrafficLight.RIGHT_RED)
            turnOnn(TrafficLight.FRONT_YELLOW)
        }

        binding.btnRightStop.setOnClickListener {
            turnOnn(TrafficLight.RIGHT_RED)
        }

        binding.btnRightGo.setOnClickListener {
            turnOnn(TrafficLight.FRONT_RED)
            turnOnn(TrafficLight.RIGHT_GREEN)
        }

        binding.btnRightSlowDown.setOnClickListener {
            turnOnn(TrafficLight.FRONT_RED)
            turnOnn(TrafficLight.RIGHT_YELLOW)
        }

    }

    private fun turnOnn(light: TrafficLight) {
        when (light) {
            TrafficLight.FRONT_RED -> {
                switchFrontLight(isRedEnable = true)
            }

            TrafficLight.FRONT_GREEN -> {
                switchFrontLight(isGreenEnable = true)
            }

            TrafficLight.FRONT_YELLOW -> {
                switchFrontLight(isYellowEnable = true)
            }

            TrafficLight.RIGHT_RED -> {
                switchRightLight(isRedEnable = true)
            }

            TrafficLight.RIGHT_GREEN -> {
                switchRightLight(isGreenEnable = true)
            }

            TrafficLight.RIGHT_YELLOW -> {
                switchRightLight(isYellowEnable = true)
            }
        }
    }

    fun switchFrontLight(
        isRedEnable: Boolean = false,
        isGreenEnable: Boolean = false,
        isYellowEnable: Boolean = false
    ) {
        binding.vFrontRed.setBackgroundColor(if (isRedEnable) Color.RED else Color.GRAY)
        binding.vFrontGreen.setBackgroundColor(if (isGreenEnable) Color.GREEN else Color.GRAY)
        binding.vFrontYellow.setBackgroundColor(if (isYellowEnable) Color.YELLOW else Color.GRAY)
        disableButtons()
    }

    fun switchRightLight(
        isRedEnable: Boolean = false,
        isGreenEnable: Boolean = false,
        isYellowEnable: Boolean = false
    ) {
        binding.vRightRed.setBackgroundColor(if (isRedEnable) Color.RED else Color.GRAY)
        binding.vRightGreen.setBackgroundColor(if (isGreenEnable) Color.GREEN else Color.GRAY)
        binding.vRightYellow.setBackgroundColor(if (isYellowEnable) Color.YELLOW else Color.GRAY)
        disableButtons()
    }

    fun disableButtons() {
        binding.btnFrontGo.isEnabled = false
        binding.btnFrontSlowDown.isEnabled = false
        binding.btnRightGo.isEnabled = false
        binding.btnRightSlowDown.isEnabled = false


        Handler().postDelayed({
            binding.btnFrontGo.isEnabled = true
            binding.btnFrontSlowDown.isEnabled = true
            binding.btnRightGo.isEnabled = true
            binding.btnRightSlowDown.isEnabled = true
        }, 5000)

    }
}