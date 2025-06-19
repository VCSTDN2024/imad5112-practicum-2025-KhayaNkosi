package vcmsa.ci.playlistmanager

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

data class Song(
    val songTitle: String,
    val artistsName: String,
    val rating: String,
    val comment: String

)

class MainActivity : AppCompatActivity() {
   //Declare UI elements
    private lateinit var edtSongTitle: EditText //edittext for song title
    private lateinit var edtArtistsName: EditText//edittext for artists name
    private lateinit var edtRating: EditText//edittext for rating
    private lateinit var edtComment: EditText//edittext for comment
    private lateinit var btnAdd: Button//button for adding songs
    private lateinit var btnReview: Button//button for review
    private val songs = ArrayList<Song>()//arraylist for songs
    private val maxSongs = 4//max number of songs



    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Initialize UI elements
        edtSongTitle = findViewById(R.id.edtSongTitle)
        edtArtistsName = findViewById(R.id.edtArtistsName)
        edtRating = findViewById(R.id.edtRating)
        edtComment = findViewById(R.id.edtComment)
        btnAdd = findViewById(R.id.btnAdd)
        btnReview = findViewById(R.id.btnReview)

        //button for exit
        val btnExit = findViewById<Button>(R.id.btnExit)
        //button exit action to close the app
        btnExit.setOnClickListener {
            finish()
            exitProcess(0)
        }
        //button setonclicklistener for review to go to the next screen
        btnReview.setOnClickListener {
            if(songs.isNotEmpty()){
            val intent = Intent(this, Review::class.java)
            startActivity(intent)
        }else{
                Toast.makeText(this, "Please add songs first", Toast.LENGTH_SHORT).show()       }
        //button for adding the songs to the playlist
        btnAdd.setOnClickListener {
            if (songs.size >= maxSongs) {
                Toast.makeText(this, "you can only add 4 songs", Toast.LENGTH_SHORT).show()
            btnAdd.isEnabled = false
                return@setOnClickListener
            }else{
                btnAdd.isEnabled =true
            }

            //to get users input from the edit text
            val songTitle = edtSongTitle.text.toString()
            val artistsName = edtArtistsName.text.toString()
            val rating = edtRating.text.toString()
            val comment = edtComment.text.toString()


            //to check if the edit text is empty or not if so it will show a toast message
            if (songTitle.isNotEmpty() && artistsName.isNotEmpty() && rating.isNotEmpty() && comment.isNotEmpty()) {
                val song = Song(songTitle, artistsName, rating, comment)

                songs.add(song)
                //this is for clearing the edit text after adding the song
                edtSongTitle.text.clear()
                edtArtistsName.text.clear()
                edtRating.text.clear()
                edtComment.text.clear()
                //to show a toast message to show when a song is added
                Toast.makeText(this, "Song added successfully. ${songs.size}/$maxSongs", Toast.LENGTH_SHORT).show()

                //to check if the max number of songs is reached or not if so the button will be disabled
                if (songs.size >= maxSongs) {
                    btnAdd.isEnabled = true
                    Toast.makeText(this, "Maximum song limit reached.", Toast.LENGTH_LONG).show()
                } else {
                    btnAdd.isEnabled = false
                }


                btnAdd.isEnabled = true

                Toast.makeText(this, "Song added successfully", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Please enter the information", Toast.LENGTH_SHORT).show()

            }}}}}














