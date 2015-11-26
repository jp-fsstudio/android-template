Android app template
=======================================
##Prerequisites
* JDK 8
* `JAVA_HOME` pointing to your jdk8
* `ANDROID_HOME` pointing to your android-sdk

##Plugins for Android Studio for comfortable work
* [Lombok](https://plugins.jetbrains.com/plugin/6317)
* [Parcelable generator](https://github.com/mcharmas/android-parcelable-intellij-plugin)

##What's included:
* [Staging and Production]() build flavors with different package names ([read more](http://tools.android.com/tech-docs/new-build-system/user-guide#TOC-Product-flavors))
* Logger configuration [supporting `Exception` logging]() ([read more](https://github.com/JakeWharton/timber))
* [Java 8 lambdas support and configuration]() ([read more](https://github.com/evant/gradle-retrolambda))
* [Robolectric support and configuration]() ([read more](http://blog.blundell-apps.com/android-gradle-app-with-robolectric-junit-tests/))
* [Dagger](http://square.github.io/dagger/) configuration ([read more](http://stackoverflow.com/a/16923040)):
	* [`Application`]() subclass with an [application-wide scope]()
	* [`Activity`]() subclass with configured [UI-wide scope]() and a root `Fragment`
	* [`ScopedFragment`]() for `Fragment`-wide [scopes]()
* Default `Menu` with *Settings* `MenuItem`
* [`Preferences`]() interface for the `SharedPreferences` boilerplate reduction (using [Esperandro](http://dkunzler.github.io/esperandro/))
* [`PreferenceFragment`]() with default Preferences xml added to a `MainFragment`'s *Settings* `MenuItem`
* *Android Lint* [configuration]()
* *Travis CI* build [script]():
    * Downloading an *Android SDK*
    * Building
    * Running *Android Lint*
    * Running *Robolectric* tests
    * Hook up your continuous deployment target in [`after_success`]()
* Release build signing and naming configuration

##What's not included
* [Crashlytics](crashlytics.com): they live in their own world, and including their plugin in template project just fails the build, if `apikey` is not specified. Also, getting `apikey` without an IDE plugin is impossible. You can get it [here](https://crashlytics.com/downloads/android-studio)
* Test coverage: still in the process of figuring out what's the best way to enable unit test coverage for Android with Robolectric. Any suggestions will be highly appreciated

##Setup
 1. Clone application as new project with original remote named "android-base"

    	git clone --depth 1 REPO [MY-NEW-PROJECT]

    **Note: we use depth parameter here in order to not copy the history of changes in base project**

 2. Create your new repository on GitHub and push to master. Make sure master branch is tracking origin repo.

        cd [MY-NEW-PROJECT]
    	git remote add origin git@github.com:[MY-GITHUB-ACCOUNT]/[MY-NEW-PROJECT].git
    	git push -u origin master

 3. Rename the project:
        sh rename_project.sh
    It will ask you the package name and rename the project based on that. Make shure to enter something with three identifiers, for example: com.example.app
 3. Import the project into your favourite IDE (only [Android Studio](https://developer.android.com/sdk/installing/studio.html) and [IntelliJ IDEA 13](http://www.jetbrains.com/idea/) are supported at the moment).
Just select the root `build.gradle` and your IDE will do the rest.
It will ask you to change the language level - do it, we're using Java 8 now

###Making a release build
* Just uncomment [these lines]() and fill them up with your credentials

##Notes on ProGuarding
`TODO`
