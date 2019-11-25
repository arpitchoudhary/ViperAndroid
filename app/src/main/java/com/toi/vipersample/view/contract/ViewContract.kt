package com.toi.vipersample.view.contract

import com.toi.vipersample.entity.GoogleData

interface ViewContract {
    fun progress(show: Boolean)
    fun buttonState(show: Boolean)
    fun setData(googleData: GoogleData)
}