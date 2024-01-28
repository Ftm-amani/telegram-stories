package com.example.telegramstories.data

import android.text.style.BackgroundColorSpan
import androidx.compose.ui.graphics.Color

data class Message(
    val id: Int,
    val userName: String,
    val text: String,
    val avatar: Int,
    val backgroundColor: Color
    )
