package com.kz.valocheck.repo

import com.kz.valocheck.R
import com.kz.valocheck.domain.MapsDomain
import javax.inject.Inject

class MapsRepo @Inject constructor() {
    private val mockMapList = listOf(
        MapsDomain("1", "Ascent1", "45°26'BF'N,12°20'Q'E", R.drawable.map_listview_icon, R.drawable.map_ascent_minimap_displayicon ),
        MapsDomain("2", "Ascent2", "45°26'BF'N,12°20'Q'E", R.drawable.map_listview_icon, R.drawable.map_ascent_minimap_displayicon ),
        MapsDomain("3", "Ascent3", "45°26'BF'N,12°20'Q'E", R.drawable.map_listview_icon, R.drawable.map_ascent_minimap_displayicon ),
        MapsDomain("4", "Ascent4", "45°26'BF'N,12°20'Q'E", R.drawable.map_listview_icon, R.drawable.map_ascent_minimap_displayicon ),
        MapsDomain("5", "Ascent5", "45°26'BF'N,12°20'Q'E", R.drawable.map_listview_icon, R.drawable.map_ascent_minimap_displayicon ),
    )

    fun getMapsList() : List<MapsDomain> {
        return mockMapList
    }

    fun getMapsDetail(id: String): MapsDomain {
        return mockMapList.find { it.id == id }!!
    }
}

