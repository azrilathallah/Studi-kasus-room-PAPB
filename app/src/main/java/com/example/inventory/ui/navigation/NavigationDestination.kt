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
 * Interface untuk mendeskripsikan tujuan navigasi dalam aplikasi
 */
interface NavigationDestination {
    /**
     * Nama unik yang mendefinisikan path untuk sebuah composable
     */
    val route: String

    /**
     * ID resource string yang berisi judul yang akan ditampilkan untuk layar.
     */
    val titleRes: Int
}
