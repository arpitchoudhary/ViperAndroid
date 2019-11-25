package com.toi.vipersample.presenter

import com.toi.vipersample.entity.GoogleData
import io.reactivex.Observable

interface MainInteractor {
    fun fetchData() : Observable<GoogleData>
}