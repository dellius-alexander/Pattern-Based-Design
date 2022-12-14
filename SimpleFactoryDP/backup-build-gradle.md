# Project Build Script

```
plugins {
    id 'java-library'
    id 'application'
}

group 'org.example'
version findProperty('version')

compileJava {
    options.compilerArgs.addAll(['-Xlint:unchecked'])
    options.deprecation = true
}

dependencies {
    // lombok annotations is for boilerplate code generation
    implementation 'org.projectlombok:lombok:1.18.24'
    compileOnlyApi 'org.junit.jupiter:junit-jupiter-api:5.9.0'
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.9.0'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.9.0'
}
// run tests
test {
    useJUnitPlatform()
}
// Project and System properties
task propertyTypes(){
    doLast{
        if (project.hasProperty("args")) {
            println javaMainClass + " - Project input arguments: ["
            project.getProperty("args").each { arg ->
                println arg
            }
            println "]"
        }

        if (System.getProperty("args")) {
            println javaMainClass +" - System input arguments: ["
            System.getProperty("args").each { arg ->
                println arg
            }
            println "]"
        }
    }
}
// Using and creating an Executable Jar
jar {
    // Exclude file from jar:
    exclude 'META-INF/*.SF', 'META-INF/*.DSA', 'META-INF/*.RSA', 'META-INF/*.MF'
    //noinspection GroovyAssignabilityCheck
    manifest {
        attributes  'Main-Class': 'com.example.SimpleFactory.Client',
                'Class-Path': configurations.runtimeClasspath.files.collect { it.name }.join(' ')
    }
}
// run the app and pass CLi arguments: method 1
task runApp(type: JavaExec) {
    classpath = sourceSets.main.runtimeClasspath
    mainClass.set('com.example.SimpleFactory.Client')
    // arguments to pass to the application
    args 'Mango', 'Peach', 'Fuji Apple'

}
// run the app and pass CLi arguments: method 2
task runExecutableJar(type: JavaExec) {
    // Executable jars can have only _one_ jar on the classpath.
    classpath = files(tasks.jar)
    //    // 'main' does not need to be specified

    // arguments to pass to the application
    args 'Golden Apple', 'Peach', 'Mango'
}

runExecutableJar.dependsOn jar
propertyTypes.dependsOn runExecutableJar
runApp.dependsOn jar
propertyTypes.dependsOn runApp

```
