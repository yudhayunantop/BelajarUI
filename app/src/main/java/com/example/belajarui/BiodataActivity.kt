package com.example.belajarui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.belajarui.databinding.ActivityMainBinding

class BiodataActivity : AppCompatActivity() {

    var radioGroup: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biodata)

    }

    // Get the selected radio button text using radio button on click listener
    fun radio_button_click(view: View){
        radioGroup = findViewById(R.id.radio_group)
        // Get the clicked radio button instance
        val radio: RadioButton = findViewById(radioGroup!!.checkedRadioButtonId)
        // Check which radio button was clicked

        when (radio.getId()) {
            R.id.data_diri ->
//                Toast.makeText(applicationContext,"On click : ${radio.text}", Toast.LENGTH_SHORT).show()
                replacementFragment(DataDiriFragment())

            R.id.pendidikan ->
//                Toast.makeText(applicationContext,"On click : ${radio.text}",
//                    Toast.LENGTH_SHORT).show()
                replacementFragment(PendidikanFragment())
        }
    }

    private fun replacementFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()

    }
}