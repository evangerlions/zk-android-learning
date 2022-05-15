package com.zhoukai.zkandroidlearning.zk.react

class ObservableCreate<T>(private val source : ObservableOnSubscribe<T>): Observable<T>() {

    override fun doOnActualSubscribe(observer: Observer<T>) {
        source.subscribe(EmitterCreate(observer))
    }

    class EmitterCreate<T>(private val observer: Observer<T>): Emitter<T> {

        override fun onNext(t: T) {
            observer.onNext(t)
        }

        override fun onError(t: Throwable) {
            observer.onError(t)
        }

    }
}