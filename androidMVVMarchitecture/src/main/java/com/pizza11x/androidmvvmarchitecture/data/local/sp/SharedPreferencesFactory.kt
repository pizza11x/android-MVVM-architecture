package com.pizza11x.androidmvvmarchitecture.data.local.sp

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.M
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

object SharedPreferencesFactory {

    const val USER_SP = "user_sp"
    const val LOGIN_SP = "login_sp"
    const val BIOMETRICS_SP = "biometrics_sp"

    /* PUBLIC FUN */
    fun getSharedPreference(context: Context, name: String): SharedPreferences {
        return if (SDK_INT >= M)
            getEncryptedPreferences(context, name)
        else
            context.getSharedPreferences(name, MODE_PRIVATE)
    }

    /* PRIVATE FUN */
    private fun getEncryptedPreferences(context: Context, name: String) =
        EncryptedSharedPreferences.create(
            context,
            name,
            getMasterKey(context),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

    private fun getMasterKey(context: Context) =
        MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build()
}