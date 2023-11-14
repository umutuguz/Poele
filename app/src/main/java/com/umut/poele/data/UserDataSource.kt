package com.umut.poele.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.umut.poele.R
import com.umut.poele.model.Address
import com.umut.poele.model.Macro
import com.umut.poele.model.MenuCard
import com.umut.poele.model.Recipe
import com.umut.poele.model.Supply
import com.umut.poele.model.User
import com.umut.poele.util.Levels
import com.umut.poele.util.States
import com.umut.poele.util.Units
import java.time.LocalDate

class UserDataSource {

    @RequiresApi(Build.VERSION_CODES.O)
    fun loadUser(): List<User> {
        return listOf<User>(
            User(
                1,
                "umutuguzlar7@gmail.com",
                "1234",
                "Umut",
                "Uguzlar",
                "5375177057",
                Address("Ev", R.drawable.round_home_24, "Istanbul", "Bagcilar", "Ahmet", "Bayir", "Hatir", 3, 6, 15, 34000),
                R.drawable.avatar,
                listOf(MenuCard("Breakfast", "Umut", "Sunny Side Up", "Bread", "Tea")),
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
                    )
                ),
                listOf(
                    Recipe(
                        1,
                        "Lasagne",
                        R.drawable.lasagne,
                        "Umut",
                        listOf("Pasta", "Meat"),
                        "Description",
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
            )
        )

    }
}
