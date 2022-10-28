package com.anthony.pocket.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anthony.pocket.R
import com.anthony.pocket.helper.RupiahHelper
import com.anthony.pocket.model.TrxViewModel
import com.anthony.pocket.model.ViewModelFactory
import com.anthony.pocket.ui.main.InputActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnAdd:ImageButton
    private lateinit var tvTot:TextView
    private lateinit var trxViewModel: TrxViewModel
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd = findViewById(R.id.btn_add)
        tvTot = findViewById(R.id.tv_total)

        btnAdd.setOnClickListener {
            val i = Intent(applicationContext,InputActivity::class.java)
            startActivity(i)

        }
        trxViewModel = obtainViewModel(this@MainActivity)
        trxViewModel.allTrx.observe(this@MainActivity){
            val listReport = it
            val recyclerView = findViewById<RecyclerView>(R.id.rvMain)
            val adapter = ReportAdapter(listReport,this)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        }

        trxViewModel.sum.observe(this@MainActivity){
            if (it == null){
                tvTot.text = "Rp 0,00"
            }else{
                if (it>0){
                    tvTot.text = RupiahHelper.formatRupiah(it.toDouble())
                    tvTot.setTextColor(Color.BLUE)

                }else{
                    tvTot.text = RupiahHelper.formatRupiah(it.toDouble())
                    tvTot.setTextColor(Color.RED)

                }


            }
        }

    }

    fun passResultCallback(id: Int) {
       if (id >0){
           trxViewModel.deleteTrx(id)
           Toast.makeText(applicationContext,"Deleted success",Toast.LENGTH_SHORT).show()
       }
    }
    private fun obtainViewModel(activity: AppCompatActivity): TrxViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[TrxViewModel::class.java]
    }


}