package com.luigiaiello.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.luigiaiello.swoosh.Utilities.EXTRA_LEAGUE
import com.luigiaiello.swoosh.R.layout.activity_league
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_league)
    }

    //region Actions
    fun onMensClicked(view: View) {
        womensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false

        selectedLeague = "mens"
    }

    fun onWomensClicked(view: View) {
        mensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false

        selectedLeague = "womens"
    }

    fun onCoedClicked(view: View) {
        mensLeagueButton.isChecked = false
        womensLeagueButton.isChecked = false

        selectedLeague = "co-ed"
    }
    fun leagueNextClicked(view: View) {
        if (!selectedLeague.isEmpty()) {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)
        } else {
            //Toast Android
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }
    }
    //endregion
}
