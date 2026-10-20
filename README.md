# plantillaComponentes

**plantillaComponentes** es una app Android de referencia, escrita con Kotlin y Jetpack Compose (Material 3), que funciona como catálogo visual de los componentes de interfaz más habituales. Muestra en una lista cada componente funcionando (botones, campos de texto, checkbox, switch, indicadores de progreso, etc.) junto a una breve descripción de cuándo usarlo, de modo que sirva como plantilla y chuleta rápida para copiar y adaptar en otros proyectos.

## Componentes incluidos

| Componente | Uso |
|---|---|
| `Button` | Acción principal de alta importancia. |
| `OutlinedButton` | Acción de importancia media con borde. |
| `TextButton` | Acción de baja importancia sin borde. |
| `TextField` | Campo para entrada de texto. |
| `Checkbox` | Selección múltiple o confirmación. |
| `RadioButton` | Selección única dentro de un grupo. |
| `Switch` | Alternar entre encendido y apagado. |
| `Image` | Muestra un recurso gráfico. |
| `Icon` | Representación visual simbólica. |
| `CircularProgressIndicator` | Indicador de progreso circular. |
| `LinearProgressIndicator` | Indicador de progreso lineal. |

## Estructura

- `app/src/main/java/com/permuta/plantillacomponentes/MainActivity.kt`: pantalla principal. Define `ComponentData` (nombre, descripción y composable de ejemplo), `ComponentList` (la lista con todos los componentes) y `ComponentRow` (cada fila).
- `app/src/main/java/com/permuta/plantillacomponentes/ui/theme/`: tema de la app (`Color.kt`, `Type.kt`, `Theme.kt`), con soporte para modo claro y oscuro.

Para añadir un componente nuevo basta con agregar un `ComponentData(...)` a la lista en `ComponentList`.

## Requisitos

- Android Studio (versión reciente con soporte para AGP/Gradle 9)
- JDK 11 o superior
- `minSdk` 34, `targetSdk` / `compileSdk` 37

## Ejecución

1. Clona o abre el proyecto en Android Studio.
2. Espera a que Gradle sincronice.
3. Ejecuta la configuración `app` en un emulador o dispositivo con Android 14 (API 34) o superior.

También por línea de comandos:

```bash
./gradlew installDebug
```

## Tecnologías

- Kotlin
- Jetpack Compose y Material 3
- Gradle (Kotlin DSL) con catálogo de versiones (`gradle/libs.versions.toml`)
