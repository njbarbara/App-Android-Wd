package com.sae.loupgarou

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sae.loupgarou.ui.theme.SAELoupGarouTheme
import com.sae.loupgarou.pages.credits.Credits


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SAELoupGarouTheme {
                Credits()
            }
        }
    }
}


