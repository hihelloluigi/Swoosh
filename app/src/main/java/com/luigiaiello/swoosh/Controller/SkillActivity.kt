package com.luigiaiello.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.luigiaiello.swoosh.Utilities.EXTRA_LEAGUE
import com.luigiaiello.swoosh.R
import com.luigiaiello.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        league = intent.getStringExtra(EXTRA_LEAGUE)
    }

    //region Actions
    fun onBallerClicked(view: View) {
        beginnerSkillButton.isChecked = false
        skill = "baller"
    }

    fun onBeginnerClicked(view: View) {
        ballerSkillButton.isChecked = false
        skill = "beginner"
    }

    fun onFinishSkillClicked(view: View) {
        if (!skill.isEmpty()) {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level.", Toast.LENGTH_SHORT).show()
        }
    }
    //endregion

}
