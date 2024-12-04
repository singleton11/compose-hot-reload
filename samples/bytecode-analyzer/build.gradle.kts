import org.jetbrains.kotlin.compose.compiler.gradle.ComposeFeatureFlag

plugins {
    kotlin("multiplatform")
    kotlin("plugin.compose")
    id("org.jetbrains.compose")
    id("org.jetbrains.compose-hot-reload")
}

kotlin {
    jvm()
    jvmToolchain(17)

    composeCompiler {
        featureFlags.add(ComposeFeatureFlag.OptimizeNonSkippingGroups)
    }

    sourceSets.commonMain.dependencies {
        implementation("io.sellmair:evas:1.1.0")
        implementation("io.sellmair:evas-compose:1.1.0")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
        implementation("org.jetbrains.compose:hot-reload-analysis:1.0.0-dev.31.1")
        implementation("ch.qos.logback:logback-classic:1.5.9")
        implementation(compose.desktop.currentOs)
        implementation(compose.foundation)
        implementation(compose.material3)
        implementation(compose.components.resources)
    }
}

tasks.withType<JavaExec> {
    workingDir(layout.buildDirectory.dir("classes/kotlin/jvm/main"))
}