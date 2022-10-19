package com.andreasgift.kmmnotes

import com.andreasgift.kmmnotes.shared.cache.Note

class KmmSdk(dbDriverFactory: DatabaseDriverFactory) {
    private val database: Database = Database(dbDriverFactory)

    fun getAllNotes(): List<Note> {
        return database.getAllNotes()
    }

    fun getNoteByTitle(title: String): Note {
        return database.getNoteByTitle(title)
    }

    fun insertNote(title: String, body: String?) {
        database.insertNote(title, body)
    }

    fun deleteAll() {
        database.deleteAll()
    }

    fun deleteByTitle(title: String) {
        database.deleteByTitle(title)
    }
}