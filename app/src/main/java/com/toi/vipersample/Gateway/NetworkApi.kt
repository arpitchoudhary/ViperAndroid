package com.toi.vipersample.Gateway

import com.toi.vipersample.entity.GoogleData
import com.toi.vipersample.util.NetworkConnection
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class NetworkApi {

    // mock api request
    fun getMockedData(): Observable<GoogleData> {
        if (NetworkConnection.haveNetworkConnection()) {
            return Observable.just(GoogleData(true, "THIS IS FROM THE INTERNET"))
                .delay(3, TimeUnit.SECONDS)
        } else {
            return Observable.just(GoogleData(false, "CheckInternetConnection"))
                .delay(1, TimeUnit.SECONDS)
        }

    }

}