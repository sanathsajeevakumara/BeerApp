# BeerApp
Beer application with compose paging 3 and caching
* API used - [Punk API][9]

## IDE And Architecture

* [Adroid Studio][11] Version: Android Studio Electric Eel | 2022.1.1
* MVVM Clean Archiecture: Application Archiecture.
* [ViewModel][10]: Composable state management.

[10]: https://developer.android.com/topic/libraries/architecture/viewmodel
[11]: https://developer.android.com/studio

## Libraries Used :books:

* [Compose][0]: Toolkit for building native UI (in a declarative way - 100% Kotlin).
* [Coroutines][1]: Library support for Kotlin coroutines.
* [Flows][2]: Stream processing API, built on top of Coroutines.
* [Room][3]: for Local Data store.
* [Dagger Hilt][4]: Dependency injection library for Android.
* [Retrofit][5]: Type-safe REST client for Android to consume RESTful web services.
* [Koil][8]: Image downloading and caching library supported by Jetpack Compose.


[0]:  https://developer.android.com/jetpack
[1]:  https://github.com/Kotlin/kotlinx.coroutines
[2]:  https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/
[3]:  https://developer.android.com/training/data-storage/room
[4]:  https://dagger.dev/hilt/
[5]:  https://github.com/square/retrofit
[8]: https://github.com/bumptech/glide
[9]: https://punkapi.com/documentation/v2

## Package Structure :bookmark_tabs:

* core - Package that contains files that can be accessible by another package from the project. 
* data - Data(Local or Remote) Package that can only access the domain package.
* di - DI package for preform dependecy injection.
* domain - The innermost layer. That can access other layers.
* presentation - UI package that can only access the domain package.


# App Preview :octocat:

https://user-images.githubusercontent.com/11756630/231702212-60978591-42d4-4e62-a3a5-42f737265c34.mp4
