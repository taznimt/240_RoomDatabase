package com.example.rommdb.viewmodel.provider

import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.rommdb.repositori.AplikasiSiswa
import com.example.rommdb.viewmodel.EntryViewModel
import com.example.rommdb.viewmodel.HomeViewModel
import com.google.android.ads.mediationtestsuite.viewmodels.ViewModelFactory

object PenyediaViewModel : ViewModelFactory {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa
            )
        }

        initializer {
            EntryViewModel(
                repositoriSiswa = aplikasiSiswa().container.repositoriSiswa
            )
        }
    }

    /**
     * Fungsi eksternal query untuk objek [Application] dan mengonversi/menyusun instance dari
     * @aplikasiSiswa.
     */
    fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)
}
