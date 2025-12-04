package com.example.rommdb.view.route

import com.example.rommdb.R

object DestinasiEditSiswa {
    object DestinasiEditSiswa : DestinasiNavigasi {
        override val route = "item_edit"
        override val titleRes = R.string.edit_siswa
        const val itemIdArg = "idSiswa"
        val routeWithArgs = "$route/{$itemIdArg}"
    }
}