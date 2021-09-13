package com.example.googlesearchnewtechnologies.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googlesearchnewtechnologies.data.common.Result
import com.example.googlesearchnewtechnologies.data.search.GoogleSearchRepositoryImpl
import com.example.googlesearchnewtechnologies.network.services.search.GoogleResponseDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repositoryImpl: GoogleSearchRepositoryImpl,
) : ViewModel() {

    private val _searchLiveData = MutableLiveData<Result<GoogleResponseDto>>()
    val searchLiveData = _searchLiveData
    var debounceJob: Job? = null

    fun search(query: String) {
        debounceJob?.cancel()
        debounceJob = viewModelScope.launch {
            delay(300L)
            repositoryImpl.search(query).collect {
                _searchLiveData.value = it
            }
        }
    }

}