package com.permuta.plantillacomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.PlantillaComponentesTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlantillaComponentesTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = { Text("Componentes M3") }
                        )
                    }
                ) { innerPadding ->
                    ComponentList(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

data class ComponentData(
    val name: String,
    val usage: String,
    val content: @Composable () -> Unit
)

@Composable
fun ComponentList(modifier: Modifier = Modifier) {
    val components = listOf(
        ComponentData("Button", "Acción principal de alta importancia.") {
            Button(onClick = { }) { Text("Click") }
        },
        ComponentData("OutlinedButton", "Acción de importancia media con borde.") {
            OutlinedButton(onClick = { }) { Text("Click") }
        },
        ComponentData("TextButton", "Acción de baja importancia sin borde.") {
            TextButton(onClick = { }) { Text("Click") }
        },
        ComponentData("TextField", "Campo para entrada de texto.") {
            var text by remember { mutableStateOf("") }
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Escribe...") },
                modifier = Modifier.width(120.dp)
            )
        },
        ComponentData("CheckBox", "Selección múltiple o confirmación.") {
            var checked by remember { mutableStateOf(true) }
            Checkbox(checked = checked, onCheckedChange = { checked = it })
        },
        ComponentData("RadioButton", "Selección única dentro de un grupo.") {
            var selected by remember { mutableStateOf(true) }
            RadioButton(selected = selected, onClick = { selected = !selected })
        },
        ComponentData("Switch", "Alternar entre encendido y apagado.") {
            var checked by remember { mutableStateOf(true) }
            Switch(checked = checked, onCheckedChange = { checked = it })
        },
        ComponentData("Image", "Muestra un recurso gráfico.") {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
        },
        ComponentData("Icon", "Representación visual simbólica.") {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
        },
        ComponentData("CircularProgress", "Indicador de progreso circular.") {
            CircularProgressIndicator(
                modifier = Modifier.size(32.dp),
                strokeWidth = 3.dp
            )
        },
        ComponentData("LinearProgress", "Indicador de progreso lineal.") {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
            )
        }
    )

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        items(components) { item ->
            ComponentRow(item)
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp),
                thickness = 0.5.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )
        }
    }
}

@Composable
fun ComponentRow(item: ComponentData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width(130.dp)
                .padding(end = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            item.content()
        }

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = item.usage,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComponentPreview() {
    PlantillaComponentesTheme(darkTheme = true) {
        Surface {
            ComponentList()
        }
    }
}
