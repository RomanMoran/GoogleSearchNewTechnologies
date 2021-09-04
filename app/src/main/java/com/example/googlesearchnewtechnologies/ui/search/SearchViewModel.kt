package com.example.googlesearchnewtechnologies.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googlesearchnewtechnologies.data.common.Result
import com.example.googlesearchnewtechnologies.data.search.GoogleSearchRepositoryImpl
import com.example.googlesearchnewtechnologies.network.services.search.GoogleResponseDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repositoryImpl: GoogleSearchRepositoryImpl
) : ViewModel() {

    private val _searchLiveData = MutableLiveData<Result<GoogleResponseDto>>()
    val searchLiveData = _searchLiveData

    fun search(query: String) {
        viewModelScope.launch {
            repositoryImpl.search(query).collect {
                _searchLiveData.value = it
            }
        }
    }

}