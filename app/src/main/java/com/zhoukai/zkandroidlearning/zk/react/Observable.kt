package com.zhoukai.zkandroidlearning.zk.react

interface ObservableSource<T> {

    fun observe(observer: Observer<T>)
}

abstract class Observable<T> : ObservableSource<T> {

    override fun observe(observer: Observer<T>) {
        observer.onSubscribe()
        doOnActualSubscribe(observer)
    }

    protected abstract fun doOnActualSubscribe(observer: Observer<T>)

    companion object {

        fun <T> create(observableOnSubscribe: ObservableOnSubscribe<T>): Observable<T> {
            return ObservableCreate(observableOnSubscribe)
        }

        fun <T, R> Observable<T>.map(mapper: (T) -> R): Observable<R> {
            return ObservableMap(mapper, this)
        }
    }
}