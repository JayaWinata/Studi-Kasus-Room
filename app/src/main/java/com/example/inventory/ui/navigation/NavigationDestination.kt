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

package com.example.inventory.ui.navigation

/**
 * Interface to describe the navigation destinations for the app
 */
/**
 *
 */
interface NavigationDestination {
    /**
     * Unique name to define the path for a composable
     */
    /**
     * Properti ini merepresentasikan path yang digunakan untuk mengidentifikasi destinasi spesifik
     * Properti ini sangat krusial untuk melakukan navigasi pada halaman yang benar menggunakan NavController dalam Jetpack Compose.
     */
    val route: String

    /**
     * String resource id to that contains title to be displayed for the screen.
     */
    /**
     * Properti ini merepresentasikan Resource ID dari string yang berisi judul yang akan ditampilkan pada top bar pada aplikasi ini.
     */
    val titleRes: Int
}
