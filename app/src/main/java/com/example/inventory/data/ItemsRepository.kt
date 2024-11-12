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

package com.example.inventory.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 *
 */
/**
 *  Interface ini merupakan kumpulan method yang harus digunakan pada kelas yang mengimplementasikan interface ItemsRepository ini.
 *  Pada interface ini, terdapat beberapa method yang harus diimplementasikan oleh kelas yang mengimplementasikannya, yaitu:
 *  1. getAllItemsStream: digunakan untuk mengambil semua items / data dari database room
 *  2. getItemStrem: digunakan untuk memperoleh item spesific berdasarkan id yang dimasukkan ke dalam parameter
 *  3. insertItem: digunakan untuk menambahkan item ke dalam database room. Method ini merupakan suspend function, sehingga penggunaannya berkaitan dengan coroutine
 *  4. deleteItem: digunakan untuk menghapus item di dalam database room. Method ini merupakan suspend function, sehingga penggunaannya berkaitan dengan coroutine
 *  5. updateItem: digunakan untuk meng-update item yang sudah ada di dalam database room. Method ini merupakan suspend function, sehingga penggunaannya berkaitan dengan coroutine
 *
 */
interface ItemsRepository {
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllItemsStream(): Flow<List<Item>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getItemStream(id: Int): Flow<Item?>

    /**
     * Insert item in the data source
     */
    suspend fun insertItem(item: Item)

    /**
     * Delete item from the data source
     */
    suspend fun deleteItem(item: Item)

    /**
     * Update item in the data source
     */
    suspend fun updateItem(item: Item)
}

