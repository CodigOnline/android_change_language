package es.codigonline.proyecto.language

import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.codigonline.proyecto.language.App.Companion.setAppLocale
import es.codigonline.proyecto.language.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        binding.english.setOnClickListener {
            App.changeLanguage("en", this, MainActivity::class.java)
        }
        binding.spanish.setOnClickListener {
            App.changeLanguage("es", this, MainActivity::class.java)
        }

    }

    override fun attachBaseContext(newBase: Context?) {
        App.preferences().getString("locale", null)?.let {
            super.attachBaseContext(ContextWrapper(newBase?.setAppLocale(it)))
            return
        }
        super.attachBaseContext(newBase)


    }
}