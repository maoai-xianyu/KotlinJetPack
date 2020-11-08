/**
 *
 * @author zhangkun
 * @time 2020/11/7 12:35 AM
 * @Description 管理依赖库
 */

object Libs {
    // Android
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val junit = "junit:junit:${Versions.junit}"
    const val testExt = "androidx.test.ext:junit:${Versions.testExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    // kotlin
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktxCore}"

    // other
    const val volley = "com.android.volley:volley:${Versions.volley}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

}