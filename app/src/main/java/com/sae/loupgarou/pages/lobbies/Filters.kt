package com.sae.loupgarou.pages.lobbies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sae.loupgarou.R

@Composable
fun Filters(selectedFilter: String, onFilterChange: (String) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(bottom = 24.dp)
    ) {
        FilterButton(stringResource(id = R.string.lobbies_filter_all), "all", selectedFilter, onFilterChange)
        FilterButton(stringResource(id = R.string.lobbies_filter_waiting), "lobby", selectedFilter, onFilterChange)
        FilterButton(stringResource(id = R.string.lobbies_filter_playing), "playing", selectedFilter, onFilterChange)
        FilterButton(stringResource(id = R.string.lobbies_filter_ended), "ended", selectedFilter, onFilterChange)
    }
}