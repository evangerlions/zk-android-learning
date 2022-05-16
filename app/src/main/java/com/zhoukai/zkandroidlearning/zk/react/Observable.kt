package com.zhoukai.zkandroidlearning.zk.react

import com.zhoukai.zkandroidlearning.zk.react.scheduler.Scheduler

interface ObservableSource<T> {

    fun observe(observer: Observer<T>)
}

abstract class Observable<T> : ObservableSource<T> {

    override fun observe(observer: Observer<T>) {
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

        fun <T> Observable<T>.observerOn(scheduler: Scheduler): Observable<T> {
            return ObservableObserveOn(scheduler, this)
        }

        fun <T> Observable<T>.subscribeOn(scheduler: Scheduler): Observable<T> {
            return ObservableSubscribeOn(scheduler, this)
        }
    }
}