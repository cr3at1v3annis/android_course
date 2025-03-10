package com.example.unit_5_practice.data

import com.example.unit_5_practice.model.AmphibianPhoto
import com.example.unit_5_practice.network.AmphibianApiService

interface AmphibianPhotosRepository {
    suspend fun getAmphibianPhotos(): List<AmphibianPhoto>
}
class NetworkAmphibianPhotosRepository(
    private val amphibianApiService: AmphibianApiService
) : AmphibianPhotosRepository {
    override suspend fun getAmphibianPhotos(): List<AmphibianPhoto>  = amphibianApiService.getPhotos()
}