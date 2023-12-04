package edu.uark.virtualfitnessgarden

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prototype_shop)

        initializeButtons()
    }

    fun initializeButtons(){
        val button_shop = findViewById<ImageButton>(R.id.button_shop)
        val button_home = findViewById<ImageButton>(R.id.button_home)
        val button_friend = findViewById<ImageButton>(R.id.button_friends)

        if(!ShopActivity::class.java.isAssignableFrom(this::class.java)){
            // We are not in shop activity
            button_shop.setOnClickListener{
                val intent = Intent(this, ShopActivity::class.java)
                finish()
                startActivity(intent)
            }
        }

        if(!MainActivity::class.java.isAssignableFrom(this::class.java)){
            // We are not in home main activity
            button_home.setOnClickListener{
                val intent = Intent(this, MainActivity::class.java)
                finish()
                startActivity(intent)
            }
        }

        if(!FriendActivity::class.java.isAssignableFrom(this::class.java)){
            // We are not in home main activity
            button_friend.setOnClickListener{
                val intent = Intent(this, FriendActivity::class.java)
                finish()
                startActivity(intent)
            }
        }
    }

}