package com.example.rommdb.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.rommdb.repositori.RepositoriSiswa

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa: ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
    private set

            private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetailSiswa.itemIdArg])

    init {
        viewModelScope.launch {
            uiStateSiswa = repositoriSiswa.getSiswaStream(idSiswa)
                .filterNotNull()
                .first()
                .toUIStateSiswa(true)
        }
    }