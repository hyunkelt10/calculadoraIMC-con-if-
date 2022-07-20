package com.example.calculadoraimc

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.calculadoraimc.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    var peso = 75
    var altura = 0
    var imc = 0.0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int,
                fromUser: Boolean
            ) {
                altura = progress / 100
                b.tvSeekbar.text = seek.progress.toString().plus("/200")
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                //write custom code for progres is starting
//                Toast.makeText(this@MainActivity, "acabas de pulsar el boton", Toast.LENGTH_SHORT)
//                    .show()
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
               snackbar()
            }
        })


        b.seekBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int,
                fromUser: Boolean
            ) {
                peso = progress
                b.tvSeekbar2.text = seek.progress.toString().plus("/150")
            }

            override fun onStartTrackingTouch(seek: SeekBar) {

            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                //write custom code for progres is starting
//                Toast.makeText(this@MainActivity, "acabas de soltar el boton", Toast.LENGTH_SHORT).show()
                snackbar()

            }
        })
    }

    fun snackbar () {
        val metros = (b.seekBar.progress / 100.0)
        val metroscuadrados = metros * metros
        imc = (b.seekBar2.progress.toDouble() / metroscuadrados.toDouble())
        b.tvIMC.text = imc.toString()

        if (imc<16.0) {

            val s = Snackbar.make(b.root,"Delgadez severa", Snackbar.LENGTH_SHORT)
                .setAction("Ver Tabla") {
                seleccion(b.root)
                }
                .show()
        } else if (imc>16.0 && imc< 17.0) {
            val s = Snackbar.make(b.root, "Delgadez moderada", Snackbar.LENGTH_SHORT)
                .setAction("Ver Tabla") {
                    seleccion(b.root)}

            s.setBackgroundTint(ContextCompat.getColor(this@MainActivity,R.color.moderada))

            s.show()

        } else if (imc>17.0 && imc< 18.5) {
            val s = Snackbar.make(b.root, "Delgadez leve", Snackbar.LENGTH_SHORT)
                .setAction("Ver Tabla") {
                    seleccion(b.root)}

            s.setBackgroundTint(ContextCompat.getColor(this@MainActivity,R.color.leve))
            s.show()

        } else if (imc>18.5 && imc< 25.0) {
            val s = Snackbar.make(b.root, "peso normal", Snackbar.LENGTH_SHORT)
                .setAction("Ver Tabla") {
                    seleccion(b.root)}

            s.setBackgroundTint(ContextCompat.getColor(this@MainActivity, R.color.normal))
            s.show()

        } else if (imc>25.0 && imc< 30.0) {
            val s = Snackbar.make(b.root, "preobesidad", Snackbar.LENGTH_SHORT)
                .setAction("Ver Tabla") {
                    seleccion(b.root)}

            s.setBackgroundTint(ContextCompat.getColor(this@MainActivity, R.color.Preobesidad))
            s.show()

        } else if (imc>30.0 && imc< 35.0) {
            val s = Snackbar.make(b.root, "obesidad leve", Snackbar.LENGTH_SHORT)
                .setAction("Ver Tabla") {
                    seleccion(b.root)}

            s.setBackgroundTint(ContextCompat.getColor(this@MainActivity, R.color.obesidadLeve))
            s.show()

        } else if (imc>35.0 && imc< 40.0) {
            val s = Snackbar.make(b.root, "obesidad media", Snackbar.LENGTH_SHORT)
                .setAction("Ver Tabla") {
                    seleccion(b.root)}

            s.setBackgroundTint(ContextCompat.getColor(this@MainActivity, R.color.obesidadMedia))
            s.show()

        } else if (imc>40.0) {
            val s = Snackbar.make(b.root, "obesidad morbida", Snackbar.LENGTH_SHORT)
                .setAction("Ver Tabla") {
                    seleccion(b.root)}

            s.setBackgroundTint(ContextCompat.getColor(this@MainActivity, R.color.obesidadMorbida))
            s.show()

        }
    }


    fun seleccion (view: View) {
        val inflater = this.layoutInflater
        val custom_layout = inflater.inflate(R.layout.layout_dialog, null)

        AlertDialog.Builder(this)
            .setView(custom_layout)
            .setPositiveButton(R.string.aceptar, null)

            .show()
    }


//    fun imcfuncion () {
//        val metros = (b.seekBar.progress / 100.0)
//        val metroscuadrados = metros * metros
//        imc = (b.seekBar2.progress.toDouble() / metroscuadrados.toDouble())
//        b.tvIMC.text = imc.toString()
//
//        when (imc) {
//              in 0..16 ->   Snackbar.make(b.root,"Delgadez severa", Snackbar.LENGTH_SHORT)
//
//        }
//
//
//
//    }
}