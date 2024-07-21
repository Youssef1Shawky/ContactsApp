package com.example.contactsapp

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsApp(modifier: Modifier = Modifier, persons: List<Person>) {
    Scaffold(

            topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text("Contacts App")
                },
                actions = {
                    val context = LocalContext.current
                    IconButton(onClick = {



                        val i = Intent(Intent.ACTION_DIAL , "tel:01288593098".toUri())
                        context.startActivity(i)

                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_home_24),
                            contentDescription = "dialing home "
                        )

                    }
                }
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(modifier = modifier.padding(innerPadding),
            columns = GridCells.Fixed(3),
            content =
            {

                items(persons){
                    ListItem(person = it)
                }


            }


        )
    }
}

@Composable
fun ListItem(person: Person, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = person.picture), contentDescription = person.name ,

            modifier = modifier.clickable {

                val i = Intent(Intent.ACTION_DIAL , "tel:${person.phoneNo}".toUri())
                context.startActivity(i)

            }
            )
        Text(text = person.name, fontSize = 22.sp)

        SelectionContainer {
            Text(text = person.phoneNo, fontSize = 12.sp, color = Color.Gray)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContactsAppPreview() {


    ContactsApp(persons = DataSource().getData())
}
