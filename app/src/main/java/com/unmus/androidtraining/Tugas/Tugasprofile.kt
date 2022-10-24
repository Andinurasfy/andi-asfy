package com.unmus.androidtraining.Tugas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.unmus.androidtraining.R
import androidx.compose.ui.unit.dp
import com.unmus.androidtraining.ui.theme.AndroidTrainingTheme
import com.unmus.androidtraining.ui.theme.Purple200

class Tugasprofile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidTrainingTheme{
                Surface(modifier = Modifier.fillMaxSize()) {
                    val user = User("Unmus", "Papua", 20)
                    MenampilkanPesan(user)
                }
            }
        }
    }
}

data class User(
    val name: String,
    val address: String,
    val umur: Int
)

@Composable
fun MenampilkanPesan(user: User){
    Row(
        modifier = Modifier.padding(all = 8.dp)
    ) {
        Image(painter =
        painterResource(id = R.drawable.musamus),
            contentDescription = "musamus",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape),
            contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = user.name, color = Purple200)
            Spacer(modifier = Modifier.height(8.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 2.dp) {
                Text(
                    text = user.address,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewMenampilkanPesan(){
    val user = User("Unmus", "Papua", 20)
    MenampilkanPesan(user)
}


@Composable
fun Conversation(users: List<User>) {
    LazyRow {
        items(users) { user ->
            MenampilkanPesan(user = user)
        }
    }
}