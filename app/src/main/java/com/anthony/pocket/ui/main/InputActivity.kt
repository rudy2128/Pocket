package com.anthony.pocket.ui.main

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.anthony.pocket.R
import com.anthony.pocket.entity.Report
import com.anthony.pocket.model.TrxViewModel
import com.anthony.pocket.model.ViewModelFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class InputActivity : AppCompatActivity() {
    private lateinit var edtDesc:EditText
    private lateinit var edtNom:EditText
    private lateinit var btnSave:Button
    private lateinit var btnOut:Button
    private lateinit var btnBack:ImageButton
    private lateinit var trxViewModel: TrxViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        edtDesc = findViewById(R.id.edt_desc)
        edtNom = findViewById(R.id.edt_nominal)
        btnSave = findViewById(R.id.btn_save)
        btnOut = findViewById(R.id.btn_out)
        btnBack = findViewById(R.id.btn_back)

        btnBack.setOnClickListener {
            finish()
        }



        trxViewModel = obtainViewModel(this@InputActivity)

        btnOut.setOnClickListener {
            val description = edtDesc.text.toString()
            val nominal:Int = edtNom.text.toString().toInt()

            if (description.isEmpty()){
                edtDesc.error = getString(R.string.empty)
            }else if (nominal == 0){
                edtNom.error = getString(R.string.empty)
            }else{
                val date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd" ))
                val report = Report(0,date,description,-nominal)
                trxViewModel.insert(report)
                edtDesc.text = null
                edtNom.text = null
                Toast.makeText(applicationContext,"Data saved!",Toast.LENGTH_SHORT).show()

            }



        }
        btnSave.setOnClickListener {
            val description = edtDesc.text.toString()
            val nominal:Int = edtNom.text.toString().toInt()

            if (description.isEmpty()){
                edtDesc.error = getString(R.string.empty)
            }else if (nominal == 0){
                edtNom.error = getString(R.string.empty)
            }else{
                val date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd" ))
                val report = Report(0,date,description,nominal)
                trxViewModel.insert(report)
                edtDesc.text = null
                edtNom.text = null
                Toast.makeText(applicationContext,"Data saved!",Toast.LENGTH_SHORT).show()

            }

        }
    }
    private fun obtainViewModel(activity: AppCompatActivity): TrxViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[TrxViewModel::class.java]
    }

    fun passResultCallback(i: Int) {
        TODO("Not yet implemented")
    }
}