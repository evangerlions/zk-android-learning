package com.zhoukai.zkandroidlearning.zk.react

abstract class BaseDecoratorObserver<T, R>(protected val downstream: Observer<R>) : Observer<T>