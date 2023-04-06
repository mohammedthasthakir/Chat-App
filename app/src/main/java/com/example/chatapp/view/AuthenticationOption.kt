package com.example.chatapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp.view.ui.theme.ChatAppTheme
@Composable
fun AuthenticationView(register: () -> Unit, login: () -> Unit) {
    ChatAppTheme {
        // A surface container using the 'background' color from the theme
//        Surface(color = MaterialTheme.colors.background) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Bottom
//            ) {
//                Title(title = "⚡️ Chat Connect")
//                Buttons(title = "Register", onClick = register, backgroundColor = Color.Blue)
//                Buttons(title = "Login", onClick = login, backgroundColor = Color.Magenta)
//            }
//        }

        Surface(
            color = Color.White
        ) {
            Box {
                Image(painter = painterResource(id = com.example.chatapp.R.drawable.bg_login),
                    contentDescription ="bg", modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop)
                Column(
                    modifier = Modifier
                        .padding(
                            horizontal = 32.dp, vertical = 80.dp
                        )
                        .fillMaxSize()
                ) {
                    Text(text = "Welcome to Chat Connect", color = Color.White,
                        fontWeight = FontWeight.Black,
                        fontSize = 36.sp
                    )
                    Spacer(modifier = Modifier.fillMaxHeight(0.63f))
                    Card(
                        elevation = 4.dp,
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = Color.White.copy(0.1f),
                                shape = RoundedCornerShape(27.dp)
                            )
                            .clip(RoundedCornerShape(27.dp))
                    ) {
                        Image(
                            painter = painterResource(id = com.example.chatapp.R.drawable.bg_login),
                            contentDescription ="Card_Bg" ,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(27.dp)
                                .fillMaxSize()
                        ) {
                            Text(
                                text = "ChatConnect ",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            )
                            Text(text = "A Real-Time Chat and Communication App",
                                color = Color.White.copy(0.8f),
                                textAlign = TextAlign.Center

                            )
                            Spacer(modifier = Modifier.padding(bottom = 27.dp))
                            Button(onClick = login, shape = RoundedCornerShape(percent = 50),
                                modifier = Modifier.border(width = 1.dp,
                                    color = Color.White.copy(0.5f),
                                    shape = RoundedCornerShape(percent = 50)
                                ), colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color(151,169,246, alpha = 0x32),
                                    contentColor = Color.White)) {
                                Text(text = "Get Started Now", modifier = Modifier.padding(horizontal = 40.dp, vertical = 4.dp),
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }
                    }
                }
            }

    }

}





}