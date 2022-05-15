package com.zhoukai.zkandroidlearning.zk.react

interface Emitter<T> {

    fun onNext(t: T)

    fun onError(t: Throwable)

}