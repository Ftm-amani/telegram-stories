package com.example.telegramstories.data

import androidx.compose.ui.graphics.Color
import com.example.telegramstories.R

object DummyData {
    private val story =
        Story(
            id = 1,
            userName = "me",
            avatar = R.drawable.avatar_me
        )

    val storyList = listOf(
        story,
        story.copy(
            id = 2,
            userName = "Telegram",
            avatar = R.drawable.avatar_telegram
        ),
        story.copy(
            id = 3,
            userName = "jami",
            avatar = R.drawable.avatar_3
        ),
        story.copy(
            id = 4,
            userName = "john",
            avatar = R.drawable.avatar_4
        ),
        story.copy(
            id = 5,
            userName = "john",
            avatar = R.drawable.avatar_5
        )
    )

    private val message = Message(
        id = 1,
        userName = "jane",
        text = "just wanna say hi",
        avatar = R.drawable.avatar_1,
        backgroundColor = Color.Yellow
    )
    val messages = listOf(
        message,
        message.copy(
            id = 2,
            userName = "john",
            text = "What's up?",
            avatar = R.drawable.avatar_2,
            backgroundColor = Color.Cyan
        ),
        message.copy(
            id = 3,
            userName = "Lena",
            text = "Hello, how are you?",
            avatar = R.drawable.avatar_3,
            backgroundColor = Color.Red
        ),
        message.copy(
            id = 4,
            userName = "Moritz",
            text = "Check out this cool app!",
            avatar = R.drawable.avatar_4,
            backgroundColor = Color.LightGray
        ),
        message.copy(
            id = 5,
            userName = "Peter",
            text = "ok",
            avatar = R.drawable.avatar_5,
            backgroundColor = Color.Magenta
        ),
        message.copy(
            id = 6,
            userName = "Telegram",
            text = "New Update ...",
            avatar = R.drawable.avatar_telegram,
            backgroundColor = Color.Transparent
        ),
        message.copy(
            id = 7,
            userName = "Mia",
            text = "with Alex",
            avatar = R.drawable.avatar_2,
            backgroundColor = Color.Black
        ),
    )
}