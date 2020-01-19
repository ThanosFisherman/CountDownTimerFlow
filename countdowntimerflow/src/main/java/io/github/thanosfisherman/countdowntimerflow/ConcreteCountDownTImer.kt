package io.github.thanosfisherman.countdowntimerflow

import android.os.CountDownTimer
import android.util.Log
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.isActive

@ExperimentalCoroutinesApi
internal class ConcreteCountDownTimer constructor(
    private val producerScope: ProducerScope<Long>,
    millisInFuture: Long,
    countDownInterval: Long
) : CountDownTimer(millisInFuture, countDownInterval) {
    override fun onFinish() {
        Log.i("TIMER", "END")
        producerScope.safeOffer(0.toLong())
    }

    override fun onTick(millisUntilFinished: Long) {

            Log.i("TIMER", "$millisUntilFinished")

            producerScope.offer(millisUntilFinished)

    }
}