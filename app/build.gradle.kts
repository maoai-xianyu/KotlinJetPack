plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(ProjectProperties.compileSdk)
    buildToolsVersion(ProjectProperties.buildToolsVersion)

    defaultConfig {
        minSdkVersion(ProjectProperties.minSdk)
        targetSdkVersion(ProjectProperties.targetSdk)
        applicationId = ProjectProperties.applicationId
        versionCode = ProjectProperties.versionCode
        versionName = ProjectProperties.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Libs.kotlinStdLib)
    implementation(Libs.ktxCore)
    implementation(Libs.appCompat)
    implementation(Libs.material)
    implementation(Libs.constraintlayout)
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.testExt)
    androidTestImplementation(Libs.espresso)
    implementation(Libs.volley)
    implementation(Libs.gson)
    implementation(Libs.glide)
    annotationProcessor(Libs.glideCompiler)
}