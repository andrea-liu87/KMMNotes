package com.andreasgift.kmmnotes.android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.andreasgift.kmmnotes.android.theme.MyApplicationTheme
import com.andreasgift.kmmnotes.shared.cache.Note

@Composable
fun AddScreen(
    saveNote: (note: Note) -> Unit
) {
    var title by remember {
        mutableStateOf("")
    }

    var body by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            label = {Text("Note Title")},
            value = title,
            onValueChange = { title = it })
        TextField(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
            label = {Text("Note Body")},
            value = body,
            onValueChange = { body = it })
        Button(
            modifier = Modifier.padding(vertical = 20.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary
            ),
            onClick = {
            saveNote(Note(0, title = title, body = body, timestamp = "0"))
        }) {
            Text("ADD", color = MaterialTheme.colors.onSecondary)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AddPreview() {
    MyApplicationTheme {
        AddScreen(saveNote = {})
    }
}