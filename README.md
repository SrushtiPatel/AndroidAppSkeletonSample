# Modern Android Modularized Architecture

This project implements a scalable, modularized Android architecture based on industry best practices (inspired by "Now in Android").

## Architecture Overview

The project is divided into three main layers of modules:

### 1. App Module (`:app`)
The entry point of the application. It contains the `Application` class, `MainActivity`, and top-level Navigation Graph. It depends on all feature modules.

### 2. Feature Modules (`:feature:*`)
Self-contained modules representing a specific feature or user flow.
- **`:feature:auth`**: Handles Authentication, Login, and Registration.
- **`:feature:home`**: Main landing screen and dashboard.

*Features depend on Core modules but never on other Feature modules. Navigation between features is handled via the App module or a navigation mediator.*

### 3. Core Modules (`:core:*`)
Shared infrastructure and functional modules.
- **`:core:model`**: Pure Kotlin/Java data models used across the entire app.
- **`:core:domain`**: Business logic and UseCases.
- **`:core:data`**: Repositories that orchestrate data between network and local database.
- **`:core:network`**: Retrofit configuration and API services.
- **`:core:database`**: Room database, DAOs, and entities.
- **`:core:ui`**: Common Design System, shared UI components, and Themes.
- **`:core:common`**: Utilities, extensions, and coroutine dispatchers.

## Tech Stack
- **UI**: Jetpack Compose
- **DI**: Hilt (Dagger)
- **Networking**: Retrofit + OkHttp + Kotlinx Serialization
- **Local Storage**: Room
- **Async**: Coroutines + Flow
- **Navigation**: Compose Navigation
- **Build**: Gradle Kotlin DSL + Version Catalog (`libs.versions.toml`)

## Benefits
1. **Scalability**: New features can be added in isolation.
2. **Build Speed**: Incremental builds are faster as only changed modules are recompiled.
3. **Testability**: Logic is separated into small, testable units.
4. **Reusability**: Core modules can be reused across different apps.
