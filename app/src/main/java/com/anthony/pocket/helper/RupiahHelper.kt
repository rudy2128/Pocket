package com.anthony.pocket.helper

import java.text.NumberFormat
import java.util.*

object RupiahHelper {
    fun formatRupiah(number: Double?): String? {
        val localeID = Locale("in", "ID")
        val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
        return formatRupiah.format(number)
    }
}