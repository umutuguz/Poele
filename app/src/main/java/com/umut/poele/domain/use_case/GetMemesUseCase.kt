package com.umut.poele.domain.use_case

import android.net.http.HttpException
import android.util.Log
import com.umut.poele.domain.model.Meme
import com.umut.poele.domain.repository.MemeRepository
import com.umut.poele.util.Resource
import com.umut.poele.util.extension.toMeme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class GetMemesUseCase @Inject constructor(
    private val memeRepository: MemeRepository
){

    suspend fun getMemes(): Resource<List<Meme>> {
        var memes = emptyList<Meme>()
        withContext(Dispatchers.IO) {
            try {
                memes = memeRepository.getMemes().map { it.toMeme() }
                Log.i("umutcan", "memes size: ${memes.size}")
            } catch (e: retrofit2.HttpException) {
                Log.e("HttpException", e.localizedMessage ?: "Http Error occurred")
            } catch (e: IOException) {
                Log.e("IOException", e.localizedMessage ?: "IO Error occured")
            }
        }
        return Resource.Success(memes)
    }
}
