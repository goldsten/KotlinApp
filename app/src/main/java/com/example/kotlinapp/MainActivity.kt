package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.kotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	private var timer: CountDownTimer? = null

	override fun onCreate(s: Bundle?) {
		binding = ActivityMainBinding.inflate(layoutInflater)
		super.onCreate(s)
		setContentView(binding.root)

		// по нажатию запускаем таймер
		binding.apply {
			start.setOnClickListener {
				startCountDownTimer(5000)
			}
		}
	}
	private fun startCountDownTimer(timeSecond:Long){
		// проверяем если таймер запущен, то нажимать стоп
		timer?.cancel()

		// (1, 2) 1.указываем сколько времени будем отсчитывать 2. интервал (1-милисекунда, 1000-секунда)
		timer = object : CountDownTimer(timeSecond, 1){
			// запускается каджый раз в зависимости от шага
			override fun onTick(time: Long) {
				binding.textView.text = time.toString()
			}

			override fun onFinish() {
				binding.textView.text = "Happy New Year!"
			}
		// запуск/перезапуск
		}.start()
	}
}