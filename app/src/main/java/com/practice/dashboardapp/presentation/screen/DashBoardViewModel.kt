package com.practice.dashboardapp.presentation.screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.practice.dashboardapp.data.remote.dto.DashboardResponse
import com.practice.dashboardapp.domain.model.DashBoardScreenData
import com.practice.dashboardapp.domain.repo.DashBoardRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashBoardViewModel @Inject constructor(
    private val repository: DashBoardRepo,
) : ViewModel() {

    private var _response = MutableStateFlow<DashBoardScreenData?>(null)
    val response = _response.asStateFlow()


    init {
        getDashboardResponse()
    }


    private fun getDashboardResponse() {
        viewModelScope.launch {
            try {
                _response.emit(repository.getAllDashboardData())
                Log.d("Izaz", "value emitted")
                Log.d("Izaz", "$response")
            } catch (e: Exception) {
                Log.d("Izaz", "$e")
            }
        }

    }
}