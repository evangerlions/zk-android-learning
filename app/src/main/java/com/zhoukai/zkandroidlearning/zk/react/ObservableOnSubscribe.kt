package com.zhoukai.zkandroidlearning.zk.react

interface ObservableOnSubscribe<T> {

    fun subscribe(emitter: Emitter<T>)
}