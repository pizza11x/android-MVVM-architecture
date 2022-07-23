package com.pizza11x.androidmvvmarchitecture.data.di

import android.content.Context
import com.pizza11x.androidmvvmarchitecture.data.local.sp.SharedPreferencesFactory
import com.pizza11x.androidmvvmarchitecture.utils.annotations.BiometricsSharedPreferences
import com.pizza11x.androidmvvmarchitecture.utils.annotations.LoginSharedPreferences
import com.pizza11x.androidmvvmarchitecture.utils.annotations.UserSharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {

    @UserSharedPreferences
    @Provides
    fun providesUserSP(
        @ApplicationContext context: Context
    ) = SharedPreferencesFactory.getSharedPreference(context, SharedPreferencesFactory.USER_SP)

    @LoginSharedPreferences
    @Provides
    fun providesLoginSP(
        @ApplicationContext context: Context
    ) = SharedPreferencesFactory.getSharedPreference(context, SharedPreferencesFactory.LOGIN_SP)

    @BiometricsSharedPreferences
    @Provides
    fun providesBiometricsSP(
        @ApplicationContext context: Context
    ) = SharedPreferencesFactory.getSharedPreference(context, SharedPreferencesFactory.BIOMETRICS_SP)
}