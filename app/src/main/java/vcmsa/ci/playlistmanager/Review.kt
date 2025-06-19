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

        btnDisplay = findViewById(R.id.btnDisplay)
         btnMain = findViewById(R.id.btnMain)
         btnCalculate = findViewById(R.id.btnCalculate)
         TxtAverageRate = findViewById(R.id.TxtAverageRate)
         TxtSongs = findViewById(R.id.TxtSongs)

        val songs = intent.getStringArrayListExtra("songs")
        val ratings = intent.getStringArrayListExtra("ratings")




        btnMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnDisplay.setOnClickListener {

                Toast.makeText(this, "results are going to show in a second", Toast.LENGTH_SHORT).show()
        }









        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}