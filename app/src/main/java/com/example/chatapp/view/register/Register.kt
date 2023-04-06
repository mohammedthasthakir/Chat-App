package com.example.chatapp.view.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chatapp.view.Appbar
import com.example.chatapp.view.Buttons
import com.example.chatapp.view.TextFormField

import com.example.chatapp.view.register.ui.theme.ChatAppTheme

@Composable
fun RegisterView(
    home: () -> Unit,
    back: () -> Unit,
    login: () -> Unit,
    registerViewModel: RegisterViewModel = viewModel()
) {
    val email: String by registerViewModel.email.observeAsState("")
    val loading: Boolean by registerViewModel.loading.observeAsState(initial = false)
    val password: String by registerViewModel.password.observeAsState("")
    val name: String by registerViewModel.name.observeAsState("")
    val text ="Login"

    Surface(
        color = Color.White
    ) {
        Box{
            Image(painter = painterResource(id = com.example.chatapp.R.drawable.bg_login),
                contentDescription ="bg",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(310.dp))
            Column(
                modifier = Modifier
                    .padding(
                        horizontal = 32.dp, vertical = 40.dp,
                    )
                    .fillMaxSize()
            ) {
                val Purple200 = Color(0xFFBB86FC)
                Image(painter = painterResource(id = com.example.chatapp.R.drawable.app_logo_2),
                    contentDescription ="app_logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(180.dp))
                Spacer(modifier = Modifier.padding(bottom = 70.dp))
                Text(text = "Welcome to", color = Color.White,
                    fontWeight = FontWeight.Black,
                    fontSize = 36.sp
                )
                Text(text = "Chat Connect", color = Purple200 ,
                    fontWeight = FontWeight.Black,
                    fontSize = 36.sp
                )
                Text(text = "Enter the following details and get connected",
                    color = Color.DarkGray,
//                    fontWeight = FontWeight.Black,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.padding(bottom = 50.dp))


//
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(0.dp)
                        .fillMaxSize()
                ) {
                    val Purple200 = Color(0xFFBB86FC)

                    OutlinedTextField(
                        value = name,
                        onValueChange = { registerViewModel.updateName(it) },

                        placeholder = { Text(text = "Full Name") },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                        ),
                        leadingIcon = { Icon(imageVector = Icons.Default.Edit, contentDescription = "emailIcon") },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .fillMaxWidth()

                    )
                    OutlinedTextField(
                        value = email,
                       onValueChange = { registerViewModel.updateEmail(it) },

                        placeholder = { Text(text = "Email") },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                        ),
                        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .fillMaxWidth()

                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = { registerViewModel.updatePassword(it) },
                        placeholder = { Text(text = "Password") },
                        leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "emailIcon") },

                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                        ),
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .fillMaxWidth()

                    )


                    Button( onClick = { registerViewModel.registerUser(home = home) },

                        shape = RoundedCornerShape(percent = 50),
                        modifier = Modifier.border(width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(percent = 50),

                            ),


                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Purple200,
                            contentColor = Color.White)) {
                        Text(text = "Sign Up",
                            modifier = Modifier.padding(horizontal = 40.dp, vertical = 4.dp),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    if (loading) { CircularProgressIndicator()
                    }
                    Row(
                        modifier = Modifier.padding(top = 30.dp)
                    ) {
                        Text(text = "Already have an account? ", color = Color.Black)
                        Text(
                            modifier = Modifier
                                .clickable(enabled = true) {
                                    login()
                                },
                            text = text,
                            color = Purple200,
                        )
                    }

                }
//               }
            }
        }
    }
}