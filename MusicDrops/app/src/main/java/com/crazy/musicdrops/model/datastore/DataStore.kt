package com.crazy.musicdrops.model.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

const val DATA_STORE_NAME = "datastore"

class DataStore @Inject constructor(@ApplicationContext private val context: Context) {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(DATA_STORE_NAME)

    suspend fun set(key: String, value: String) {
        val stringKey = stringPreferencesKey(key)
        context.dataStore.edit { dataStore ->
            dataStore[stringKey] = value
        }
    }

    suspend fun set(key: String, value: Boolean) {
        val booleanKey = booleanPreferencesKey(key)
        context.dataStore.edit { dataStore ->
            dataStore[booleanKey] = value
        }
    }

    fun getString(key: String, default: String): Flow<String> {
        return context.dataStore.data.map { dataStore ->
            val stringKey = stringPreferencesKey(key)
            dataStore[stringKey] ?: default
        }
    }

    fun getStringOrNull(key: String): Flow<String?> {
        return context.dataStore.data.map { dataStore ->
            val stringKey = stringPreferencesKey(key)
            dataStore[stringKey]
        }
    }

    fun getBoolean(key: String, default: Boolean): Flow<Boolean> {
        return context.dataStore.data.map { dataStore ->
            val booleanKey = booleanPreferencesKey(key)
            dataStore[booleanKey] ?: default
        }
    }

    fun getBooleanOrNull(key: String): Flow<Boolean?> {
        return context.dataStore.data.map { dataStore ->
            val booleanKey = booleanPreferencesKey(key)
            dataStore[booleanKey]
        }
    }

}
