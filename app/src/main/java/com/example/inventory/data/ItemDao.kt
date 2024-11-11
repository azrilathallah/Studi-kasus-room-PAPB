package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao // Menandakan bahwa interface ini adalah Data Access Object (DAO) untuk entitas Item
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE) // Menyisipkan data dengan strategi abaikan jika terjadi konflik
    suspend fun insert(item: Item) // Fungsi untuk menambahkan item ke dalam database

    @Update // Mengupdate data yang sudah ada di database
    suspend fun update(item: Item) // Fungsi untuk mengupdate data item di database

    @Delete // Menghapus data dari database
    suspend fun delete(item: Item) // Fungsi untuk menghapus item dari database

    @Query("SELECT * from items WHERE id = :id") // Query untuk mendapatkan item berdasarkan ID
    fun getItem(id: Int): Flow<Item> // Fungsi untuk mengambil item spesifik dalam bentuk Flow (reaktif)

    @Query("SELECT * from items ORDER BY name ASC") // Query untuk mendapatkan semua item yang diurutkan berdasarkan nama secara ascending
    fun getAllItems(): Flow<List<Item>> // Fungsi untuk mengambil semua item dalam bentuk Flow (reaktif)
}