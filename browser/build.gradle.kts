plugins {
    kotlin("js") version "1.5.10"
}

dependencies {
    implementation(project(":library"))
}

kotlin {
    js {
        binaries.executable()
        browser()
    }
}
