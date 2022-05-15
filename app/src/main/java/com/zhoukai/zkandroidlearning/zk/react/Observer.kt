package com.zhoukai.zkandroidlearning.zk.react

interface Observer<T> {

    fun onNext(t: T)

    fun onError(e: Throwable)

    fun onSubscribe()
}