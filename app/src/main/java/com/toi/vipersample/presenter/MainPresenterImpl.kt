package com.toi.vipersample.presenter

import com.toi.vipersample.entity.GoogleData
import com.toi.vipersample.view.contract.ViewContract
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainPresenterImpl : MainPresenter {

    lateinit var mainInteractor: MainInteractor
    var viewContract: ViewContract? = null

    override fun fetchData() {

        mainInteractor = MainInteractorImpl()

        viewContract?.buttonState(false)
        viewContract?.progress(true)

        mainInteractor.fetchData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<GoogleData> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: GoogleData) {
                    viewContract?.progress(false)
                    viewContract?.setData(t)
                }

                override fun onError(e: Throwable) {
                    viewContract?.progress(false)
                    viewContract?.buttonState(true)
                }

            })
    }


    override fun takeView(view: ViewContract) {
        viewContract = view
    }

    override fun destroyView() {
        viewContract = null
    }
}