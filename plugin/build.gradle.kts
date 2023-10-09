dependencies {
    implementation("de.tr7zw:item-nbt-api:2.11.3")
    implementation("com.iridium:IridiumColorAPI:1.0.6")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.2")
    implementation("com.fasterxml.jackson.core:jackson-core:2.14.2")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.14.2")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.14.2")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.2")
    implementation("org.yaml:snakeyaml:2.0")
    implementation("io.papermc:paperlib:1.0.8")

    compileOnly("org.jetbrains:annotations:24.0.1")
    compileOnly("org.spigotmc:spigot-api:1.19.3-R0.1-SNAPSHOT")

    val multiVersionProjects = project(":multiversion").dependencyProject.subprojects
    multiVersionProjects.forEach { compileOnly(it) }
}

tasks {
    build {
        dependsOn(processResources)
    }
}
