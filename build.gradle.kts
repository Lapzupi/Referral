plugins {
    `java-library`
    id("maven-publish")
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "me.teenaapje.referral"
version = "2.2.2"

description = "A fishing extension bringing an exciting new experience to fishing."

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
}

dependencies {
    compileOnly(libs.paper.api)
    compileOnly(libs.placeholder.api)

}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

bukkit {
    name = "Referral"
    main = "me.teenaapje.referral.Referral"
    version = "2.2.2"
    description = "A fishing extension bringing an exciting new experience to fishing."
    apiVersion = "1.20"
    author = "Teena"
    authors = listOf("Lapzupi Dev Team")
    softDepend = listOf("PlaceholderAPI")
}