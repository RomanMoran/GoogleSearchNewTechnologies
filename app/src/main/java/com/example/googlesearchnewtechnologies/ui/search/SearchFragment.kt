package com.example.googlesearchnewtechnologies.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.googlesearchnewtechnologies.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchFragment : Fragment() {

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
        /*view.findViewById<View>(R.id.btn_go_detail).setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_searchFragment_to_resultFragment)
        }*/
        viewModel.searchLiveData.observe(viewLifecycleOwner, { it ->
            it.toString()
        })
    }


}