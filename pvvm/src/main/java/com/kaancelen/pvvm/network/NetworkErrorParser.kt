package com.kaancelen.pvvm.network

object NetworkErrorParser {

    fun from(throwable: Throwable) : BaseThrowable {
        return BaseThrowable(throwable)
    }
}