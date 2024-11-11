package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Kelas Database dengan objek Instance singleton.
 */
@Database(entities = [Item::class], version = 1, exportSchema = false) // Mendefinisikan database dengan entitas Item dan versi 1
abstract class InventoryDatabase : RoomDatabase() {

    // Mendeklarasikan fungsi itemDao() untuk mengakses DAO dari tabel Item
    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile // Menandai Instance sebagai volatile untuk memastikan visibilitas antar-thread
        private var Instance: InventoryDatabase? = null // Variabel untuk menyimpan instance singleton dari database

        fun getDatabase(context: Context): InventoryDatabase {
            // Jika Instance tidak null, maka kembalikan; jika null, buat instance baru secara sinkron
            return Instance ?: synchronized(this) {
                // Membuat database Room baru dengan nama "item_database" jika belum ada
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .build()
                    .also { Instance = it } // Menyimpan instance ke variabel Instance
            }
        }
    }
}