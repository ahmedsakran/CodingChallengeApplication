package group.payback.codingchallengeapplication.di.repositoriesmodules

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import group.payback.codingchallengeapplication.data.local.LocalDataSource
import group.payback.codingchallengeapplication.data.remote.RemoteDataSource
import group.payback.codingchallengeapplication.domain.repositories.ImageDetailsRepository
import group.payback.codingchallengeapplication.data.repo.ImageDetailsRepositoryImpl
import group.payback.codingchallengeapplication.domain.repositories.ImagesRepository
import group.payback.codingchallengeapplication.data.repo.ImagesRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ImagesRepoModule {
    @Binds
    abstract fun provideImagesRepository(repo: ImagesRepositoryImpl): ImagesRepository

    @Binds
    abstract fun provideImageDetailsRepository(repo: ImageDetailsRepositoryImpl): ImageDetailsRepository
}

//region old code before changes
//@Module
//@InstallIn(SingletonComponent::class)
//object ImagesRepoModule {
//    @Singleton
//    @Provides
//    fun provideImagesRepository(localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource): ImagesRepository {
//        return ImagesRepositoryImpl(remoteDataSource, localDataSource)
//    }
//    @Singleton
//    @Provides
//    fun provideImageDetailsRepository(localDataSource: LocalDataSource): ImageDetailsRepository {
//        return ImageDetailsRepositoryImpl(localDataSource)
//    }
//}
//endregion