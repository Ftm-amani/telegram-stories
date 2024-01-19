package com.example.telegramstories.data

import com.example.telegramstories.R

object DummyData {
    private val story =
        Story(
            id = 1,
            userName = "me",
            avatar = R.drawable.avatar_1
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
}