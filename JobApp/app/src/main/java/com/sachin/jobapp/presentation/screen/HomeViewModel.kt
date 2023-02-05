package com.sachin.jobapp.presentation.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sachin.jobapp.data.repository.JobAppRepository
import com.sachin.jobapp.model.JobPost
import com.sachin.jobapp.model.JobPostModalItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val jobAppRepository: JobAppRepository
) : ViewModel() {
    private val _state = MutableStateFlow(emptyList<JobPostModalItem>())
    var errorMessage: String by mutableStateOf("")
    val state: StateFlow<List<JobPostModalItem>>
        get() = _state
    init {

        viewModelScope.launch {
            try {
                val jobPosts = jobAppRepository.getAllPosts()
                _state.value = jobPosts
            }catch (e:Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}