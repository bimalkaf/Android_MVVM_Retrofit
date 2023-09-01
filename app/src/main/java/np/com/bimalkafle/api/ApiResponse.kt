package np.com.bimalkafle.api

sealed class ApiResponse<T> (val data : T? = null,val message : String? =null) {
    class ApiSuccess<T>(data: T?) : ApiResponse<T>(data = data)
    class ApiError<T>(message: String?) : ApiResponse<T>(message = message)

    class ApiLoading<T>() : ApiResponse<T>()
}
