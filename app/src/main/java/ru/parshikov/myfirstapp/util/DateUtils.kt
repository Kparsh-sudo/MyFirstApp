package ru.parshikov.myfirstapp.utils

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date

object DateUtils {
    private val format = SimpleDateFormat("d MMM в HH:mm", Locale("ru"))

    fun formatDate(date: Date): String {
        return format.format(date)
    }

    fun currentDateTime(): String {
        return formatDate(Date())
    }
}
