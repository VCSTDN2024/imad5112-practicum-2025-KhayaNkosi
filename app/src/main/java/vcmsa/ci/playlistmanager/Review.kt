package vcmsa.ci.playlistmanager

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Review : AppCompatActivity() {
    //Declare UI elements
    private lateinit var btnDisplay: Button
    private lateinit var btnMain: Button
    private lateinit var btnCalculate: Button
    private lateinit var TxtAverageRate: TextView
    private lateinit var TxtSongs: TextView



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)

        //Initialize UI elements
        btnDisplay = findViewById(R.id.btnDisplay)
         btnMain = findViewById(R.id.btnMain)
         btnCalculate = findViewById(R.id.btnCalculate)
         TxtAverageRate = findViewById(R.id.TxtAverageRate)
         TxtSongs = findViewById(R.id.TxtSongs)

        //to get the songstitles artists name and ratings as well as comments from the main activity
        val ratings = intent.getStringArrayListExtra("ratings")
        val artists = intent.getStringArrayListExtra("artists")
        val songTitles = intent.getStringArrayListExtra("songTitles")
        val comments = intent.getStringArrayListExtra("comments")



        //btnMain setonclicklistener to go back to the main screen
        btnMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }}}
        //btnDisplay to display the songs titles artists name and ratings as well as comments











