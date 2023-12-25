package com.umut.poele.domain.model

import com.umut.poele.R
import com.umut.poele.domain.model.Macro
import com.umut.poele.domain.model.RecipeModel
import com.umut.poele.domain.model.Supply
import com.umut.poele.util.Levels
import com.umut.poele.util.States
import com.umut.poele.util.Units
import java.time.LocalDate

class RecipeDataSource {

    fun loadRecipe(): List<RecipeModel> {
        return listOf(
            RecipeModel(
                1,
                "Lasagne",
                R.drawable.lasagne,
                "Umut",
                listOf("Pasta", "Meat"),
                "Pizza ipsum dolor meat lovers buffalo. Chicken steak Bianca pan parmesan bbq steak.",
                45,
                4,
                Levels.INTERMEDIATE,
                listOf("Italian"),
                true,
                false,
                listOf("Pan", "Oven", "Baking Tray", "Knife", "Pot", "Foil", "Baking Paper"),
                listOf(
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " + "tempor incididunt ut labore et dolore magna aliqua.",
                    "Egestas fringilla phasellus faucibus scelerisque eleifend donec pretium.",
                    "Elit sed vulputate mi sit amet mauris commodo quis imperdiet.",
                    "Euismod lacinia at quis risus sed vulputate.",
                    "Pretium vulputate sapien nec sagittis aliquam malesuada bibendum.",
                    "Quam vulputate dignissim suspendisse in est ante in nibh mauris.",
                    "Volutpat consequat mauris nunc congue nisi vitae suscipit."
                ),
                listOf(
                    Supply(
                        1,
                        "Ground Beef",
                        R.drawable.ground_meat,
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
                        R.drawable.lasagne_sheet,
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
                        R.drawable.flour,
                        "Food",
                        50.0,
                        Units.GRAM,
                        Macro(364.0, 1.0, 76.0, 2.7, 10.0),
                        States.UNUSED,
                        LocalDate.of(2023, 11, 4),
                        null
                    ),
                )
            )
        )

    }

}
