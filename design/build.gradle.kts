plugins {
    kotlin("android")
    kotlin("kapt")
    id("com.android.library")
    id("maven-publish")
}

val coroutine = "1.6.3"
val coreKtx = "1.8.0"
val activity = "1.5.0"
val fragment = "1.5.0"
val appcompat = "1.4.2"
val coordinator = "1.2.0"
val recyclerview = "1.2.1"
val viewpager = "1.0.0"
val material = "1.6.1"

dependencies {
    implementation("com.github.codemenworld:react-native-clash-core:1.0.0")
    implementation("com.github.codemenworld:react-native-clash-common:2c2b543ac5")
    implementation("com.github.codemenworld:react-native-clash-service:1.0.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutine")
    implementation("androidx.core:core-ktx:$coreKtx")
    implementation("androidx.appcompat:appcompat:$appcompat")
    implementation("androidx.activity:activity:$activity")
    implementation("androidx.coordinatorlayout:coordinatorlayout:$coordinator")
    implementation("androidx.recyclerview:recyclerview:$recyclerview")
    implementation("androidx.fragment:fragment:$fragment")
    implementation("androidx.viewpager2:viewpager2:$viewpager")
    implementation("com.google.android.material:material:$material")
}

repositories {
    mavenLocal()
    mavenCentral()
    google()
    maven("https://maven.kr328.app/releases")
    maven("https://jitpack.io")
}

android {
    ndkVersion = "23.0.7599858"

    compileSdk = 31

    defaultConfig {
        minSdk = 21

        consumerProguardFiles("consumer-rules.pro")

    }
}

publishing {
  publications {
    register<MavenPublication>("release") {
      groupId = "com.github.codemenworld"
      artifactId = "react-native-clash-design"
      version = "1.0.0"

      afterEvaluate {
        from(components["release"])
      }
    }
  }
}
