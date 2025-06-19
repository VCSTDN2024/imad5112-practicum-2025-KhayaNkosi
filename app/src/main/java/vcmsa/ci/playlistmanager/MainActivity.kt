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

    private lateinit var edtSongTitle: EditText
    private lateinit var edtArtistsName: EditText
    private lateinit var edtRating: EditText
    private lateinit var edtComment: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnReview: Button
    private val songs = ArrayList<Song>()
    private val maxSongs = 4



    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        edtSongTitle = findViewById(R.id.edtSongTitle)
        edtArtistsName = findViewById(R.id.edtArtistsName)
        edtRating = findViewById(R.id.edtRating)
        edtComment = findViewById(R.id.edtComment)
        btnAdd = findViewById(R.id.btnAdd)
        btnReview = findViewById(R.id.btnReview)

        val btnExit = findViewById<Button>(R.id.btnExit)

        btnExit.setOnClickListener {
            finish()
            exitProcess(0)
        }
        btnReview.setOnClickListener {
            if(songs.isNotEmpty()){
            val intent = Intent(this, Review::class.java)
            startActivity(intent)
        }else{
                Toast.makeText(this, "Please add songs first", Toast.LENGTH_SHORT).show()       }

        btnAdd.setOnClickListener {
            if (songs.size >= maxSongs) {
                Toast.makeText(this, "you can only add 4 songs", Toast.LENGTH_SHORT).show()
            btnAdd.isEnabled = false
                return@setOnClickListener
            }else{
                btnAdd.isEnabled =true
            }


            val songTitle = edtSongTitle.text.toString()
            val artistsName = edtArtistsName.text.toString()
            val rating = edtRating.text.toString()
            val comment = edtComment.text.toString()



            if (songTitle.isNotEmpty() && artistsName.isNotEmpty() && rating.isNotEmpty() && comment.isNotEmpty()) {
                val song = Song(songTitle, artistsName, rating, comment)

                songs.add(song)

                edtSongTitle.text.clear()
                edtArtistsName.text.clear()
                edtRating.text.clear()
                edtComment.text.clear()

                Toast.makeText(this, "Song added successfully. ${songs.size}/$maxSongs", Toast.LENGTH_SHORT).show()


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














