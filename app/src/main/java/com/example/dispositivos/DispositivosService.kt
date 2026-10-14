package com.example.dispositivos

import kotlinx.serialization.descriptors.StructureKind
import retrofit2.http.GET

interface DispositivosService {
    @GET(Constants.OBJETS_PATH)
    suspend fun getAllDevices (): List<Device>


    @GET(Constants.OBJETS_PATH + Constants.OBJECT_PATH)
    suspend fun getOject (): Device
}