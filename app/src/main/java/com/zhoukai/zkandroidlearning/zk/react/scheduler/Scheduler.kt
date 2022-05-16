package com.zhoukai.zkandroidlearning.zk.react.scheduler

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executors

interface Scheduler {

    fun run(block: () -> Unit)
}

object AndroidMainScheduler : Scheduler {

    private val handler = Handler(Looper.myLooper()!!)

    override fun run(block: () -> Unit) {
        handler.post(block)
    }
}

object IOScheduler: Scheduler {

   private val executor = Executors.newSingleThreadExecutor()

    override fun run(block: () -> Unit) {
        executor.submit(block)
    }
}
