package com.andreasgift.kmmnotes.android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.andreasgift.kmmnotes.android.theme.Typography
import com.andreasgift.kmmnotes.shared.cache.Note

@Composable
fun HomeScreen(
    notes: List<Note>,
    onNavigateToAdd: () -> Unit
) {
    Column() {
        TextButton(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .align(Alignment.End),
            onClick = { onNavigateToAdd() }) {
            Text(text = "ADD", style = Typography.subtitle1.copy(MaterialTheme.colors.secondary))
        }
        Text(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 26.dp)
                .align(Alignment.CenterHorizontally),
            text = "Notes",
            style = Typography.h6
        )
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(items = notes, itemContent = { item ->
                NoteRecyclerView(note = item)
            })
        }
    }
}

@Composable
fun NoteRecyclerView(note: Note) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 12.dp)) {
        Text(note.title, style = Typography.subtitle1)
        Text(note.body, style = Typography.subtitle1)
        Divider(thickness = 1.dp, color = MaterialTheme.colors.secondary)
    }
}