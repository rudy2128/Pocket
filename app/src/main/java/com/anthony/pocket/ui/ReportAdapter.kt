package com.anthony.pocket.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.anthony.pocket.R
import com.anthony.pocket.entity.Report
import com.anthony.pocket.helper.RupiahHelper

class ReportAdapter(private val listReport:List<Report>,private var onItemClicked: MainActivity):
    RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main, parent, false)
        return ReportViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {

        val rep = listReport[position]
        val index = listReport.indexOf(rep)
        holder.tvNumber.text = index.plus(1).toString()+"."
        holder.tvDate.text = rep.date
        holder.tvDesc.text = rep.description
        val rp = rep.nominal
        if (rp>0){
         holder.tvNominal.text = RupiahHelper.formatRupiah(rep.nominal.toDouble())
            holder.tvNominal.setTextColor(Color.BLUE)
            holder.tvDesc.setTextColor(Color.BLUE)
            holder.tvDate.setTextColor(Color.BLUE)
        }else{
         holder.tvNominal.text = RupiahHelper.formatRupiah(rep.nominal.toDouble())

        }

        holder.itemView.setOnClickListener {
            val id = rep.id
            val contex = holder.itemView.context
            showDialog(contex,id)
        }
    }

    private fun showDialog(context: Context, id: Int) {
        val dialogMessage: String = context.getString(R.string.message_logout)
        val dialogTitle: String = context.getString(R.string.delete)
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.setTitle(dialogTitle)
        alertDialogBuilder
            .setMessage(dialogMessage)
            .setCancelable(false)
            .setPositiveButton(context.getString(R.string.yes)) { _: DialogInterface?, _: Int ->
                onItemClicked.passResultCallback(id)
            }
            .setNegativeButton(
                context.getString(R.string.no)
            ) { dialog: DialogInterface, _: Int -> dialog.cancel() }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    override fun getItemCount(): Int = listReport.size


    class ReportViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNumber:TextView = view.findViewById(R.id.tv_number)
        val tvDate:TextView = view.findViewById(R.id.tv_date)
        val tvDesc:TextView = view.findViewById(R.id.tv_desc)
        val tvNominal:TextView = view.findViewById(R.id.tv_count)

    }
}

