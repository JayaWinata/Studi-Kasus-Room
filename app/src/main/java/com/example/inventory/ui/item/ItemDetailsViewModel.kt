/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.ui.item

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.inventory.data.ItemsRepository

/**
 * ViewModel to retrieve, update and delete an item from the [ItemsRepository]'s data source.
 */
/**
 * Kelas ini bertanggung jawab untuk mengatur state dan data yang berhubungan dengan ItemDetailsScreen.
 * Kelas ini menerima SavedStateHandle sebagai parameter untuk memulihkan item ID saat terjadi perubahan konfigurasi.
 * Nilai itemID dihasilkan oleh SavedStateHandle dan akan disimpan sebagai properti yang bersifat private.
 * Konstanta TIMEOUT_MILLIS digunakan untuk menspesifikasikan nilai timeout, yang dapat digunakan untuk operasi pada network atau tugas- tugas lainnya
 * di dalam ViewModel
 */
class ItemDetailsViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val itemId: Int = checkNotNull(savedStateHandle[ItemDetailsDestination.itemIdArg])

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * UI state for ItemDetailsScreen
 */
/**
 * Data Class ini merepresentasikan UI state untuk sebuah item di dalam ItemDetailsScreen.
 * Data class ini memiliki dua properti, yaitu outOfStock dan itemDetails.
 * Properti outOfStock akan menentukan apakah item tersebut sedang out of stock atau tidak.
 * Sedangkan properti itemDetails akan berisi objek ItemDetails yang merepresentasikan detail dari item tersebut.
 */
data class ItemDetailsUiState(
    val outOfStock: Boolean = true,
    val itemDetails: ItemDetails = ItemDetails()
)
