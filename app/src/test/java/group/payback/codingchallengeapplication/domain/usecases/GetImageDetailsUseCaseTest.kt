package group.payback.codingchallengeapplication.domain.usecases

import com.google.common.truth.Truth
import group.payback.codingchallengeapplication.data.repo.FakeImageDetailsRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetImageDetailsUseCaseTest  {

    private lateinit var getImageDetailsUseCase: GetImageDetailsUseCaseImpl
    private lateinit var fakeImageDetailsRepository: FakeImageDetailsRepository

    @Before
    fun setUp(){
        fakeImageDetailsRepository = FakeImageDetailsRepository()
        getImageDetailsUseCase = GetImageDetailsUseCaseImpl(fakeImageDetailsRepository)
    }

    @Test
    fun `Get Image Details, correct Image Details return` (): Unit = runBlocking{
        val images = getImageDetailsUseCase(1).first()
        Truth.assertThat((images.data?.largeImageURL?.equals("path here1 Of Green Search"))).isTrue()
    }

    @Test
    fun `Get Image Details, incorrect Image Details return` (): Unit = runBlocking{
        val images = getImageDetailsUseCase(1).first()
        Truth.assertThat((images.data?.largeImageURL?.equals("Wrong large Image URL"))).isFalse()
    }

}