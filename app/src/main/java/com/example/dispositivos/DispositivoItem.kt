package com.example.dispositivos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.dispositivos.ui.theme.DispositivosTheme
import com.example.dispositivos.ui.theme.Typography

@Composable
fun DeviceView(device: Device) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = Icons.Default.Phone,
            contentDescription = null)
        Column {
            Text(text = device.name, style = Typography.headlineSmall)
            Text(text = device.data?.color ?: "-", style = Typography.bodyMedium)
            Text(text = device.data?.capacity ?: "-", style = Typography.bodyMedium)

            HorizontalDivider()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DeviceItemPreview(){
    DispositivosTheme {
        DeviceView(device = Device(1,
            "Nexus", Specs("Rojo", "256 GB")))
    }
}