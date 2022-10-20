package com.example.practica2

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class TiendaActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    private var sound: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tienda)

        Log.i("lifeCycle", "onCreate2")

        mostrarListadoTiendasMN4()
        mostrarListadoTiendasBonaire()
        mostrarListadoTiendasArena()
        mostrarListadoTiendasAqua()

        val extras = intent.extras

        if (extras != null) {

            sound = extras.getInt("Sound")

            mediaPlayer?.seekTo(sound!!)

        }

    }

    override fun onStart() {

        super.onStart()

        Log.i("lifeCycle", "onStart2")

        mediaPlayer = MediaPlayer.create(this, R.raw.sound)

    }

    override fun onResume() {

        super.onResume()

        Log.i("lifeCycle", "onResume2")

        mediaPlayer?.seekTo(sound!!)

        mediaPlayer?.start()

    }

    override fun onPause() {

        super.onPause()

        Log.i("lifeCycle", "onPause2")

        mediaPlayer?.pause()

        if (mediaPlayer != null) {

            sound = mediaPlayer!!.currentPosition

        }

    }

    override fun onBackPressed() {

        super.onBackPressed()

        val returnIntent = Intent()

        returnIntent.putExtra("Sound", sound)

        setResult(RESULT_OK, returnIntent)

        finish()

    }

    override fun onStop() {

        super.onStop()

        Log.i("lifeCycle", "onStop2")

        mediaPlayer?.stop()

        mediaPlayer?.release()

        mediaPlayer = null

    }

    override fun onRestart() {

        super.onRestart()

        Log.i("lifeCycle", "onRestart2")

    }

    override fun onDestroy() {

        super.onDestroy()

        Log.i("lifeCycle", "onDestroy2")

    }

    private fun mostrarListadoTiendasMN4() {

        val bundle = intent.extras

        val datos = bundle?.getString("Datos")
        val datos2 = bundle?.getString("Datos2")
        val datos3 = bundle?.getString("Datos3")
        val datos4 = bundle?.getString("Datos4")
        val datos5 = bundle?.getString("Datos5")
        val datos6 = bundle?.getString("Datos6")
        val datos7 = bundle?.getString("Datos7")
        val datos8 = bundle?.getString("Datos8")

        val nombre = findViewById<TextView>(R.id.tvTitle)
        val nombre2 = findViewById<TextView>(R.id.tvTitle2)
        val nombre3 = findViewById<TextView>(R.id.tvTitle3)
        val nombre4 = findViewById<TextView>(R.id.tvTitle4)

        val listado = findViewById<TextView>(R.id.tvDescripcion)
        val listado2 = findViewById<TextView>(R.id.tvDescripcion2)
        val listado3 = findViewById<TextView>(R.id.tvDescripcion3)
        val listado4 = findViewById<TextView>(R.id.tvDescripcion4)

        nombre.text = datos.toString()
        nombre2.text = datos2.toString()
        nombre3.text = datos3.toString()
        nombre4.text = datos4.toString()

        listado.text = datos5.toString()
        listado2.text = datos6.toString()
        listado3.text = datos7.toString()
        listado4.text = datos8.toString()

    }

    private fun mostrarListadoTiendasBonaire() {

        val bundle = intent.extras

        val datos = bundle?.getString("Datos")
        val datos2 = bundle?.getString("Datos2")
        val datos3 = bundle?.getString("Datos3")
        val datos4 = bundle?.getString("Datos4")
        val datos5 = bundle?.getString("Datos5")
        val datos6 = bundle?.getString("Datos6")
        val datos7 = bundle?.getString("Datos7")
        val datos8 = bundle?.getString("Datos8")

        val nombre = findViewById<TextView>(R.id.tvTitle)
        val nombre2 = findViewById<TextView>(R.id.tvTitle2)
        val nombre3 = findViewById<TextView>(R.id.tvTitle3)
        val nombre4 = findViewById<TextView>(R.id.tvTitle4)

        val listado = findViewById<TextView>(R.id.tvDescripcion)
        val listado2 = findViewById<TextView>(R.id.tvDescripcion2)
        val listado3 = findViewById<TextView>(R.id.tvDescripcion3)
        val listado4 = findViewById<TextView>(R.id.tvDescripcion4)

        nombre.text = datos.toString()
        nombre2.text = datos2.toString()
        nombre3.text = datos3.toString()
        nombre4.text = datos4.toString()

        listado.text = datos5.toString()
        listado2.text = datos6.toString()
        listado3.text = datos7.toString()
        listado4.text = datos8.toString()

    }

    private fun mostrarListadoTiendasArena() {

        val bundle = intent.extras

        val datos = bundle?.getString("Datos")
        val datos2 = bundle?.getString("Datos2")
        val datos3 = bundle?.getString("Datos3")
        val datos4 = bundle?.getString("Datos4")
        val datos5 = bundle?.getString("Datos5")
        val datos6 = bundle?.getString("Datos6")
        val datos7 = bundle?.getString("Datos7")
        val datos8 = bundle?.getString("Datos8")

        val nombre = findViewById<TextView>(R.id.tvTitle)
        val nombre2 = findViewById<TextView>(R.id.tvTitle2)
        val nombre3 = findViewById<TextView>(R.id.tvTitle3)
        val nombre4 = findViewById<TextView>(R.id.tvTitle4)

        val listado = findViewById<TextView>(R.id.tvDescripcion)
        val listado2 = findViewById<TextView>(R.id.tvDescripcion2)
        val listado3 = findViewById<TextView>(R.id.tvDescripcion3)
        val listado4 = findViewById<TextView>(R.id.tvDescripcion4)

        nombre.text = datos.toString()
        nombre2.text = datos2.toString()
        nombre3.text = datos3.toString()
        nombre4.text = datos4.toString()

        listado.text = datos5.toString()
        listado2.text = datos6.toString()
        listado3.text = datos7.toString()
        listado4.text = datos8.toString()

    }

    private fun mostrarListadoTiendasAqua() {

        val bundle = intent.extras

        val datos = bundle?.getString("Datos")
        val datos2 = bundle?.getString("Datos2")
        val datos3 = bundle?.getString("Datos3")
        val datos4 = bundle?.getString("Datos4")
        val datos5 = bundle?.getString("Datos5")
        val datos6 = bundle?.getString("Datos6")
        val datos7 = bundle?.getString("Datos7")
        val datos8 = bundle?.getString("Datos8")

        val nombre = findViewById<TextView>(R.id.tvTitle)
        val nombre2 = findViewById<TextView>(R.id.tvTitle2)
        val nombre3 = findViewById<TextView>(R.id.tvTitle3)
        val nombre4 = findViewById<TextView>(R.id.tvTitle4)

        val listado = findViewById<TextView>(R.id.tvDescripcion)
        val listado2 = findViewById<TextView>(R.id.tvDescripcion2)
        val listado3 = findViewById<TextView>(R.id.tvDescripcion3)
        val listado4 = findViewById<TextView>(R.id.tvDescripcion4)

        nombre.text = datos.toString()
        nombre2.text = datos2.toString()
        nombre3.text = datos3.toString()
        nombre4.text = datos4.toString()

        listado.text = datos5.toString()
        listado2.text = datos6.toString()
        listado3.text = datos7.toString()
        listado4.text = datos8.toString()

    }

}