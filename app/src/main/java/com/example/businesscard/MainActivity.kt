package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserInterface(
                        name = "Irfan Rafi",
                        title = "Android Developer",
                        phoneNumber = 9251252,
                        sosialMedia = "@instagram.com",
                        emailId = "user@gmail.com"
                    )
                }
            }
        }
    }
}

@Composable
fun UserInterface(name: String, title: String , phoneNumber: Int , sosialMedia: String , emailId: String , modifier: Modifier = Modifier) {
    Header(name = name, title = title)
    SosialMedia(phoneNumber = 215152521, sosialMedia = "@instagram.com", emailId = "user@gmail.com")
}

@Composable
fun Header(name: String, title : String , modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(30.dp),
    )
    {
        BackgroundImage()

        Text(
            text = "$name",
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "$title",
            fontSize = 23.sp,
            color = Color(0xFF3ddc84),
            modifier = modifier
                .padding(5.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun SosialMedia(phoneNumber : Int , sosialMedia : String , emailId : String , modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(40.dp)
    ) {
        LazyColumn {
            item {
                Row {
                    Icon(
                        Icons.Rounded.Phone, contentDescription = null , modifier = modifier.padding(2.dp))
                    Text(
                        text = "+$phoneNumber",
                        textAlign = TextAlign.Center,
                        modifier = modifier
                            .padding(4.dp)
                    )
                }
            }
            item {
                Row {
                    Icon(Icons.Rounded.Share, contentDescription = null , modifier = modifier.padding(2.dp))
                    Text(
                        text = "$sosialMedia",
                        modifier = modifier
                            .padding(4.dp)
                    )
                }
            }

            item {
                Row {
                    Icon(Icons.Rounded.Email, contentDescription = null, modifier = modifier.padding(2.dp))
                    Text(
                        text = "$emailId",
                        modifier = modifier
                            .padding(4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun BackgroundImage(modifier: Modifier = Modifier){
    val androidImage = painterResource(R.drawable.android_logo)

    Column (
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = androidImage,
            contentDescription = null,
            modifier = modifier
                .background(Color(10, 17, 41))
                .size(140.dp)
                .clip(CircleShape)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Header(
            stringResource(R.string.android_text),
            stringResource(R.string.title_text)
        )
    }
}