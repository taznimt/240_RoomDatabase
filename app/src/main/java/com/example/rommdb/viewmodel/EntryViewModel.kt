package com.example.rommdb.viewmodel

import androidx.lifecycle.ViewModel
import com.example.rommdb.room.Siswa

class EntryViewModel(private val repositoriSiswa: RepositoriSiswa): ViewModel() {

    /**
     * Berisi status Siswa saat ini
     */
    var uiStateSiswa by mutableStateOf(value = UIStateSiswa())
        private set

    /**
     * Fungsi untuk memvalidasi input
     */
    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(receiver = uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa = UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(uiState = detailSiswa))
    }

    /**
     * Fungsi untuk menyimpan data yang di-entry
     */
    suspend fun saveSiswa() {
        if (validasiInput()) {
            repositoriSiswa.insertSiswa(siswa = uiStateSiswa.detailSiswa.toSiswa())
        }
    }
}

/**
 * Mewakili Status Ui untuk Siswa
 */
data class UIStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val isEntryValid: Boolean = false
)

data class DetailSiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = ""
)

/**
 * Fungsi untuk mengkonversi data input ke data dalam tabel sesuai jenis datanya
 */
fun DetailSiswa.toSiswa(): Siswa = Siswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)

fun Siswa.toUIStateSiswa(isEntryValid: Boolean = false): UIStateSiswa = UIStateSiswa(
    detailSiswa = this.toDetailSiswa(),
    isEntryValid = isEntryValid
)

fun Siswa.toDetailSiswa(): DetailSiswa = DetailSiswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)