CountDownTimerFlow
-----------

An Android library written in Kotlin that wraps the CountDownTimer in Coroutines [Flow](https://github.com/Kotlin/kotlinx.coroutines/blob/master/kotlinx-coroutines-core/common/src/flow/Flow.kt).
Inspired by [RxCountDownTimer](https://github.com/wardellbagby/RxCountDownTimer)

Dependecy
-----------

Just copy-paste the [TimerFlow](https://github.com/ThanosFisherman/CountDownTimerFlow/blob/master/countdowntimerflow/src/main/java/io/github/thanosfisherman/countdowntimerflow/TimerFlow.kt) class to your project. This is all you really need. JCenter dependencies will also be available if there is demand.

Usage
------

Just launch a new Coroutine and call the function below. Also see [MainActivity][1]

```kotlin
   @ExperimentalCoroutinesApi
    private suspend fun setCountDown(millisInFuture: Long, countDownInterval: Long) {

        TimerFlow.create(millisInFuture, countDownInterval).collect {
            Log.i("main", it.toString())
            textView.text = it.toString()
        }
    }
```
License
-------
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)

    Copyright 2020 Thanos Psaridis

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]: https://github.com/ThanosFisherman/CountDownTimerFlow/blob/master/sample/src/main/java/io/github/thanosfisherman/countdowntimerflow/sample/MainActivity.kt
