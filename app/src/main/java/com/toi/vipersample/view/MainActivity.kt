package com.toi.vipersample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.toi.vipersample.R
import com.toi.vipersample.entity.GoogleData
import com.toi.vipersample.presenter.MainPresenter
import com.toi.vipersample.presenter.MainPresenterImpl
import com.toi.vipersample.view.contract.ViewContract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewContract {

    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter = MainPresenterImpl()

        mainPresenter.takeView(this)

        fetchButton.setOnClickListener {
            mainPresenter.fetchData()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.destroyView()
    }

    override fun progress(show: Boolean) {
        if (show)
            progress.visibility = View.VISIBLE
        else
            progress.visibility = View.GONE
    }

    override fun buttonState(show: Boolean) {
        if (show)
            fetchButton.visibility = View.VISIBLE
        else
            fetchButton.visibility = View.GONE
    }

    override fun setData(googleData: GoogleData) {
        result.visibility = View.VISIBLE
        result.text = googleData.response
    }
}
