package com.jetpack.compose.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetpack.compose.domain.utils.Result
import com.jetpack.compose.domain.usecase.GetCatUseCase
import com.jetpack.compose.domain.usecase.GetDogUseCase
import com.jetpack.compose.domain.usecase.GetRabbitUseCase
import com.jetpack.compose.presentation.mapper.AnimalUIMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dogUseCase: GetDogUseCase,
    private val catUseCase: GetCatUseCase,
    private val rabbitUseCase: GetRabbitUseCase
) : ViewModel() {

    init {
        getDogList()
        getCatList()
        getRabbitList()
    }

    private val _dogState: MutableStateFlow<AnimalState> = MutableStateFlow(AnimalState())
    val dogState: StateFlow<AnimalState> = _dogState

    private fun getDogList() {
        viewModelScope.launch {
            dogUseCase.invoke().collect { result ->
                when (result) {
                    is Result.Loading -> {
                        _dogState.value = dogState.value.copy(
                            isLoading = true
                        )
                    }
                    is Result.Success -> {
                        _dogState.value = result.data?.let {
                            dogState.value.copy(
                                animals = AnimalUIMapper().toUI(it),
                                isLoading = false
                            )
                        }
                    }
                    is Result.Error -> {
                        _dogState.value = dogState.value.copy(
                            error = result.error,
                            isLoading = false
                        )
                    }
                }
            }
        }

    }

    private val _catState: MutableStateFlow<AnimalState> = MutableStateFlow(AnimalState())
    val catState: StateFlow<AnimalState> = _catState

    private fun getCatList() {
        viewModelScope.launch {
            catUseCase.invoke().collect { result ->
                when (result) {
                    is Result.Loading -> {
                        _catState.value = catState.value.copy(
                            isLoading = true
                        )
                    }
                    is Result.Success -> {
                        _catState.value = result.data?.let {
                            catState.value.copy(
                                animals = AnimalUIMapper().toUI(it),
                                isLoading = false
                            )
                        }
                    }
                    is Result.Error -> {
                        _catState.value = catState.value.copy(
                            error = result.error,
                            isLoading = false
                        )
                    }
                }
            }

        }
    }

    private val _rabbitState: MutableStateFlow<AnimalState> = MutableStateFlow(AnimalState())
    val rabbitState: StateFlow<AnimalState> = _rabbitState

    private fun getRabbitList() {
        viewModelScope.launch {
            rabbitUseCase.invoke().collect { result ->
                when (result) {
                    is Result.Loading -> {
                        _rabbitState.value = rabbitState.value.copy(
                            isLoading = true
                        )
                    }
                    is Result.Success -> {
                        _rabbitState.value = result.data?.let {
                            rabbitState.value.copy(
                                animals = AnimalUIMapper().toUI(it),
                                isLoading = false
                            )
                        }
                    }
                    is Result.Error -> {
                        _rabbitState.value = rabbitState.value.copy(
                            error = result.error,
                            isLoading = false
                        )
                    }
                }
            }
        }
    }

    fun refresh() {
        getDogList()
        getCatList()
        getRabbitList()
    }
}