package com.example.googlesearchnewtechnologies.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.googlesearchnewtechnologies.R
import com.example.googlesearchnewtechnologies.data.common.Result
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var searchAdapter = SearchAdapter {
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_searchFragment_to_resultFragment)
    }

    private val viewModel by viewModels<SearchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<EditText>(R.id.etSearch).doAfterTextChanged { query ->
            viewModel.search(query.toString())
        }
        view.findViewById<RecyclerView>(R.id.recyclerview).adapter = searchAdapter
        viewModel.searchLiveData.observe(viewLifecycleOwner, { it ->
            when (it.status) {
                Result.Status.LOADING -> {
                    view.findViewById<View>(R.id.progressBar).isVisible = true
                }
                Result.Status.ERROR -> {
                    view.findViewById<View>(R.id.progressBar).isVisible = false
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                Result.Status.SUCCESS -> {
                    view.findViewById<View>(R.id.progressBar).isVisible = false
                    searchAdapter.items = it.data?.items
                }
            }
        })
    }


}