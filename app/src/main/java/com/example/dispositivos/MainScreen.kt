package com.example.dispositivos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dispositivos.ui.theme.DispositivosTheme
import com.example.dispositivos.ui.theme.Typography

@Composable
fun MainView(modifier: Modifier, devices : List<Device>){
    Column (modifier) {
        Text(text = "Comprar",
            modifier= Modifier.fillMaxWidth(),
            style = Typography.displayMedium,
            textAlign = TextAlign.Center
        )
        LazyColumn {
            items(devices.size){ index ->
                DeviceItemView(devices[index])
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainPreview() {
    DispositivosTheme {
        MainView(Modifier.padding(top = 24.dp), listOf(
            Device(1, "Nexus", Specs("Rojo", "256 GB", 23.535f)),
            Device(2, "Samsung", null)))
    }
}