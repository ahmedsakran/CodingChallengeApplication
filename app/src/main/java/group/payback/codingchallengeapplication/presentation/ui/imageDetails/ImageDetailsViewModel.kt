package group.payback.codingchallengeapplication.presentation.ui.imageDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import group.payback.codingchallengeapplication.domain.models.Hit
import group.payback.codingchallengeapplication.domain.usecases.GetImageDetailsUseCase
import group.payback.codingchallengeapplication.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ImageDetailsViewModel @Inject constructor(
    private val getImageDetailsUseCase: GetImageDetailsUseCase,
) : ViewModel() {

    private val _imageDetailsFlow: MutableStateFlow<Resource<Hit>> = MutableStateFlow(
        Resource.Loading())

    val imageDetailsFlow: StateFlow<Resource<Hit>>
        get() = _imageDetailsFlow.asStateFlow()

    fun loadImageDetails(imageID: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getImageDetailsUseCase.invoke(imageID).collect {
                _imageDetailsFlow.emit(it)
            }
        }
    }
}