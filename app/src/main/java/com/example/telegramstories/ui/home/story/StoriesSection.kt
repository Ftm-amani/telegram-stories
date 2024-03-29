package com.example.telegramstories.ui.home.story

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.telegramstories.data.DummyData
import com.example.telegramstories.data.Story
import com.example.telegramstories.ui.theme.TelegramAccentBlue
import com.example.telegramstories.ui.theme.TelegramStoryBorderGradient

@Composable
fun StoryItem(
    story: Story,
    size: Int,
    isTextVisible:Boolean
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Box(
                Modifier
                    .height(size.dp)
                    .width(size.dp)
                    .padding(5.dp)
                    .border(
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 2.dp,
                            brush = Brush.linearGradient(
                                colors = TelegramStoryBorderGradient,
                                start = Offset(
                                    0f,
                                    0f
                                ),
                                end = Offset(
                                    100f,
                                    100f
                                )
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                val decreasedSize = size - 20
                Image(
                    painter = painterResource(id = story.avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(decreasedSize.dp)
                        .clip(CircleShape)
                )
            }
            if (story.userName == "me")
                Icon(
                    imageVector = Icons.Rounded.AddCircle,
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset(
                            x = (-5).dp,
                            y = (-5).dp
                        )
                        .size(15.dp),
                    tint = Color.White
                )
        }

        if (isTextVisible) {
            Text(
                text = if (story.userName == "me") "My Story" else story.userName,
                fontSize = 8.sp,
                color = Color.White,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun StoriesSection() {
    Box(
        Modifier
            .background(color = TelegramAccentBlue)
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            items(DummyData.storyList) {
                StoryItem(
                    story = it,
                    size = 56,
                    isTextVisible = true
                )
            }
        }
    }
}