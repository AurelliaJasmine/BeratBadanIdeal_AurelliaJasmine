package com.example.beratbadanideal_aurelliajasmine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var nama   : EditText
    private lateinit var tb     : EditText
    private lateinit var jkLK   : RadioButton
    private lateinit var jkPR   : RadioButton
    private lateinit var hasil  : TextView
    private lateinit var hitung : Button
    private lateinit var reset  : Button
    private var tbdn : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nama   = findViewById(R.id.txtNama)
        tb     = findViewById(R.id.txtTinggiBadan)
        jkLK   = findViewById(R.id.rbLK)
        jkPR   = findViewById(R.id.rbPR)
        hasil  = findViewById(R.id.txtHasil)
        hitung = findViewById(R.id.btnHitung)
        reset  = findViewById(R.id.btnReset)

        hitung.setOnClickListener {
            var tinggi = tb.text.toString().toInt()
            var nama   = nama.text.toString()

            if(jkLK.isChecked) {
                tbdn = (tinggi-100)-((tinggi-100)* 10/100)
                hasil.setText("Nama : $nama  Berat badan ideal : " + tbdn.toString() + "kg")
            } else if (jkPR.isChecked) {
                tbdn = (tinggi-100)-((tinggi-100)* 15/100)
                hasil.setText("Nama : $nama  Berat badan ideal : " + tbdn.toString() + "kg")
            }else {
                hasil.setText("Pilih jenis kelamin terlebih dahulu")
            }
        }

        reset.setOnClickListener{ reset()}
    }
    private fun reset() {
        hasil.text = 0.toString()
        nama.text.clear()
        tb.text.clear()
    }
}
