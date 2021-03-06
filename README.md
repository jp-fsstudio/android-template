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
* [Staging and Production](https://github.com/jpbalarini/android-template/blob/master/app/build.gradle#L28-L37) build flavors with different package names ([read more](http://tools.android.com/tech-docs/new-build-system/user-guide#TOC-Product-flavors))
* Logger configuration [supporting `Exception` logging](https://github.com/jpbalarini/android-template/blob/master/app/src/main/java/com/fsstudio/template/App.java#L24-L26) ([read more](https://github.com/JakeWharton/timber))
* [Java 8 lambdas support and configuration]() ([read more](https://github.com/evant/gradle-retrolambda))
* [Robolectric support and configuration]() ([read more](http://blog.blundell-apps.com/android-gradle-app-with-robolectric-junit-tests/))
* [Dagger](http://square.github.io/dagger/) configuration ([read more](http://stackoverflow.com/a/16923040)):
	* [`Application`](https://github.com/jpbalarini/android-template/blob/master/app/src/main/java/com/fsstudio/template/App.java) subclass with an [application-wide scope]()
	* [`Activity`](https://github.com/jpbalarini/android-template/blob/master/app/src/main/java/com/fsstudio/template/MainActivity.java) subclass with configured [UI-wide scope]() and a root `Fragment`
	* [`ScopedFragment`]() for `Fragment`-wide [scopes]()
* Default `Menu` with *Settings* `MenuItem`
* [`Preferences`]() interface for the `SharedPreferences` boilerplate reduction (using [Esperandro](http://dkunzler.github.io/esperandro/))
* [`PreferenceFragment`](https://github.com/jpbalarini/android-template/blob/master/app/src/main/java/com/fsstudio/template/fragments/PrefsFragment.java) with default Preferences xml added to a `MainFragment`'s *Settings* `MenuItem`
* *Android Lint* [configuration](https://github.com/jpbalarini/android-template/blob/master/app/build.gradle#L64-L69)
* *Travis CI* build [script](https://github.com/jpbalarini/android-template/blob/master/.travis.yml):
    * Downloading an *Android SDK*
    * Building
    * Running *Android Lint*
    * Running *Robolectric* tests
    * Hook up your continuous deployment target in after_success
* Release build signing and naming configuration

##What's not included
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
    It will ask you the package name and rename the project based on that. Make sure to enter something with three identifiers, for example: com.example.app
 3. Import the project into your favourite IDE (only [Android Studio](https://developer.android.com/sdk/installing/studio.html) and [IntelliJ IDEA 13](http://www.jetbrains.com/idea/) are supported at the moment).
Just select the root `build.gradle` and your IDE will do the rest.
It will ask you to change the language level - do it, we're using Java 8 now
 4. Configure Fabric.
    Get your ApiKey and apiSecret from [Fabric](https://fabric.io/settings/organizations).
    Replace the ApiKey in the AndroidManifest.xml. Create the fabric.properties under /app and put the following:
    ```
    apiSecret=YOUR_API_SECRET
    ```
    Build your project until it appears on the Fabric Dashboard.


### Configure HockeyApp
* Create a new app on Hockeyapp
* Save the newly created APP_ID and your account TOKEN, you will use it later

### Configure TravisCI
* Check the .travis.yml file
* Replace Android-Template with your project name
* Use the travis encrypt command to encrypt the following variables:

```sh
travis encrypt "HOCKEY_APP_ID=super_secret" --add -r repoUser/repoName
travis encrypt "HOCKEY_APP_TOKEN=super_secret" --add -r repoUser/repoName
```

###Making a release build
* Just uncomment [these lines](https://github.com/jpbalarini/android-template/blob/master/app/build.gradle#L39-L46) and fill them up with your credentials
