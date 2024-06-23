rootProject.name = "Referral"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("paper-api", "io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
            library("placeholder-api", "me.clip:placeholderapi:2.11.6")
        }
    }
}