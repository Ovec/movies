package cz.mireksirina.movies.di

import android.app.Application
import cz.mireksirina.movies.data.manager.LocalUserMangerImpl
import cz.mireksirina.movies.data.remote.MoviesApi
import cz.mireksirina.movies.data.repository.MoviesRepositoryImpl
import cz.mireksirina.movies.domain.manager.LocalUserManger
import cz.mireksirina.movies.domain.repository.MoviesRepository
import cz.mireksirina.movies.domain.usecases.app_entry.AppEntryUseCases
import cz.mireksirina.movies.domain.usecases.app_entry.ReadAppEntry
import cz.mireksirina.movies.domain.usecases.app_entry.SaveAppEntry
import cz.mireksirina.movies.domain.usecases.movies.GetPopularMovies
import cz.mireksirina.movies.domain.usecases.movies.MoviesUseCases
import cz.mireksirina.movies.domain.usecases.movies.SearchMovies
import cz.mireksirina.movies.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

//    @Provides
//    @Singleton
//    fun provideLocalUserManger(
//        application: Application
//    ): LocalUserManger = LocalUserMangerImpl(context = application)
//
//    @Provides
//    @Singleton
//    fun provideAppEntryUseCases(
//        localUserManger: LocalUserManger
//    ): AppEntryUseCases = AppEntryUseCases(
//        readAppEntry = ReadAppEntry(localUserManger),
//        saveAppEntry = SaveAppEntry(localUserManger)
//    )

    @Provides
    @Singleton
    fun provideApiInstance(): MoviesApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMoviesRepository(
        moviesApi: MoviesApi
    ): MoviesRepository {
        return MoviesRepositoryImpl(moviesApi)
    }

    @Provides
    @Singleton
    fun provideMoviesUseCases(
        moviesRepository: MoviesRepository
    ): MoviesUseCases {
        return MoviesUseCases(
            getPopularMovies = GetPopularMovies(moviesRepository),
            searchMovies = SearchMovies(moviesRepository)
        )
    }

//    @Provides
//    @Singleton
//    fun provideNewsDatabase(
//        application: Application
//    ): NewsDatabase {
//        return Room.databaseBuilder(
//            context = application,
//            klass = NewsDatabase::class.java,
//            name = "news_db"
//        ).addTypeConverter(NewsTypeConvertor())
//            .fallbackToDestructiveMigration()
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideNewsDao(
//        newsDatabase: NewsDatabase
//    ): NewsDao = newsDatabase.newsDao

}