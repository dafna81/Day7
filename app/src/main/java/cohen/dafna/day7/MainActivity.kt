package cohen.dafna.day7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cohen.dafna.day7.blackjack.Deck
import cohen.dafna.day7.blackjack.Game
import cohen.dafna.day7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Game()

    }
}