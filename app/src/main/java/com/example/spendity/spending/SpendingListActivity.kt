package com.example.spendity.spending

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.spendity.R
import com.example.spendity.ViewModelFactory
import com.example.spendity.data.SpendingResponse
import com.example.spendity.data.SpendingRoot
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.content_spending_list.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class SpendingListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewmodelFactory: ViewModelFactory

    @Inject
    lateinit var viewmodel: SpendingListViewModel

    val adapter: SpendingListAdapter = SpendingListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spending_list)
        viewmodel = ViewModelProviders.of(this, viewmodelFactory).get(SpendingListViewModel::class.java)
        val layoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        spending_list_recycler.layoutManager = layoutManager
        spending_list_recycler.adapter = adapter
        viewmodel.loadSpendingItems()
        viewmodel.liveSpendings.observe(this, Observer {
            handleResponse(it)
        })
    }

    private fun handleResponse(response: SpendingResponse?) {
        when (response?.status) {
            SpendingStatus.SUCCESS -> showSpendingList(response.spendingDataZipped?.spendingListResponse)
            SpendingStatus.ERROR -> showErrorMessage()
        }
    }

    private fun showErrorMessage() {
        toast(getString(R.string.error_message))
    }

    private fun showSpendingList(spendingRoot: SpendingRoot?) {
        spendingRoot?.data?.let {
            adapter.listSpendingData = it
            adapter.notifyDataSetChanged()
        }
    }
}
