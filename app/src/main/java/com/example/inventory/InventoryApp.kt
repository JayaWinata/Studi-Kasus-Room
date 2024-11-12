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

package com.example.inventory

import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inventory.R.string
import com.example.inventory.ui.navigation.InventoryNavHost

/**
 * Top level composable that represents screens for the application.
 */

/**
 * Composable ini menerima parameter navController dengan tipe kelas NavHostController yang digunakan untuk melakukan navigasi antar layar / composable dalam aplikasi.
 * Nilai default dari parameter ini adalah rememberNavController().
 * Di dalam composable ini terdapat InventoryNavHost yang digunakan untuk menentukan navigasi antar layar / composable dalam aplikasi.
 * Pada dasarnya, composable InventoryApp akan menginisialisasi atau meneriman NavHostController. Kemudian NavHostController teresbut akan dimasukkan pada parameter InventoryNavHost.
 * Dan InventoryNavHost ini akan berperan dalam mengatur navigasi antara layar- layar yang berbeda di dalam aplikasi ini.
 * Sehingga dapat dikatakan bahwa composable ini merupakan entry point dari aplikasi ini
 */
@Composable
fun InventoryApp(navController: NavHostController = rememberNavController()) {
    InventoryNavHost(navController = navController)
}

/**
 * App bar to display title and conditionally display the back navigation.
 */
/**
 * Composable ini berperan sebagai tampilan top app bar dalam aplikasi ini.
 * Beberapa hal yang dilakukan pada composable ini adalah menampilkan judul (title) aplikasi,
 * dan terdapat sebuah tombol back yang digunakan untuk kembali ke layar sebelumnya.
 * Namun tombol back ini hanya akan muncul jika nilai canNavigateBack bernilai true.
 * Selain itu, composable ini menerima parameter modifier, sehingga pengguna dapat melakukan modifikasi styling dan layout
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    CenterAlignedTopAppBar(title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Filled.ArrowBack,
                        contentDescription = stringResource(string.back_button)
                    )
                }
            }
        })
}
