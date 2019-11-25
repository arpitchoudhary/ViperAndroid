package com.toi.vipersample.presenter

import com.toi.vipersample.Gateway.NetworkApi
import com.toi.vipersample.entity.GoogleData
import io.reactivex.Observable

class MainInteractorImpl : MainInteractor{

    lateinit var networkApi: NetworkApi

    override fun fetchData(): Observable<GoogleData> {
        networkApi = NetworkApi()
        return networkApi.getMockedData()
    }
}