package com.pizza11x.androidMVVMarchitecture.data.network

import android.content.Context
import com.pizza11x.androidMVVMarchitecture.data.network.NetworkConstants.JSON_EXT
import com.pizza11x.androidMVVMarchitecture.data.network.NetworkConstants.MOCKS_ASSETS_PATH
import com.pizza11x.androidMVVMarchitecture.data.network.NetworkConstants.MOCKS_UNIT_TEST_PATH
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import java.io.File
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

class MockInterceptor @Inject constructor(
    @ApplicationContext private val context: Context,
    private val isMock: Boolean = false,
    private val runUnitTest: Boolean = false
) : Interceptor {

    /* INTERCEPTOR FUN */
    override fun intercept(chain: Interceptor.Chain): Response {
       val request = chain.request()
       if(isMock || runUnitTest){
          val fileName : StringBuilder = StringBuilder(request.url.pathSegments.last())
          var fileStream : InputStream? = null
          try {
              if(!fileName.contains(JSON_EXT)){
                 fileName.append(JSON_EXT)
              }
             fileStream = if(runUnitTest){
                File(MOCKS_UNIT_TEST_PATH+fileName).inputStream()
             }else{
                context.assets.open(MOCKS_ASSETS_PATH+fileName)
             }
             val data = fileStream.bufferedReader().use { it.readText() }
             return Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .message("")
                .code(200)
                .body(
                   data.toResponseBody("application/json".toMediaTypeOrNull())
                ).build()
          } catch (ex : IOException){
             // DO NOTHING
          } finally {
              fileStream?.close()
          }
       }
       return chain.proceed(request)
    }
}