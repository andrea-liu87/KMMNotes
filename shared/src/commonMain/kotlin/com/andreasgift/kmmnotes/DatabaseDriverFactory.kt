package com.andreasgift.kmmnotes

import com.andreasgift.kmmnotes.shared.cache.KmmNotesDB
import com.andreasgift.kmmnotes.shared.cache.Note
import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = KmmNotesDB(databaseDriverFactory.createDriver())
    private val dbQuery = database.tableQueries

    internal fun getAllNotes(): List<Note> {
        return dbQuery.selectAllNotes().executeAsList()
    }

    internal fun getNoteByTitle(title: String): Note {
        return dbQuery.selectByTitle(title).executeAsOne()
    }

    internal fun insertNote(title: String, body: String?) {
        return dbQuery.insertNote(title, body ?: " ", "0")
    }

    internal fun deleteAll() {
        return dbQuery.deleteAll()
    }

    internal fun deleteByTitle(title: String){
        return dbQuery.deleteByTitle(title)
    }
}
