package com.toi.vipersample.presenter

import com.toi.vipersample.view.contract.ViewContract

interface MainPresenter {
    fun fetchData()
    fun takeView(viewContract: ViewContract)
    fun destroyView()
}