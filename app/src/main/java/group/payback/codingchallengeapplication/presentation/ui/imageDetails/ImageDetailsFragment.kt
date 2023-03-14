package group.payback.codingchallengeapplication.presentation.ui.imageDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import group.payback.codingchallengeapplication.databinding.FragmentImageDetailsBinding
import group.payback.codingchallengeapplication.domain.models.Hit
import group.payback.codingchallengeapplication.util.Resource
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ImageDetailsFragment : Fragment() {
    private var hit: Hit?=null
    private var binding: FragmentImageDetailsBinding? = null
    private val itemsDetailsViewModel: ImageDetailsViewModel by viewModels()
    lateinit var detailsHitObject: Hit

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return FragmentImageDetailsBinding.inflate(
            inflater, container, false
        ).apply {
            binding = this
            lifecycleOwner = viewLifecycleOwner
            itemViewModel = itemsDetailsViewModel
            hit = arguments?.getParcelable("hit")

            collectData()
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun collectData() {
        hit?.id?.let { itemsDetailsViewModel.loadImageDetails(it) }
        viewLifecycleOwner.lifecycleScope.launch {
            itemsDetailsViewModel.imageDetailsFlow.collect { response ->
                when (response) {
                    is Resource.Success -> {
                        response.data?.let { binding?.result = it }
                    }
                    is Resource.Error -> {
                        Toast.makeText(requireContext(), response.message.toString(), Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Loading -> {
                    }
                }
            }
        }
    }
}