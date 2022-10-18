package es.codigonline.proyecto.language

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import es.codigonline.proyecto.language.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val locale = intent.extras?.getString("locale")
        locale?.let {
            val contenxt = this.setAppLocale(it)
            this.attachBaseContext(contenxt)
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()

        binding.english.setOnClickListener {
            this.getSharedPreferences("preferences", Context.MODE_PRIVATE).edit().apply {
                putString("locale", "en")
            }.apply()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        binding.spanish.setOnClickListener {
            this.getSharedPreferences("preferences", Context.MODE_PRIVATE).edit().apply {
                putString("locale", "es")
            }.apply()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }

    override fun attachBaseContext(newBase: Context?) {
        val preferences = newBase?.getSharedPreferences("preferences", Context.MODE_PRIVATE)
        preferences?.let {
            val locale = it.getString("locale", "en")!!
            super.attachBaseContext(ContextWrapper(newBase.setAppLocale(locale)))
            Log.d("LOCALE", locale)
            return
        }
        super.attachBaseContext(newBase)


    }

    fun Context.setAppLocale(language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
        config.setLayoutDirection(locale)
        return createConfigurationContext(config)
    }
}