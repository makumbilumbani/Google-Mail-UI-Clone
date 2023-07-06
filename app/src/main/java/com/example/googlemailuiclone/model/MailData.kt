package com.example.googlemailuiclone.model

data class MailData (
    val MailId : Int,
    val Username: String,
    val Subject: String,
    val Body: String,
    val Timestamp: String = ""
)