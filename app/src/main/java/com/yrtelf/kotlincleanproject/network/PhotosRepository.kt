package com.yrtelf.kotlincleanproject.network

import com.fernandocejas.sample.core.exception.Failure
import com.fernandocejas.sample.core.functional.Either
import com.yrtelf.kotlincleanproject.feature.photosList.Photo
import retrofit2.Call
import javax.inject.Inject

interface PhotosRepository {

    fun photos(): Either<Failure, List<Photo>>

    class Network
    @Inject constructor(
        private val networkHandler: NetworkHandler,
        private val service: PhotosService
    ) : PhotosRepository {

        override fun photos(): Either<Failure, List<Photo>> {
            return when (networkHandler.isConnected) {
                true -> request(service.photos(), { it.map { it.toMovie() } }, emptyList())
                false, null -> Either.Left(Failure.NetworkConnection)
            }
        }

        private fun <T, R> request(
            call: Call<T>,
            transform: (T) -> R,
            default: T
        ): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Either.Right(transform((response.body() ?: default)))
                    false -> Either.Left(Failure.ServerError)
                }
            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError)
            }
        }
    }


}

