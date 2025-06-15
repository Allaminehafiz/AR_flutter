plugins {
    id("com.android.application")
    id("kotlin-android")
    // Le plugin Flutter Gradle doit être appliqué après les plugins Android et Kotlin Gradle.
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.example.ar_earth_map_app"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = "27.0.12077973"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        // TODO: Spécifie ton propre identifiant d'application unique (https://developer.android.com/studio/build/application-id.html).
        applicationId = "com.example.ar_earth_map_app"
        // Tu peux mettre à jour les valeurs suivantes pour correspondre aux besoins de ton application.
        // Pour plus d'informations, vois : https://flutter.dev/to/review-gradle-config.
        minSdk = 24 // Correction de la syntaxe ici
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    buildTypes {
        release {
            // TODO: Ajoute ta propre configuration de signature pour la version de publication.
            // Signature avec les clés de débogage pour l'instant, afin que `flutter run --release` fonctionne.
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}

dependencies {
    // Fournit la session ARCore et les ressources associées.
    // Mis à jour vers la dernière version stable d'ARCore.
    implementation("com.google.ar:core:1.42.0")

    // Fournit ArFragment et d'autres ressources d'expérience utilisateur.
    // Mis à jour vers la dernière version officielle de Sceneform UX (note: Sceneform est déprécié par Google).
    implementation("com.google.ar.sceneform.ux:sceneform-ux:1.17.1")

    // Alternativement, utilise ArSceneView sans la dépendance UX.
    // Mis à jour vers la dernière version officielle de Sceneform Core (note: Sceneform est déprécié par Google).
    implementation("com.google.ar.sceneform:core:1.17.1")
}
