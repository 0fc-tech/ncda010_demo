package com.example.mod4injectiondep

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DIModule {
    @Provides
    @Singleton
    fun provideRepositoryLieux()=RepositoryLieux()

    //fun provideClientHttp(@ApplicationContext appContext: Context){
    //    return MonClientHttp(appContext)
    //}
    //@Provides
    //@Singleton
    //fun provideRepositoryAdresses()=RepositoryLieux()
}