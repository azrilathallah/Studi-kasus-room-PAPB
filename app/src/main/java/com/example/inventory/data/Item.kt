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

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Kelas data Entity yang mewakili satu baris dalam database.
 */
@Entity(tableName = "items") // Mendefinisikan bahwa kelas ini adalah Entity dalam database dengan nama tabel "items"
class Item(
    @PrimaryKey(autoGenerate = true) // Menandai id sebagai Primary Key dan mengatur agar ID dihasilkan secara otomatis
    val id: Int = 0, // Mendefinisikan atribut id dengan tipe Int dan nilai default 0
    val name: String, // Mendefinisikan atribut name dengan tipe String
    val price: Double, // Mendefinisikan atribut price dengan tipe Double
    val quantity: Int // Mendefinisikan atribut quantity dengan tipe Int
)
