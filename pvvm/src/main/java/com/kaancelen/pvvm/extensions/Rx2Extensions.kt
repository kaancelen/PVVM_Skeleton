package com.kaancelen.pvvm.extensions

import com.kaancelen.pvvm.network.BaseThrowable
import com.kaancelen.pvvm.network.NetworkErrorParser
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import nurisezgin.com.rxtrash.RxTrash
import java.util.concurrent.TimeUnit

fun <T> Observable<T>.register(
    tag: String,
    onSuccess: (response: T) -> Unit,
    onError: (error: BaseThrowable) -> Unit
) {
    val disposable = this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            {onSuccess(it)},
            {onError(NetworkErrorParser.from(it))}
        )

    RxTrash.getInstance().add(tag, disposable)
}

fun <T> Observable<T>.register(
    tag: String,
    timeout: Long,
    onSuccess: (response: T) -> Unit,
    onError: (error: BaseThrowable) -> Unit
) {
    val disposable = this.timeout(timeout, TimeUnit.MILLISECONDS)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            {onSuccess(it)},
            {onError(NetworkErrorParser.from(it))}
        )

    RxTrash.getInstance().add(tag, disposable)
}