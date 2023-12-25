package com.umut.poele.ui.macro

import com.umut.poele.domain.model.Supply
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.AddMealListener
import com.umut.poele.util.ChallengeListener
import com.umut.poele.util.ChooseChefListener
import com.umut.poele.util.MoreOptionListener

class MacroFirstViewModel : BaseViewModel(), ChooseChefListener, AddMealListener, ChallengeListener, MoreOptionListener {

    override fun onChooseChefClicked() {
        navigate(MacroFirstFragmentDirections.actionMacroFirstFragmentToChooseChefDialog())
    }

    override fun onAddMealClicked() {
        navigate(MacroFirstFragmentDirections.actionMacroFirstFragmentToMealEntryDialog())
    }

    override fun onChallengeClicked() {
        navigate(MacroFirstFragmentDirections.actionMacroFirstFragmentToChallengeDialog())
    }

    override fun onMoreOptionClicked(clickedSupply: Supply) {
        navigate(MacroFirstFragmentDirections.actionMacroFirstFragmentToMacroMoreOptionDialog(clickedSupply))
    }
}
