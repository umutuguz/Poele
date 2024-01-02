package com.umut.poele.domain.repository

import com.umut.poele.data.source.remote.dto.MemeDto

interface MemeRepository {

    suspend fun getMemes(): List<MemeDto>
}
