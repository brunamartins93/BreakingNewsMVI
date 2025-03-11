package com.course.breakingnews.main.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.course.breakingnews.main.App
import com.course.breakingnews.ui.card.BreakingNewsCard
import com.course.breakingnews.ui.content.DetailsContentSection
import com.course.breakingnews.ui.header.DetailsHeaderSection
import com.course.breakingnews.ui.top.BreakingNewsTopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT,
            )
        )
        setContent {
            App()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComponentsPreview() {
    Column {
        BreakingNewsTopBar(onClick = {})
        BreakingNewsCard(
            title = "5 things to know about the 'conundrum' of lupus",
            author = "Matt Villano",
            date = "Sunday, 9 May 2021",
            imageUrl = "",
            onClick = {}
        )
        DetailsHeaderSection(
            urlToImage = "",
            onClick = {})
        DetailsContentSection(
            content = """
                    LONDON — Cryptocurrencies “have no intrinsic value” and people who invest in them should be prepared to lose all their money, Bank of England Governor Andrew Bailey said.

                    Digital currencies like bitcoin, ether and even dogecoin have been on a tear this year, reminding some investors of the 2017 crypto bubble in which bitcoin blasted toward $20,000, only to sink as low as $3,122 a year later.

                    Asked at a press conference Thursday about the rising value of cryptocurrencies, Bailey said: “They have no intrinsic value. That doesn’t mean to say people don’t put value on them, because they can have extrinsic value. But they have no intrinsic value.”
                """.trimIndent()
        )
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}