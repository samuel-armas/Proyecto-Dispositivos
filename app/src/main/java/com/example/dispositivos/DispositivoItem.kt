package com.example.dispositivos

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dispositivos.ui.theme.DispositivosTheme

@Composable
fun DeviceView(device: Device) {
    Column {
        Text(text = device.name)
        Text(text = device.data?.color ?: "-")
        Text(text = device.data?.capacity ?: "-")
    }
}

@Preview(showBackground = true)
@Composable
fun DeviceItemPreview(){
    DispositivosTheme {
        DeviceView(device = Device(1, "Nexus", Specs("Rojo", "256 GB")))
    }
}