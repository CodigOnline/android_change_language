# Proyectos Android
## _Cambiar idioma de una app_


Existen ocasiones en las que deseamos crear aplicaciones donde el idioma no vaya vinculado al idioma del dispositvo. Es por ello que deberemos modificar nuestras propiedades de la aplicación y darle un nuevo contexto en el que tengamos en cuenta la personalización deseada por el usuario.

Para realizar este proyecto se ha hecho uso de:
- [ViewBinding] - Vinculación de vistas en Android Components
- [Kotlin Extension] - Funciones de extensión de kotlin
- [Attach Base Context] - Para actualizar el contexto cuando se inicializa una actividad
- [Locales] - Explorar los diferents Locales que existen
- [App] - Donde hayamos las configuraciones iniciales de nuestra aplicación.
  -- preferences: Para obtener las preferencias en cualquier lugar de nuestra App
  -- changeLanguage: Para cambiar de idioma
  -- refreshActivity: Para reinicializar la actividad deseada
  -- Context.setAppLocale: Para crear un nuevo context que utilizaremos al iniciar la actividad



**Free Software, CodigOnline*

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

[viewBinding]: <https://developer.android.com/topic/libraries/view-binding?hl=es-419>
[Kotlin Extension]: <https://developer.android.com/kotlin/ktx?gclid=Cj0KCQjwnbmaBhD-ARIsAGTPcfVkZcld3jPH24Z73haikJQR_dFsfJ-PIn3c6kn_KfyCAD7q_Fkl5rQaAlh8EALw_wcB&gclsrc=aw.ds>
[Locales]: <https://www.localeplanet.com/icu/>
[Attach Base Context]:<https://developer.android.com/reference/android/content/ContextWrapper#attachBaseContext(android.content.Context)>
   