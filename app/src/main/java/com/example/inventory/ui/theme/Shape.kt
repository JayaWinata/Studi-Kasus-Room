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
package com.example.inventory.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/**
 * Pada kode di bawah ini terdapat variable Shapes yang merupakan instance dari kelas Shapes.
 * Pada instance ini terdapat shapes dengan ukuran yang berbebda, seperti extraSmall, small, dan medium.
 * Setiap shape didefinisikan menggunakan CutCornerShape, yang akan membuat shape memiliki cut corner.
 * Custom shapes ini nantinya dapat digunakan sebagai elemen UI seperti Button, Card, dsb. untuk memberikan
 * visual aplikasi yang konsisten
 */
val Shapes = Shapes(

    extraSmall = CutCornerShape(topEnd = 8.dp, bottomStart = 8.dp),
    small = CutCornerShape(topEnd = 8.dp, bottomStart = 8.dp),
    medium = CutCornerShape(topEnd = 16.dp, bottomStart = 16.dp)
)
