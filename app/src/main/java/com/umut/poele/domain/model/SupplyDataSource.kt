package com.umut.poele.domain.model

import com.umut.poele.util.States
import com.umut.poele.util.Units
import java.time.LocalDate

class SupplyDataSource {

    fun loadSupply(): List<Supply> {
        return listOf(
            Supply(
                1,
                "Ground Beef",
                "R.drawable.ground_meat",
                "Meat",
                500.0,
                Units.GRAM,
                Macro(332.0, 30.0, 0.0, 14.0, 14.0),
                States.UNUSED,
                LocalDate.of(2023, 11, 4),
                null
            ),
            Supply(
                2,
                "Lasagne Sheet",
                "R.drawable.lasagne_sheet",
                "Pasta",
                18.0,
                Units.PIECE,
                Macro(359.0, 2.0, 71.7, 3.0, 12.0),
                States.UNUSED,
                LocalDate.of(2023, 11, 4),
                16
            ),
            Supply(
                3,
                "Flour",
                "R.drawable.flour",
                "Food",
                50.0,
                Units.GRAM,
                Macro(364.0, 1.0, 76.0, 2.7, 10.0),
                States.UNUSED,
                LocalDate.of(2023, 11, 4),
                null
            ),
        )
    }
}
