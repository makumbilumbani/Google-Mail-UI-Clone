package com.example.googlemailuiclone.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.googlemailuiclone.R
import com.example.googlemailuiclone.ui.theme.GoogleMailUICloneTheme

@Composable
fun AccountsDialog(openDialog : MutableState<Boolean>){
    Dialog(onDismissRequest = { openDialog.value = false}) {
        AccountsDialogScreen()
    }
}
@Composable
fun AccountsDialogScreen(modifier: Modifier = Modifier){
    Card(){
        Column(
            modifier
                .background(Color.White)
                .padding(bottom = 16.dp)){
            Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                IconButton(onClick = {
//                    AccountsDialog(openDialog = false)
                }){
                    Icon(imageVector = Icons.Default.Close, contentDescription = null)
                }
                Image(
                    painter = painterResource(id = R.drawable.google_icon),
                    contentDescription = "",
                    modifier
                        .size(40.dp)
                        .weight(2.0f))
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, bottom = 16.dp),
            ){
                Image(painter = painterResource(id = R.drawable.shepherd),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(color = Color.Gray)
                        .padding(top = 5.dp)
                )
                Column(modifier = Modifier
                    .weight(2.0f)
                    .padding(start = 16.dp,)) {
                    Text(text = "Lumbani Makumbi", fontWeight = SemiBold)
                    Text(text = "trojanhorse@codex.com")
                }
                Text(text = "99+", modifier = Modifier.padding(end = 16.dp))
            }
            Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start){
                    Card(modifier = modifier
                        .requiredWidth(200.dp)
                        .padding(start = 30.dp),
                        shape = RoundedCornerShape(50.dp),
                        border = BorderStroke(1.dp, color = Color.Gray))  {
                        Text(text = "Google Account", modifier.padding(8.dp), textAlign = TextAlign.Center)

                    }
                Spacer(modifier.width(10.dp))
            }
            Divider(modifier.padding(top = 16.dp))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun previewIt(){
    GoogleMailUICloneTheme() {
        AccountsDialogScreen()
    }
}