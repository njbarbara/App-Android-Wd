import org.gradle.api.tasks.testing.Test
import org.gradle.testing.jacoco.plugins.JacocoTaskExtension
import org.gradle.testing.jacoco.tasks.JacocoReport
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlinx.serialize)
    alias(libs.plugins.sonar)
    jacoco
}

val coverageExclusions = listOf(
    "**/R.class",
    "**/R$*.class",
    "**/BuildConfig.*",
    "**/Manifest*.*",
    "**/*Test*.*",
    "android/**/*.*",
    "com/sae/loupgarou/pages/**",
    "com/sae/loupgarou/ui/theme/**",
    "com/sae/loupgarou/MainActivity*.*",
    "com/sae/loupgarou/Fonts*.*"
)

val unitTestCoverageReportPath =
    layout.buildDirectory.file(
        "reports/jacoco/jacocoDebugUnitTestReport/jacocoDebugUnitTestReport.xml"
    )

val sonarCoverageExclusions = listOf(
    "**/pages/**/*",
    "**/ui/theme/**/*",
    "**/MainActivity.kt",
    "**/Fonts.kt"
)

jacoco {
    toolVersion = "0.8.12"
}

android {
    namespace = "com.sae.loupgarou"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.sae.loupgarou"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
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
    kotlin {

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }

    }
    buildFeatures {
        compose = true
    }
    testOptions {
        unitTests {
            isReturnDefaultValues = true
        }
    }
}

tasks.withType<Test>().configureEach {
    extensions.configure(JacocoTaskExtension::class) {
        isIncludeNoLocationClasses = true
        excludes = listOf("jdk.internal.*")
    }
}

tasks.register<JacocoReport>("jacocoDebugUnitTestReport") {
    dependsOn("testDebugUnitTest")

    reports {
        xml.required.set(true)
        xml.outputLocation.set(unitTestCoverageReportPath)
        html.required.set(true)
        csv.required.set(false)
    }

    sourceDirectories.setFrom(
        files(
            "src/main/java",
            "src/main/kotlin"
        )
    )

    classDirectories.setFrom(
        files(
            fileTree("${layout.buildDirectory.get().asFile}/tmp/kotlin-classes/debug") {
                exclude(coverageExclusions)
            },
            fileTree("${layout.buildDirectory.get().asFile}/intermediates/javac/debug/compileDebugJavaWithJavac/classes") {
                exclude(coverageExclusions)
            },
            fileTree("${layout.buildDirectory.get().asFile}/intermediates/javac/debug/classes") {
                exclude(coverageExclusions)
            }
        )
    )

    executionData.setFrom(
        fileTree(layout.buildDirectory.get().asFile) {
            include("jacoco/testDebugUnitTest.exec")
            include("outputs/unit_test_code_coverage/debugUnitTest/testDebugUnitTest.exec")
        }
    )
}

tasks.matching { it.name == "sonar" }.configureEach {
    dependsOn("testDebugUnitTest", "jacocoDebugUnitTestReport")
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit)
    implementation(libs.retrofit.kotlinx.serialization)
    implementation(libs.okhttp)
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

}

sonar {
    properties {
        property("sonar.projectKey", "android-sae")
        property("sonar.qualitygate.wait", true)
        property(
            "sonar.coverage.jacoco.xmlReportPaths",
            unitTestCoverageReportPath.get().asFile.absolutePath
        )
        property(
            "sonar.junit.reportPaths",
            layout.buildDirectory.dir("test-results/testDebugUnitTest").get().asFile.absolutePath
        )
        property(
            "sonar.coverage.exclusions",
            sonarCoverageExclusions.joinToString(",")
        )
    }
}
