## Andoroiddevportfolio

An Android developer portfolio app showcasing projects, patterns, and platform skills. This repo serves as a portfolio and a playground for modern Android development.

### Highlights
- **Language**: Kotlin
- **Build**: Gradle (Wrapper included)
- **IDE**: Android Studio (Koala/Jellyfish or newer)
- **Min SDK**: 21+ (adjust as needed)
- **Architecture**: MVVM with Jetpack components
- **UI**: Jetpack Compose and/or XML Views

## Table of Contents
- Overview
- Features
- Screenshots
- Tech Stack
- Architecture
- Project Structure
- Getting Started
- Build and Run
- Testing
- Code Quality
- Environments & Secrets
- Releasing
- Troubleshooting
- Contributing
- License

## Overview
This app aggregates feature samples and common production patterns: clean architecture, reactive streams, dependency injection, offline-first data, and modern UI.

## Features
- **Portfolio sections** for apps/components (update as the app evolves)
- **Navigation**: Single-activity, multi-screen navigation (deep links optional)
- **Theming**: Light/Dark with Material 3 (if enabled)
- **Offline caching**: Room/SQLite (if applicable)
- **Networking**: Retrofit/OkHttp (if applicable)

## Screenshots
Add images to `docs/screenshots/` and reference them here.

```md
![Home](docs/screenshots/home.png)
![Detail](docs/screenshots/detail.png)
```

## Tech Stack
- Kotlin, Coroutines, Flow
- Jetpack: ViewModel, LiveData/Flow, Navigation, DataStore
- UI: Jetpack Compose or XML Views + Material 3
- DI: Hilt or Koin (if used)
- Data: Room, Retrofit/OkHttp, Moshi/Gson
- Tests: JUnit, MockK, Turbine, Espresso/Compose UI Test

## Architecture
- Layered: Data → Domain → Presentation (MVVM)
- Unidirectional data flow where feasible
- Clear boundaries between networking, persistence, and UI
- Errors represented as sealed results and surfaced via ViewModel state

## Project Structure
```
Andoroiddevportfolio/
├─ app/
│  ├─ src/
│  │  ├─ main/
│  │  │  ├─ java/
│  │  │  └─ res/
│  │  └─ androidTest/ …
│  ├─ build.gradle(.kts)
├─ gradle/ (wrapper files)
├─ settings.gradle(.kts)
├─ build.gradle(.kts)
└─ README.md
```

## Getting Started

### Prerequisites
- Android Studio (Koala/Jellyfish or newer)
- JDK 17 (recommended for AGP 8+)
- Android SDK via Android Studio SDK Manager

### Setup
1. Clone the repository:
   ```bash
   git clone <your-repo-url>
   cd Andoroiddevportfolio
   ```
2. Open the project in Android Studio.
3. Let Gradle sync and index the project.

## Build and Run
- From Android Studio, select the `app` run configuration and press Run.
- From terminal (Windows examples):
  ```bash
  .\gradlew clean assembleDebug
  .\gradlew installDebug
  ```

Common tasks:
```bash
# Lint and static analysis (if configured)
.\gradlew lint detekt ktlintCheck

# Assemble release (configure signing first)
.\gradlew assembleRelease
```

## Testing
- Unit tests:
  ```bash
  .\gradlew testDebugUnitTest
  ```
- Instrumented tests (device or emulator required):
  ```bash
  .\gradlew connectedDebugAndroidTest
  ```

## Code Quality
- Ktlint: Kotlin style checks (optional plugin)
- Detekt: Static analysis (optional)
- Android Lint

Suggested commands:
```bash
.\gradlew ktlintFormat detekt lint
```

## Environments & Secrets
Keep API keys and secrets out of VCS.
- `local.properties`: Machine-local config
- `secrets.properties`: Custom file read by Gradle
- Expose via `BuildConfig` fields

Example `secrets.properties` (not committed):
```properties
API_BASE_URL=https://api.example.com
API_KEY=replace_me
```
Gradle snippet:
```kotlin
val secrets = java.util.Properties()
file("secrets.properties").takeIf { it.exists() }?.inputStream()?.use(secrets::load)
val apiKey = secrets.getProperty("API_KEY", "")
```

## Releasing
1. Configure signing in `app/` Gradle or `gradle.properties`.
2. Bump `versionCode`/`versionName`.
3. Build:
   ```bash
   .\gradlew bundleRelease
   ```
4. Upload to Play Console or distribute internally.

## Troubleshooting
- Gradle sync fails: Ensure JDK 17 and latest Android Gradle Plugin.
- Compose preview issues: Use matching Kotlin/Compose compiler versions.
- Emulator performance: Enable hardware acceleration (AVD/Hyper-V settings).

## Contributing
- Use feature branches and conventional commits if possible.
- Open a PR with a short description and screenshots for UI changes.

## License
Open source
