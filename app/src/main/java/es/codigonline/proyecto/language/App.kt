package es.codigonline.proyecto.language

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class App : Application() {

    init {
        instancia = this
    }

    companion object {
        private lateinit var instancia: App
        fun preferences(): SharedPreferences {
            return instancia.getSharedPreferences(
                Constants.SHARED_PREFERENCES_NAME,
                Context.MODE_PRIVATE
            )
        }

        fun <T> changeLanguage(
            locale: String,
            context: Context,
            clazz: Class<T>
        ) where T : AppCompatActivity {
            preferences().edit().putString(Constants.PREFERENCE_LOCALE_NAME, locale).apply()
            refreshActivity(context, clazz)
        }

        private fun <T> refreshActivity(
            context: Context,
            clazz: Class<T>
        ) where T : AppCompatActivity {
            context.startActivity(Intent(context, clazz))
            (context as T).finish()
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

    override fun onCreate() {
        super.onCreate()
    }
}