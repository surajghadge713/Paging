package com.example.mvvmpagingtutorial.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import okhttp3.logging.HttpLoggingInterceptor





//const val API_KEY = "6b21f5d744c89ad892ff4ba87aaf4f3a"
//const val API_KEY = "71bc45e9658bda6e8654114f257d86ad"
const val API_KEY = "c234c6b0cd6339ebdcaf614908334808"
const val BASE_URL = "https://developers.zomato.com/api/v2.1/"

const val FISRT_PAGE = 1
const val RESTAURANTS_PER_PAGE = 10

object AceNutritionClient {

    fun getClient() : AceNutritionService{

        val requestIntercepter = Interceptor{chain ->

            val url=chain.request()
                .url()
                .newBuilder()
                .build()

            val request = chain.request()
                .newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("user-key",API_KEY)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .url(url)
                .build()

            return@Interceptor chain.proceed(request)

        }

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestIntercepter)
            .connectTimeout(60,TimeUnit.SECONDS)
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(AceNutritionService::class.java)
    }
}