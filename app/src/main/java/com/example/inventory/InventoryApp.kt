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

@file:OptIn(ExperimentalMaterial3Api::class)

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
 * Composable tingkat atas yang merepresentasikan layar aplikasi.
 */
@Composable
fun InventoryApp(navController: NavHostController = rememberNavController()) {
    InventoryNavHost(navController = navController) // Mengatur navigasi utama aplikasi
}

/**
 * App bar untuk menampilkan judul dan secara opsional menampilkan navigasi kembali.
 */
@Composable
fun InventoryTopAppBar(
    title: String, // Judul yang akan ditampilkan di AppBar
    canNavigateBack: Boolean, // Menentukan apakah tombol kembali ditampilkan
    modifier: Modifier = Modifier, // Modifier untuk penyesuaian AppBar
    scrollBehavior: TopAppBarScrollBehavior? = null, // Menentukan perilaku scroll AppBar
    navigateUp: () -> Unit = {} // Fungsi yang akan dipanggil saat tombol kembali diklik
) {
    CenterAlignedTopAppBar(
        title = { Text(title) }, // Menampilkan judul di tengah AppBar
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) { // Menampilkan ikon kembali jika canNavigateBack bernilai true
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Filled.ArrowBack, // Menggunakan ikon panah kembali
                        contentDescription = stringResource(string.back_button) // Deskripsi konten untuk ikon
                    )
                }
            }
        }
    )
}
