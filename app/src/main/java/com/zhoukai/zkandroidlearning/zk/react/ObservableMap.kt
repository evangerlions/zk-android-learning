package com.zhoukai.zkandroidlearning.zk.react

class ObservableMap<T, R>(private val mapper: (T) -> R, source: ObservableSource<T>) :
    ObservableWithUpStream<T, R>(source) {

    override fun doOnActualSubscribe(observer: Observer<R>) {
        source.observe(ObserverMap(mapper, observer))
    }

    class ObserverMap<T, R>(private val mapper: (T) -> R, downstream: Observer<R>) : BaseDecoratorObserver<T, R>(downstream) {

        override fun onNext(t: T) {
            val r = mapper(t)
            downstream.onNext(r)
        }

        override fun onError(e: Throwable) {
            downstream.onError(e)
        }

        override fun onSubscribe() {
            downstream.onSubscribe()
        }
    }
}