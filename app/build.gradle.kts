plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
    id("org.jlleitschuh.gradle.ktlint") version "10.2.0"
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.ticketswap.android.assessment"

        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {

        debug {
            isMinifyEnabled = false
            isTestCoverageEnabled = true
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        dataBinding = true
    }

    // Allow references to generated code
    kapt {
        correctErrorTypes = true
    }
}

// https://github.com/JLLeitschuh/ktlint-gradle#configuration
ktlint {
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.HTML)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
    }
}

dependencies {

    implementation("com.google.android.material:material:1.4.0")

    // Android Jetpack
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.multidex:multidex:2.0.1")
    testImplementation("androidx.test:core:1.4.0")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")

    // Dependency Injection
    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")
    implementation("androidx.fragment:fragment-ktx:1.1.0")

    // Kotlin
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.5.31"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Coroutine
    implementation(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.5.2"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")

    // Navigation component
    val navigationComponentVersion = "2.3.5"
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationComponentVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationComponentVersion")
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$navigationComponentVersion")
    androidTestImplementation("androidx.navigation:navigation-testing:$navigationComponentVersion")

    // Test
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.robolectric:robolectric:4.7.2")
    testImplementation("io.mockk:mockk:1.12.1")
}
