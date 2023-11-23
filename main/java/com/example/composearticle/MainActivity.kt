package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeBackground(title = stringResource(R.string.compose_title), 
                        descrip = stringResource(R.string.compose_descrip),
                        para = stringResource(R.string.compose_para))
                }
            }
        }
    }
}

@Composable
fun ComposeText(title: String, descrip: String, para: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = descrip,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify

        )
        Text(
            text = para,
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun ComposeBackground(title: String, descrip: String, para: String,modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)

    Column(modifier = modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        ComposeText(
            title = title,
            descrip = descrip,
            para = para,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeArticlePreview() {
    ComposeArticleTheme {
        ComposeBackground(title = stringResource(R.string.compose_title),
            descrip = stringResource(R.string.compose_descrip),
            para = stringResource(R.string.compose_para))
    }
}