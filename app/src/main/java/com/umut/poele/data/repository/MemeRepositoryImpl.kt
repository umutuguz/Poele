package com.umut.poele.data.repository

import com.umut.poele.data.source.remote.PoeleApiService
import com.umut.poele.data.source.remote.dto.MemeDto
import com.umut.poele.domain.repository.MemeRepository
import javax.inject.Inject

class MemeRepositoryImpl @Inject constructor(private val api: PoeleApiService) : MemeRepository {

    override suspend fun getMemes(): List<MemeDto> {
        val result = api.getMemes()
        return if (result.success) {
            result.data.memes
        }
        else {
            emptyList()
        }
    }
}
