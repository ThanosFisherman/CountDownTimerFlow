package io.github.thanosfisherman.countdowntimerflow.sample

import TimerFlow
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStart.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                setCountDown(5000, 1000)
            }
        }
    }

    @ExperimentalCoroutinesApi
    private suspend fun setCountDown(millisInFuture: Long, countDownInterval: Long) {

        TimerFlow.create(millisInFuture, countDownInterval).collect {
            Log.i("main", it.toString())
            textView.text = it.toString()
        }
    }
}
