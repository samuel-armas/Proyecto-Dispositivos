package com.example.dispositivos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.dispositivos.ui.theme.DispositivosTheme
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DispositivosTheme {
                //Variable para que sea compatible con compose
                var device by remember { mutableStateOf(listOf<Device>())}

                var isLoading by remember { mutableStateOf(true) }

                getDevices { result ->
                    if (result != null){
                        device = result
                    }
                }
                getDevice { result ->
                    device = result
                }
                isLoading = false

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column (horizontalAlignment = Alignment.CenterHorizontally){
                        MainView(Modifier.padding(innerPadding),
                            devices = device)

                        if (isLoading){
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }

    }
    //FUNCION DE ORDEN SUPERIOR
    private fun getDevices(onResult: (List<Device>?) -> Unit){
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val services = retrofit.create(DispositivosService::class.java)
        var devices: List<Device>? = null
        lifecycleScope.launch {
            val devices = services.getAllDevices()

            onResult(devices)
        }
    }

    private fun getDevice(onResult: (List<Device>) -> Unit){
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val services = retrofit.create(DispositivosService::class.java)
        lifecycleScope.launch {
            val device = services.getOject()
            onResult(listOf(device))
        }
    }

}