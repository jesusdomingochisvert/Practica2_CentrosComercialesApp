package com.example.practica2

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.practica2.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    // Binding

    private lateinit var binding: ActivityMainBinding

    // URL de las Imágenes

    val urlMN4 = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/1d/3e/d2/centro-comercial-mn4.jpg?w=1200&h=-1&s=1"
    val urlBonaire = "https://res.cloudinary.com/westfielddg/image/upload/westfield-media/es/centre/mobile-app/zcarfj4iu8dw4jwqidq6.jpg"
    val urlArena = "https://hiretail.es/wp-content/uploads/2021/05/Arena-Multiespacio-scaled.jpg"
    val urlAqua = "https://i.pinimg.com/736x/0e/40/68/0e4068abc1276c5ce68e3bb0cd8bdbc9.jpg"

    // Listas de las Tiendas

    val listaTiendasMN4 = mutableListOf<Tienda>()
    val listaTiendasBonaire = mutableListOf<Tienda>()
    val listaTiendasArena = mutableListOf<Tienda>()
    val listaTiendasAqua = mutableListOf<Tienda>()

    // Musica

    private var mediaPlayer: MediaPlayer? = null

    private var position: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        Log.i("lifeCycle", "onCreate")

        // Imagenes

        loadImages(urlMN4, urlBonaire, urlArena, urlAqua)

        // Meter Infomación en las Cards Views Principales

        putInfo()

        //Ir a la Activity Tienda

        goActivityMN4()
        goActivityBonaire()
        goActivityArena()
        goActivityAqua()

    }

    // Aqui se crea la música.

    override fun onStart() {

        super.onStart()

        Log.i("lifeCycle", "onStart")

        mediaPlayer = MediaPlayer.create(this, R.raw.sound)

        val extras = intent.extras

        if (extras != null) {

            position = extras.getInt("Sound")

        }

    }

    override fun onResume() {

        super.onResume()

        Log.i("lifeCycle", "onResume")

        mediaPlayer?.seekTo(position!!)

        mediaPlayer?.start()

    }

    override fun onPause() {

        val intent = Intent(this, TiendaActivity::class.java)

        super.onPause()

        Log.i("lifeCycle", "onPause")

        mediaPlayer?.pause()

        if (mediaPlayer != null) {

            position = mediaPlayer!!.currentPosition

            binding.mcv.setOnClickListener {

                intent.putExtra("Sound", position)

                startActivity(intent)

            }

            binding.mcv2.setOnClickListener {

                intent.putExtra("Sound", position)

                startActivity(intent)

            }

            binding.mcv3.setOnClickListener {

                intent.putExtra("Sound", position)

                startActivity(intent)

            }

            binding.mcv4.setOnClickListener {

                intent.putExtra("Sound", position)

                startActivity(intent)

            }

        }

    }

    override fun onStop() {

        super.onStop()

        Log.i("lifeCycle", "onStop")

        mediaPlayer?.stop()

        mediaPlayer?.release()

        mediaPlayer = null

    }

    override fun onRestart() {

        super.onRestart()

        Log.i("lifeCycle", "onRestart")

    }

    override fun onDestroy() {

        super.onDestroy()

        Log.i("lifeCycle", "onDestroy")

    }

    private fun loadImages(urlMN4: String, urlBonaire: String, urlArena: String, urlAqua: String) {

        // MN4

        Glide.with(this)
            .load(urlMN4)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(binding.iv)

        // Bonaire

        Glide.with(this)
            .load(urlBonaire)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(binding.iv2)

        // Arena

        Glide.with(this)
            .load(urlArena)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(binding.iv3)

        // Aqua

        Glide.with(this)
            .load(urlAqua)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(binding.iv4)

    }

    private fun putInfo() {

        //MN4

        val cc1 = CentroComercial("MN4", "Calle Alcalde José Puertes, 46910 Alfafar, Valencia", 4, listaTiendasMN4)

        binding.tvNombre.text = cc1.nombre
        binding.tvDescripcion.text = cc1.direccion
        binding.tvNTiendas.text = cc1.nTiendas.toString()

        //Bonaire

        val cc2 = CentroComercial("Bonaire", "Autovía del Este, Km. 345, 46960, Valencia", 4, listaTiendasBonaire)

        binding.tvNombre2.text = cc2.nombre
        binding.tvDescripcion2.text = cc2.direccion
        binding.tvNTiendas2.text = cc2.nTiendas.toString()

        //Arena

        val cc3 = CentroComercial("Arena", "C. de Santa Genoveva Torres, 21, 46019 València, Valencia", 4, listaTiendasArena)

        binding.tvNombre3.text = cc3.nombre
        binding.tvDescripcion3.text = cc3.direccion
        binding.tvNTiendas3.text = cc3.nTiendas.toString()

        //Aqua

        val cc4 = CentroComercial("Aqua", "Carrer de Menorca, 19, 46023 València, Valencia", 4, listaTiendasAqua)

        binding.tvNombre4.text = cc4.nombre
        binding.tvDescripcion4.text = cc4.direccion
        binding.tvNTiendas4.text = cc4.nTiendas.toString()

    }

    private fun goActivityMN4() {

        val intent = Intent(this, TiendaActivity::class.java)

        val t1MN4 =  Tienda("Pull&Bear", "Ropa, Cosmética, Bisuteria...")
        val t2MN4 =  Tienda("Bershka", "Ropa, Cosmética, Bisuteria...")
        val t3MN4 =  Tienda("Sprinter", "Ropa deportiva, Material deportivo, Mochilas...")
        val t4MN4 =  Tienda("Jack&Jones", "Ropa, Cosmética, Bisutería...")

        listaTiendasMN4.add(t1MN4)
        listaTiendasMN4.add(t2MN4)
        listaTiendasMN4.add(t3MN4)
        listaTiendasMN4.add(t4MN4)

        binding.mcv.setOnClickListener {

            if (mediaPlayer != null) {

                position = mediaPlayer!!.currentPosition

                intent.putExtra("Sound", position)

            }

            intent.putExtra("Datos", listaTiendasMN4.get(0).nombre)
            intent.putExtra("Datos2", listaTiendasMN4.get(1).nombre)
            intent.putExtra("Datos3", listaTiendasMN4.get(2).nombre)
            intent.putExtra("Datos4", listaTiendasMN4.get(3).nombre)

            intent.putExtra("Datos5", listaTiendasMN4.get(0).descripcion)
            intent.putExtra("Datos6", listaTiendasMN4.get(1).descripcion)
            intent.putExtra("Datos7", listaTiendasMN4.get(2).descripcion)
            intent.putExtra("Datos8", listaTiendasMN4.get(3).descripcion)

            startActivity(intent)

        }

    }

    private fun goActivityBonaire() {

        val intent = Intent(this, TiendaActivity::class.java)

        val t1Bonaire =  Tienda("Decathlon", "Ropa, Cosmetica, Bisutería...")
        val t2Bonaire =  Tienda("FNAC", "Tecnología, Libros, Música, Juguetes...")
        val t3Bonaire =  Tienda("Hollister", "Ropa, Mochilas...")
        val t4Bonaire =  Tienda("JD_Sports", "Zapatillas, Ropa deportiva, Productos limpieza zapatillas")

        listaTiendasBonaire.add(t1Bonaire)
        listaTiendasBonaire.add(t2Bonaire)
        listaTiendasBonaire.add(t3Bonaire)
        listaTiendasBonaire.add(t4Bonaire)

        binding.mcv2.setOnClickListener {

            if (mediaPlayer != null) {

                position = mediaPlayer!!.currentPosition

                intent.putExtra("Sound", position)

            }

            intent.putExtra("Datos", listaTiendasBonaire.get(0).nombre)
            intent.putExtra("Datos2", listaTiendasBonaire.get(1).nombre)
            intent.putExtra("Datos3", listaTiendasBonaire.get(2).nombre)
            intent.putExtra("Datos4", listaTiendasBonaire.get(3).nombre)

            intent.putExtra("Datos5", listaTiendasBonaire.get(0).descripcion)
            intent.putExtra("Datos6", listaTiendasBonaire.get(1).descripcion)
            intent.putExtra("Datos7", listaTiendasBonaire.get(2).descripcion)
            intent.putExtra("Datos8", listaTiendasBonaire.get(3).descripcion)

            startActivity(intent)

        }

    }

    private fun goActivityArena() {

        val intent = Intent(this, TiendaActivity::class.java)

        val t1Arena =  Tienda("Game", "Videojuegos, Consolas, Périfericos de ordenadores...")
        val t2Arena =  Tienda("Hawkers", "Gafas de Sol, Accesorios gafas de sol...")
        val t3Arena =  Tienda("Orange", "Móviles, Cargadores de móviles, Tarifas móviles...")
        val t4Arena =  Tienda("Zara", "Ropa, Cosmética, Bisutería...")

        listaTiendasArena.add(t1Arena)
        listaTiendasArena.add(t2Arena)
        listaTiendasArena.add(t3Arena)
        listaTiendasArena.add(t4Arena)

        binding.mcv3.setOnClickListener {

            if (mediaPlayer != null) {

                position = mediaPlayer!!.currentPosition

                intent.putExtra("Sound", position)

            }

            intent.putExtra("Datos", listaTiendasArena.get(0).nombre)
            intent.putExtra("Datos2", listaTiendasArena.get(1).nombre)
            intent.putExtra("Datos3", listaTiendasArena.get(2).nombre)
            intent.putExtra("Datos4", listaTiendasArena.get(3).nombre)

            intent.putExtra("Datos5", listaTiendasArena.get(0).descripcion)
            intent.putExtra("Datos6", listaTiendasArena.get(1).descripcion)
            intent.putExtra("Datos7", listaTiendasArena.get(2).descripcion)
            intent.putExtra("Datos8", listaTiendasArena.get(3).descripcion)

            startActivity(intent)

        }

    }

    private fun goActivityAqua() {

        val intent = Intent(this, TiendaActivity::class.java)

        val t1Aqua =  Tienda("Guess", "Ropa, Cosmética, Bisutería...")
        val t2Aqua =  Tienda("Massimo_Dutti", "Ropa, Cosmética, Bisutería...")
        val t3Aqua =  Tienda("Media_Markt", "Tecnología, Música, Libros, Videojuegos...")
        val t4Aqua =  Tienda("NesPresso", "Granos de café, Cápsulas de café, Máquinas de cafes...")

        listaTiendasAqua.add(t1Aqua)
        listaTiendasAqua.add(t2Aqua)
        listaTiendasAqua.add(t3Aqua)
        listaTiendasAqua.add(t4Aqua)

        binding.mcv4.setOnClickListener {

            if (mediaPlayer != null) {

                position = mediaPlayer!!.currentPosition

                intent.putExtra("Sound", position)

            }

            intent.putExtra("Datos", listaTiendasAqua.get(0).nombre)
            intent.putExtra("Datos2", listaTiendasAqua.get(1).nombre)
            intent.putExtra("Datos3", listaTiendasAqua.get(2).nombre)
            intent.putExtra("Datos4", listaTiendasAqua.get(3).nombre)

            intent.putExtra("Datos5", listaTiendasAqua.get(0).descripcion)
            intent.putExtra("Datos6", listaTiendasAqua.get(1).descripcion)
            intent.putExtra("Datos7", listaTiendasAqua.get(2).descripcion)
            intent.putExtra("Datos8", listaTiendasAqua.get(3).descripcion)

            startActivity(intent)

        }

    }

}