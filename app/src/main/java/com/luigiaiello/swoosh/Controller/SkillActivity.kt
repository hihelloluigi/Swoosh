package com.luigiaiello.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.luigiaiello.swoosh.Model.Player
import com.luigiaiello.swoosh.R
import com.luigiaiello.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    //var league = ""
    //var skill = ""
    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra(EXTRA_PLAYER)
        //league = intent.getStringExtra(EXTRA_LEAGUE)
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
    fun onBallerClicked(view: View) {
        beginnerSkillButton.isChecked = false
        player.skill = "baller"
        //skill = "baller"
    }

    fun onBeginnerClicked(view: View) {
        ballerSkillButton.isChecked = false
        player.skill = "beginner"
        //skill = "beginner"
    }

    fun onFinishSkillClicked(view: View) {
        if (!player.skill.isEmpty()) {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            //finishActivity.putExtra(EXTRA_LEAGUE, league)
            //finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level.", Toast.LENGTH_SHORT).show()
        }
    }
    //endregion

}
