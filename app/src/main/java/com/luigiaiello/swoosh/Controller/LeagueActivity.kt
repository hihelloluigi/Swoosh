package com.luigiaiello.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.luigiaiello.swoosh.Model.Player
import com.luigiaiello.swoosh.R.layout.activity_league
import com.luigiaiello.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_league)
    }

    //region Restore when configuration changes
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }
    //endregion

    //region Actions
    fun onMensClicked(view: View) {
        womensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false

        player.league = "mens"
    }

    fun onWomensClicked(view: View) {
        mensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false

        player.league = "womens"
    }

    fun onCoedClicked(view: View) {
        mensLeagueButton.isChecked = false
        womensLeagueButton.isChecked = false

        player.league = "co-ed"
    }
    fun leagueNextClicked(view: View) {
        if (!player.league.isEmpty()) {
            val skillActivity = Intent(this, SkillActivity::class.java)

            skillActivity.putExtra(EXTRA_PLAYER, player)
            //skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)
        } else {
            //Toast Android
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }
    }
    //endregion
}
