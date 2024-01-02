package com.umut.poele.util.extension

import com.umut.poele.data.source.remote.dto.MemeDto
import com.umut.poele.domain.model.Meme

fun MemeDto.toMeme() : Meme {
    return Meme(
        id,
        name,
        url
    )
}
