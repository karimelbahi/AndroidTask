package com.karim.task.presentation.ui.mostPopular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.karim.task.R
import com.karim.task.data.api.entity.Status
import com.karim.task.data.entity.PostResult
import com.karim.task.databinding.FragmentPostsListBinding
import com.karim.task.presentation.adapter.PostsAdapter
import com.karim.task.presentation.base.BaseSimpleBindingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MostPopularFragment : Fragment(), BaseSimpleBindingAdapter.OnItemClickListener<PostResult> {
    private val viewModel by viewModels<MostPopularModel>()
    private lateinit var binding: FragmentPostsListBinding
    private val adapter by lazy {
        PostsAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate<FragmentPostsListBinding>(
            inflater,
            R.layout.fragment_posts_list,
            container,
            false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        observeDataChanges()
    }

    private fun observeDataChanges() {
        viewModel.postsData.observe(viewLifecycleOwner, { result ->
            when (result.status.get()) {
                Status.SUCCESS -> result.data?.let {
                    adapter.submitList(result.data as List<PostResult>)
                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), result.msg, Toast.LENGTH_SHORT)
                        .show()
                }
                Status.LOADING -> {
                }
                else -> {
                    Toast.makeText(requireContext(), "else", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }

    override fun onItemClicked(item: PostResult) {
        findNavController().navigate(
            MostPopularFragmentDirections.actionPostsListFragmentToMostPopularDetails(
                item
            )
        )
    }
}