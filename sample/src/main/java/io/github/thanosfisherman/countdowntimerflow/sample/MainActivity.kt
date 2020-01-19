package io.github.thanosfisherman.countdowntimerflow.sample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.github.thanosfisherman.countdowntimerflow.TimerFlow
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text = "PLS"
        btnStart.setOnClickListener {
            runBlocking {
                setCountDown(5000, 1000)
            }

        }
    }

    @ExperimentalCoroutinesApi
    private suspend fun setCountDown(millisInFuture: Long, countDownInterval: Long) {

        TimerFlow.create(millisInFuture, countDownInterval).collect {
            Log.i("Main", it.toString())
        }

    }
}
