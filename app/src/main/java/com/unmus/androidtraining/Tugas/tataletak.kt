package com.unmus.androidtraining.Tugas

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.unmus.androidtraining.R
import com.unmus.androidtraining.ui.theme.AndroidTrainingTheme
import android.os.Bundle as AndroidOsBundle


class TataLetakActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: AndroidOsBundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTrainingTheme{
                SearchBar()
            }
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier){
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        placeholder = {
            Text(stringResource(id = R.string.placeholder_search))
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp))
}
