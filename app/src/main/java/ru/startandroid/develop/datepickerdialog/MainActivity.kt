package ru.startandroid.develop.datepickerdialog

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.text.format.DateUtils
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar


class MainActivity : AppCompatActivity() {
    var currentDateTime: TextView? = null
    var dateAndTime = Calendar.getInstance()
    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        setContentView(R.layout.activity_main)
        currentDateTime = findViewById(R.id.currentDateTime)
        setInitialDateTime()
    }
    
    fun setDate(v: View?) {
        DatePickerDialog(this, d,
            dateAndTime.get(Calendar.YEAR),
            dateAndTime.get(Calendar.MONTH),
            dateAndTime.get(Calendar.DAY_OF_MONTH))
            .show()
    }

    fun setInitialDateTime() {
        currentDateTime!!.text = DateUtils.formatDateTime(this,
            dateAndTime.getTimeInMillis(),
            DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_YEAR
                    or DateUtils.FORMAT_SHOW_TIME)
    }

    var d =
        OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            dateAndTime.set(Calendar.YEAR, year)
            dateAndTime.set(Calendar.MONTH, monthOfYear)
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            setInitialDateTime()
        }
}