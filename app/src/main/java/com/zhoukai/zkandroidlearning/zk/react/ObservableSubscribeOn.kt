package com.zhoukai.zkandroidlearning.zk.react

import com.zhoukai.zkandroidlearning.zk.react.scheduler.Scheduler

class ObservableSubscribeOn<T>(private val scheduler: Scheduler, source: ObservableSource<T>) :
    ObservableWithUpStream<T, T>(source) {

    override fun doOnActualSubscribe(observer: Observer<T>) {
        scheduler.run {
            source.observe(observer)
        }
    }
}