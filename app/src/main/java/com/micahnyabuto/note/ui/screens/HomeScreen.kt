package com.micahnyabuto.note.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.micahnyabuto.note.R
import com.micahnyabuto.note.data.Note
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier

){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    //Text("Notes" )
                    Greeting()
                }
            )
            },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {navController.navigate("entry")
                    
                },
                shape = RoundedCornerShape(70.dp),
                modifier = Modifier
                    .padding(
                        bottom = 16.dp,
                        end = 16.dp
                    )
            ){
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )

            }
        },
    ){ innerPadding ->
        HomeBody(
            noteList = listOf(),
            onNoteClick = {},
            contentPadding = innerPadding,
            modifier = Modifier
                .padding(16.dp)

        )

    }

}


@Composable
private fun HomeBody(
    noteList: List<Note>,
    onNoteClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier

    ) {
        if(noteList.isEmpty()){
            Text(
                text= "OOps you have no notes Tap + to add ",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(16.dp)
            )
        }else{
            NoteList(
                noteList = noteList,
                onNoteClick = { },
                contentPadding = contentPadding,
                modifier = Modifier.weight(10f)
            )

        }

    }
}

@Composable
private fun NoteList(
    noteList: List<Note>,
    onNoteClick: (Note) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
){
    LazyColumn(
        contentPadding = contentPadding,
        modifier = modifier
    ){
        items(noteList.size){note ->
            NoteItem(
                note = noteList[note],
            )
        }
    }

}

@Composable
private fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ){
        Column (
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
            ){
                Text(
                    text = note.content,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = note.content,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }
    }

    }
@Composable
fun Greeting() {
    val greetingText = greetingMessage()


    Text(
        text = greetingText,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
    )

}

fun greetingMessage():String{
    val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

    return when (hour){
        in 0..5 -> "Good Night Welcome back"
        in 6..11 -> "Good Morning Welcome back"
        in 12..17 -> "Good Afternoon Welcome back"
        else -> "Good Evening Welcome back"
    }
}