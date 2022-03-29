package com.example.belajarui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity(),
    DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    private lateinit var buttonDatetime: Button
    private lateinit var buttonBiodata: Button
    private lateinit var buttonPrint: Button
    private lateinit var textTime: TextView
    private lateinit var textSysdate: TextView

    var day = 0
    var month = 0
    var year = 0
    var hour = 0
    var minute = 0

    var savedDay = 0
    var savedMonth = 0
    var savedYear = 0
    var savedHour = 0
    var savedMinute = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonDatetime=findViewById(R.id.btn_timePicker)
        buttonBiodata=findViewById(R.id.btn_biodata)
        buttonPrint=findViewById(R.id.btn_print)
        textTime = findViewById(R.id.tv_textTime)
        textSysdate = findViewById(R.id.tv_sysdate)

        pickDate()

        buttonBiodata.setOnClickListener{
            startActivity(Intent(this, BiodataActivity::class.java))
        }

        buttonPrint.setOnClickListener {
            startActivity(Intent(this, CustomPrintActivity::class.java))
        }

    }

    private fun getDateTimeCalendar(){
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR)
        minute = cal.get(Calendar.MINUTE)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun pickDate(){
        buttonDatetime.setOnClickListener{
            getDateTimeCalendar()

            DatePickerDialog(this, this, year, month, day).show()
            TimeSysdate()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year

        getDateTimeCalendar()
        TimePickerDialog(this, this, hour, minute, true).show()

    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour = hourOfDay
        savedMinute = minute

        textTime.text ="$savedDay-$savedMonth-$savedYear\n Hour: $savedHour Minute: $savedMinute"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun TimeSysdate(){
        val timeNow = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss.SSS")
        val formatted = timeNow.format(formatter)

        textSysdate.text = formatted.toString()
//        Log.e("DateTime", formatted.toString())
    }


}