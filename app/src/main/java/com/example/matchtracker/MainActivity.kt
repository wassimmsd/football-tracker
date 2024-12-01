package com.example.matchtracker

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    // Score variables
    private var homeScore = 0
    private var awayScore = 0

    // Stat variables
    private var homePossession = 0
    private var awayPossession = 0
    private var homeShots = 0
    private var awayShots = 0
    private var homeYellowCards = 0
    private var awayYellowCards = 0

    // UI Elements
    private lateinit var homeScoreText: TextView
    private lateinit var awayScoreText: TextView
    private lateinit var homePossessionText: TextView
    private lateinit var awayPossessionText: TextView
    private lateinit var homeShotsText: TextView
    private lateinit var awayShotsText: TextView
    private lateinit var homeYellowCardsText: TextView
    private lateinit var awayYellowCardsText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        initializeViews()

        // Home Team Buttons
        findViewById<Button>(R.id.btnHomeGoal).setOnClickListener { incrementHomeScore() }
        findViewById<Button>(R.id.btnHomePossession).setOnClickListener { updateHomePossession() }
        findViewById<Button>(R.id.btnHomeShot).setOnClickListener { updateHomeShots() }
        findViewById<Button>(R.id.btnHomeYellowCard).setOnClickListener { updateHomeYellowCards() }

        // Away Team Buttons
        findViewById<Button>(R.id.btnAwayGoal).setOnClickListener { incrementAwayScore() }
        findViewById<Button>(R.id.btnAwayPossession).setOnClickListener { updateAwayPossession() }
        findViewById<Button>(R.id.btnAwayShot).setOnClickListener { updateAwayShots() }
        findViewById<Button>(R.id.btnAwayYellowCard).setOnClickListener { updateAwayYellowCards() }

        // Reset Match Button
        findViewById<Button>(R.id.btnResetMatch).setOnClickListener { resetMatch() }
    }

    private fun initializeViews() {
        // Score TextViews
        homeScoreText = findViewById(R.id.txtHomeScore)
        awayScoreText = findViewById(R.id.txtAwayScore)

        // Stat TextViews
        homePossessionText = findViewById(R.id.txtHomePossession)
        awayPossessionText = findViewById(R.id.txtAwayPossession)
        homeShotsText = findViewById(R.id.txtHomeShots)
        awayShotsText = findViewById(R.id.txtAwayShots)
        homeYellowCardsText = findViewById(R.id.txtHomeYellowCards)
        awayYellowCardsText = findViewById(R.id.txtAwayYellowCards)
    }

    // Score Methods
    private fun incrementHomeScore() {
        homeScore++
        homeScoreText.text = homeScore.toString()
    }

    private fun incrementAwayScore() {
        awayScore++
        awayScoreText.text = awayScore.toString()
    }

    // Possession Methods
    private fun updateHomePossession() {
        if (homePossession < 100) {
            homePossession += 10
            awayPossession = 100 - homePossession
            updatePossessionDisplay()
        }
    }

    private fun updateAwayPossession() {
        if (awayPossession < 100) {
            awayPossession += 10
            homePossession = 100 - awayPossession
            updatePossessionDisplay()
        }
    }

    private fun updatePossessionDisplay() {
        homePossessionText.text = "$homePossession%"
        awayPossessionText.text = "$awayPossession%"
    }

    // Shots Methods
    private fun updateHomeShots() {
        homeShots++
        homeShotsText.text = homeShots.toString()
    }

    private fun updateAwayShots() {
        awayShots++
        awayShotsText.text = awayShots.toString()
    }

    // Yellow Cards Methods
    private fun updateHomeYellowCards() {
        homeYellowCards++
        homeYellowCardsText.text = homeYellowCards.toString()
    }

    private fun updateAwayYellowCards() {
        awayYellowCards++
        awayYellowCardsText.text = awayYellowCards.toString()
    }

    // Reset Match Method
    private fun resetMatch() {
        // Reset Scores
        homeScore = 0
        awayScore = 0
        homeScoreText.text = "0"
        awayScoreText.text = "0"

        // Reset Possession
        homePossession = 0
        awayPossession = 0
        homePossessionText.text = "0%"
        awayPossessionText.text = "0%"

        // Reset Shots
        homeShots = 0
        awayShots = 0
        homeShotsText.text = "0"
        awayShotsText.text = "0"

        // Reset Yellow Cards
        homeYellowCards = 0
        awayYellowCards = 0
        homeYellowCardsText.text = "0"
        awayYellowCardsText.text = "0"
    }
}