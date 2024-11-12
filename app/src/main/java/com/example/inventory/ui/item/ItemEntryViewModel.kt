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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.inventory.data.Item
import com.example.inventory.data.ItemsRepository
import java.text.NumberFormat

/**
 * ViewModel to validate and insert items in the Room database.
 */
/**
 * Kelas ini digunakan untuk mengatur state dan logic untuk menambahkan item baru ke dalam inventory.
 * Kelas ini menyimpan state saat ini pada item yang akan ditambahkan di dalam properti itemUiState.
 * Kemudian fungsi updateUiState digunakan untuk mengupdate itemUiState dengan detail item yang baru dan untuk mem-validasi input
 * Kemudian fungsi saveItem digunakan untuk mem-validasi input dan kemudian menambahkan item yang baru ke dapat repository jika detail-nya valid.
 * Fungsi validateInput digunakan untuk memeriksa apakah semua field sudah terisi.
 */
class ItemEntryViewModel(private val itemsRepository: ItemsRepository) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var itemUiState by mutableStateOf(ItemUiState())
        private set

    /**
     * Updates the [itemUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(itemDetails: ItemDetails) {
        itemUiState =
            ItemUiState(itemDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }

    suspend fun saveItem() {
        if (validateInput()) {
            itemsRepository.insertItem(itemUiState.itemDetails.toItem())
        }
    }

    private fun validateInput(uiState: ItemDetails = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }
}

/**
 * Represents Ui State for an Item.
 */
/**
 * Data class ini merepresentasikan state pada item yang akan ditambahkan / diedit di dalam aplikasi ini.
 * Data class ini memiliki dua properti, itemDetails dan isEntryValid.
 * itemDetails digunakan untuk menyimpan detail spesifik dari item yang akan ditambahkan / diedit.
 * dan isEntryValid digunakan untuk memeriksa apakah semua field sudah terisi.
 * Data class ini digunakan untuk mengatur UI state dan mengaktifkan validasi pada user input sebelum menyimpan item yang akan ditambahkan / diedit.
 */
data class ItemUiState(
    val itemDetails: ItemDetails = ItemDetails(),
    val isEntryValid: Boolean = false
)

/**
 * Data class ini merepresentasikan detail dari satu item di dalam inventory.
 * Data class ini mengandung empat properti, yaitu id (primary key), nama item, harga item, dan kuantitas.
 * Data class ini digunakan untuk menyimpan dan mengatur informasi tentang setiap item di dalam sistem inventory ini.
 */
data class ItemDetails(
    val id: Int = 0,
    val name: String = "",
    val price: String = "",
    val quantity: String = "",
)

/**
 * Extension function to convert [ItemDetails] to [Item]. If the value of [ItemDetails.price] is
 * not a valid [Double], then the price will be set to 0.0. Similarly if the value of
 * [ItemDetails.quantity] is not a valid [Int], then the quantity will be set to 0
 */
/**
 * Extension function ini digunakan untuk mengkonversi data dari ItemDetails ke Item.
 * Fungsi ini meng-copy properti id dan name secara langsung.
 * Namun, properti price dan quantity akan dikonversi dari nilai string ke double dan int.
 * Jika konversi gagal, maka nilai properti tersebut akan diatur ke nilai default (yaitu 0).
 * Konversi ini digunakan untuk berinteraksi dengan database yang membutuhkan objek Item.
 */
fun ItemDetails.toItem(): Item = Item(
    id = id,
    name = name,
    price = price.toDoubleOrNull() ?: 0.0,
    quantity = quantity.toIntOrNull() ?: 0
)

/**
 * Extension function ini digunakan untuk mengkonversi / mem-format properti harga pada suatu item kedalam bentuk mata uang.
 * NumberFormat.getCurrencyInstance digunakan untuk mendapatkan format mata uang yang sesuai dengan mata uang lokal.
 * Kemudian fungsi format digunakan untuk melakukan format pada harga yang awalnya bertipe Double menjadi bentuk mata uang.
 * Fungsi ini membantu untuk menampilkan harga item dengan format mata uang yang sesuai.
 */
fun Item.formatedPrice(): String {
    return NumberFormat.getCurrencyInstance().format(price)
}

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
/**
 * Extension function ini digunakan untuk mengkonversi Item menjadi ItemUiState.
 * Fungsi ini menerima parameter isEntryValid yang bersifat opsional dengan nilai default false.
 * Fungsi ini akan membuat instance ItemUiState baru dengan mengisi properti itemDetails dengan hasil konversi dari fungsi toItemDetails().
 */
fun Item.toItemUiState(isEntryValid: Boolean = false): ItemUiState = ItemUiState(
    itemDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
/**
 * Extension function ini digunakan untuk mengkonversi Item menjadi objek ItemDetails.
 * Fungsi ini meng-copy id dan name secara langsung. Dan properti price dan quantity akan dikonversi dari nilai numerik menjadi strings
 *
 */
fun Item.toItemDetails(): ItemDetails = ItemDetails(
    id = id,
    name = name,
    price = price.toString(),
    quantity = quantity.toString()
)
