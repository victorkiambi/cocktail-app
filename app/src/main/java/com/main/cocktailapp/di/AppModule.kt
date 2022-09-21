package com.main.cocktailapp.di

import android.app.Application
import androidx.room.Room
import com.main.cocktailapp.BuildConfig
import com.main.cocktailapp.core.util.Constants
import com.main.cocktailapp.data.local.remote.CocktailsApi
import com.main.cocktailapp.data.local.remote.DrinkDatabase
import com.main.cocktailapp.data.repository.DrinkRepositoryImpl
import com.main.cocktailapp.domain.repository.DrinkRepository
import com.main.cocktailapp.domain.use_case.GetDrinksUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesCocktailApi(): CocktailsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient().newBuilder().apply {
                    addInterceptor(
                        Interceptor { chain ->
                            val builder = chain.request().newBuilder()
                            builder.header("X-RapidAPI-Key", BuildConfig.RAPID_API_KEY)
                            builder.header("X-RapidAPI-Host", BuildConfig.RAPID_API_HOST)
                            return@Interceptor chain.proceed(builder.build())
                        }
                    )
                }.build()
            )
            .build()
            .create(CocktailsApi::class.java)
    }

    @Provides
    @Singleton
    fun providesCocktailDatabase(app: Application): DrinkDatabase {
        return Room.databaseBuilder(
            app,
            DrinkDatabase::class.java,
            "cocktails_db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesDrinkRepository(api: CocktailsApi, db: DrinkDatabase): DrinkRepository {
        return DrinkRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideGetDrinkUseCase(repository: DrinkRepository): GetDrinksUseCase {
        return GetDrinksUseCase(repository)
    }
}
