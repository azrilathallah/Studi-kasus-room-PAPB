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
 * App container untuk Dependency Injection.
 */
interface AppContainer {
    val itemsRepository: ItemsRepository // Mendeklarasikan variabel itemsRepository yang akan diimplementasikan oleh kelas turunan
}

/**
 * Implementasi [AppContainer] yang menyediakan instance dari [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementasi untuk [ItemsRepository]
     */
    override val itemsRepository: ItemsRepository by lazy {
        // Inisialisasi itemsRepository menggunakan OfflineItemsRepository
        // Mengambil instance dari InventoryDatabase dan mengakses itemDao untuk manipulasi data
        OfflineItemsRepository(InventoryDatabase.getDatabase(context).itemDao())
    }
}