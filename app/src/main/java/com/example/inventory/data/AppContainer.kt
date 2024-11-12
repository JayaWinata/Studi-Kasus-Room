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

import android.content.Context

/**
 * App container for Dependency injection.
 */
/**
 * Interface ini mendefinisikan sebuah contract untuk kelas- kelas lain di dalam aplikasi.
 * Interface ini memiliki satu property bernama itemRepository dengan tipe ItemsRepository.
 * Ini berarti setiap kelas yang mengimplementasikan AppContainer harus menyediakan sebuah instance itemsRepository.
 * Implementasi dari AppContainer ini akan menngguakan OfflineItemRepository untuk memenuhi dependecy pada itemsRepository
 */
interface AppContainer {
    val itemsRepository: ItemsRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
/**
 * Kelas ini mengimplementasikan AppContainer dan menyediakan instance dari OfflineItemsRepository.
 * Kelas ini juga menyediakan instance dari InventoryDatabase.
 * Kelas ini dibuat untuk menyimpan dan menyediakan akses untuk data repositories yang digunakan pada aplikasi ini.
 * Dengan memiliki sebuah containser yang terpusat seperti kelas AppDataContainer, kita dapat dengan mudah mengakses repositories yang berbeda dari berbagai bagian dari aplikasi ini.
 * Lazy initialization pada kelas ini memebantu untuk meningkatkan performa karena lazy initialization hanya membuat objek pada saat dibutuhkan saja.
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ItemsRepository]
     */
    override val itemsRepository: ItemsRepository by lazy {
        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
    }
}
