package com.andreasgift.kmmnotes

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(com.andreasgift.kmmnotes.shared.cache.KmmNotesDB.Companion.Schema, context, "KmmNotesDB.db")
    }
}
