package com.example.kitsuapi.base

abstract class BaseRepository {

    fun <T> doRequest(result: suspend () -> Response<T>) = liveData {
        emit(Resource.Loading())

        try {
            result().body()?.let {
                emit(Resource.Success(it))
            }
        } catch (ioException: IOException) {
            emit(ioException.localizedMessage?.let { Resource.Error(it, null) })
        }
    }
}