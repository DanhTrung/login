package com.example.quanlychitieu.data

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
val database = Room.databaseBuilder(
    applicationContext,
    AppDatabase::class.java,
    "user_db"
).build()
