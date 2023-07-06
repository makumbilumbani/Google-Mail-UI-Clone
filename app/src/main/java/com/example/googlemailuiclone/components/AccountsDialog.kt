package com.example.googlemailuiclone.components

import android.annotation.SuppressLint
import android.graphics.drawable.VectorDrawable
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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PersonAddAlt
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.googlemailuiclone.R
import com.example.googlemailuiclone.accountlist
import com.example.googlemailuiclone.model.Account
import com.example.googlemailuiclone.ui.theme.GoogleMailUICloneTheme

@Composable
fun AccountsDialog(openDialog : MutableState<Boolean>){
    Dialog(onDismissRequest = { openDialog.value = false}) {
        AccountsDialogScreen(openDialog = openDialog)
    }
}
@Composable
fun AccountsDialogScreen(modifier: Modifier = Modifier, openDialog : MutableState<Boolean>){
    Card(){
        Column(
            modifier
                .background(Color.White)
                .padding(bottom = 16.dp)){
            Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                IconButton(onClick = {
                    openDialog.value = false
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

            AccountDialogList(account = accountlist[0])

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
            Column(
                modifier = Modifier.padding(top = 5.dp)
            ){
                AccountDialogList(account = accountlist[1])
                AccountDialogList(account = accountlist[2])
            }
            AddAccount(icon = Icons.Default.PersonAddAlt, title = "Add Another Account" )
            AddAccount(icon = Icons.Outlined.ManageAccounts, title = "Manage Accounts on this Device" )
            Divider(modifier.padding(top = 16.dp, bottom = 10.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(text = "Privacy Policy")
                Card(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(5.dp),
                    shape = CircleShape,
                    backgroundColor = MaterialTheme.colors.onSurface
                ) {

                }
                Text(text = "Terms of Service")
            }
        }

    }

}
@Composable
fun AccountDialogList(account: Account){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, bottom = 16.dp),
    ){
        if(account.icon != null){
            Image(painter = painterResource(account.icon),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(color = Color.Gray)
                    .padding(top = 10.dp)
            )
        }else{
            Card(modifier = Modifier
                .padding(end = 8.dp)
                .size(40.dp)
                .clip(CircleShape),
                backgroundColor = Color.Gray)
            {
                Text(
                    text = account.userName[0].toString(),
                    textAlign = TextAlign.Center, modifier = Modifier.padding(8.dp)
                )
            }
        }

        Column(modifier = Modifier
            .weight(2.0f)
            .padding(start = 16.dp,)) {
            Text(account.userName, fontWeight = SemiBold)
            Text(account.email)
        }
        if (account.unReadMails >= 100){
            Text(text = "99+", modifier = Modifier.padding(end = 16.dp))
        }else{
            Text(account.unReadMails.toString(), modifier = Modifier.padding(end = 16.dp))
        }

    }
}
@Composable
fun AddAccount(icon : ImageVector, title: String){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
            ){
        IconButton(onClick = { /*TODO*/ } ) {
            Icon(imageVector = icon, contentDescription = "", modifier = Modifier.padding(8.dp))
        }
        Text(text = title, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(top = 8.dp, start = 8.dp) )
    }
}
@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun previewIt(){
    GoogleMailUICloneTheme() {
        AccountsDialogScreen( openDialog = mutableStateOf(false))
    }
}