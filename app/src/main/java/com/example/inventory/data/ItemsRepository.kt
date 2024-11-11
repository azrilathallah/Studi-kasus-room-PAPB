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
 * Repository yang menyediakan fungsi untuk menambahkan, memperbarui, menghapus, dan mengambil [Item] dari sumber data.
 */
interface ItemsRepository {
    /**
     * Mengambil semua item dari sumber data.
     */
    fun getAllItemsStream(): Flow<List<Item>> // Mengembalikan aliran data (Flow) berisi daftar semua item

    /**
     * Mengambil item dari sumber data yang sesuai dengan [id].
     */
    fun getItemStream(id: Int): Flow<Item?> // Mengembalikan aliran data (Flow) berisi item yang sesuai dengan id, atau null jika tidak ditemukan

    /**
     * Menambahkan item ke sumber data.
     */
    suspend fun insertItem(item: Item) // Fungsi asinkron untuk menyisipkan item ke dalam sumber data

    /**
     * Menghapus item dari sumber data.
     */
    suspend fun deleteItem(item: Item) // Fungsi asinkron untuk menghapus item dari sumber data

    /**
     * Memperbarui item di sumber data.
     */
    suspend fun updateItem(item: Item) // Fungsi asinkron untuk memperbarui item yang ada di dalam sumber data
}