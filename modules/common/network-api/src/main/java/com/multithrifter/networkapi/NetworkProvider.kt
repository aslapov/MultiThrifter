package com.multithrifter.networkapi

import retrofit2.Retrofit

interface NetworkProvider {
    fun provideRetrofit(): Retrofit
}