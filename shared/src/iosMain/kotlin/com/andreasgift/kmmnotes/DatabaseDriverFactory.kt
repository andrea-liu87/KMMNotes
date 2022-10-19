package com.andreasgift.kmmnotes

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(com.andreasgift.kmmnotes.shared.cache.KmmNotesDB.Companion.Schema, "KmmNotesDB.db")
    }
}