package com.umut.poele.data

import com.umut.poele.R
import com.umut.poele.model.MenuCard

class MenuCardDataSource {

    fun loadMenuCards(): List<MenuCard>{
        return listOf<MenuCard>(
            MenuCard(R.drawable.isaac_benhesed_onlbxleikds_unsplash),
            MenuCard(R.drawable.kimi_lee_cetg8yszkpu_unsplash),
            MenuCard(R.drawable.nordwood_themes_ivp3tydlvw0_unsplash),
            MenuCard(R.drawable.nordwood_themes_ndd3dikkolo_unsplash),
        )
    }
}
