package io.github.thanosfisherman.countdowntimerflow

import android.os.Looper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow

@ExperimentalCoroutinesApi
class TimerFlow private constructor() {


    private fun tick(millisInFuture: Long, countDownInterval: Long): Flow<Long> = channelFlow {

        if (Looper.myLooper() == null) {
            throw IllegalStateException("Can't create RxCountDownTimer inside thread that has not called Looper.prepare()")
        }

        val timer = ConcreteCountDownTimer(this, millisInFuture, countDownInterval)
        timer.start()


    }

    companion object {
        /**
         * Create a [Flow] that will be a countdown until a specified time in the future.
         *
         * @param millisInFuture The milliseconds in the future that this will countdown to.
         * @param countDownInterval The minimum amount of time between emissions.
         */
        @JvmStatic
        fun create(millisInFuture: Long, countDownInterval: Long) =
            TimerFlow().tick(millisInFuture, countDownInterval)
    }
}