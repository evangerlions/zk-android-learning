package com.zhoukai.zkandroidlearning.zk.react

abstract class ObservableWithUpStream<T, R>(protected val source: ObservableSource<T>): Observable<R>()