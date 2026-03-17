package com.sae.loupgarou

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.sae.loupgarou.R.font
import com.sae.loupgarou.pages.historique.HistoriquePage
import com.sae.loupgarou.ui.theme.SAELoupGarouTheme
import com.sae.loupgarou.pages.main.MainNavHost
import com.sae.loupgarou.pages.main.MainPage


val fontAldrich = FontFamily(
    Font(font.aldrich_regular, FontWeight.Normal)
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SAELoupGarouTheme {
                MainNavHost()

            }
        }
    }
}
