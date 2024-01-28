package com.example.telegramstories.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.telegramstories.R
import com.example.telegramstories.data.DummyData.messages
import com.example.telegramstories.data.Message
import com.example.telegramstories.data.Story
import com.example.telegramstories.ui.home.story.StoriesSection
import com.example.telegramstories.ui.home.story.StoryItem
import com.example.telegramstories.ui.theme.TelegramAccentBlue
import com.example.telegramstories.ui.theme.TelegramActionBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelegramFirstScreen() {

    val isFabVisible by remember { mutableStateOf(true) }
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("All", "Channels", "Unread")
    var isStoriesVisible by remember { mutableStateOf(false) }

    Box {
        Column(
            modifier = Modifier
        ) {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        if (!isStoriesVisible) {
                            // Small story icon in app bar
                            Box(contentAlignment = Alignment.Center,
                                modifier = Modifier.clickable {
                                    isStoriesVisible = !isStoriesVisible
                                }) {

                                StoryItem(
                                    story = Story(
                                        id = 1,
                                        userName = "",
                                        avatar = R.drawable.avatar_telegram
                                    ),
                                    size = 50,
                                    isTextVisible = false
                                )
                            }
                        }
                        // Spacer for spacing between icon and title
                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Telegram",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Toggle drawer"
                        )
                    }
                },
                actions = {
                    // Add the search icon at the end of the app bar
                    IconButton(onClick = { /* Handle search icon click */ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = TelegramAccentBlue,
                    scrolledContainerColor = Color.White,
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White,
                )
            )

            // Stories section (visible only when isStoriesVisible is true)
            if (isStoriesVisible) {
                StoriesSection()
            }

            // TabView
            TabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier
                    .fillMaxWidth(),

                contentColor = Color.White,
                containerColor = TelegramAccentBlue,
                indicator = { tabPositions ->
                    TabRowDefaults
                        .Indicator(
                            modifier = Modifier
                                .tabIndicatorOffset(tabPositions[selectedTabIndex])
                                .padding(start = 30.dp, end = 30.dp)
                                .clip(shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)),
                            color = Color.White,
                            height = 4.dp,
                        )
                },
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = {
                            selectedTabIndex = index
                        },
                        content = {
                            Text(
                                text = title,
                                modifier = Modifier.padding(bottom = 10.dp)
                            )
                        }
                    )
                }
            }

            when (selectedTabIndex) {
                0 -> ChatsContent()
                1 -> ChannelsContent()
                2 -> UnreadContent()
            }
        }

        if (isFabVisible) {
            FloatingActionButton(
                shape = CircleShape,
                containerColor = TelegramActionBlue,
                onClick = {
                    // todo Handle FloatingActionButton click
                },
                modifier = Modifier
                    .padding(16.dp)
                    .size(60.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(
                    imageVector = Icons.Default.Create, contentDescription = "Compose",
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }

    }
}

@Composable
fun MessageItem(message: Message) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // User image
        Image(
            painter = painterResource(id = message.avatar),
            contentDescription = "User Image",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(message.backgroundColor),
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Message content
        Column {
            Text(text = message.userName, style = MaterialTheme.typography.labelSmall)
            Text(text = message.text, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun ChatsContent() {
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(messages) { message ->
            MessageItem(message = message)
        }
    }
}

@Composable
fun ChannelsContent() {
    Text("Channels Content")
}

@Composable
fun UnreadContent() {
    Text("Unread Content")
}