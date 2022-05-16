package com.zhoukai.zkandroidlearning.zk.react

import com.zhoukai.zkandroidlearning.zk.react.scheduler.Scheduler

class ObservableObservableOn<T>(private val scheduler: Scheduler, observable: Observable<T>) :
    ObservableWithUpStream<T, T>(observable) {

    override fun doOnActualSubscribe(observer: Observer<T>) {
        source.observe(ObserverOnObservable(scheduler, observer))
    }

    class ObserverOnObservable<T>(private val scheduler: Scheduler, downstream: Observer<T>) :
        BaseDecoratorObserver<T, T>(downstream) {

        override fun onNext(t: T) {
            scheduler.run { downstream.onNext(t) }
        }

        override fun onError(e: Throwable) {
            scheduler.run { downstream.onError(e) }
        }

        override fun onSubscribe() {
            scheduler.run { downstream.onSubscribe() }
        }
    }
}
