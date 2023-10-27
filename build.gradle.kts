// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript{
    dependencies{
        classpath("io.realm:realm-gradle-plugin:10.15.1")
    }
}
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("io.realm.kotlin") version "1.4.0" apply false
}