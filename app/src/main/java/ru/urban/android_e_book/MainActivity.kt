package ru.urban.android_e_book

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private lateinit var toggleButtonTB: ToggleButton

    private lateinit var textViewTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textViewTV = findViewById(R.id.textView)
        toggleButtonTB = findViewById(R.id.toggleButton)

        toggleButtonTB.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(view: CompoundButton?, isChecked: Boolean) {
        if (isChecked){
            val book = DataBase().loadBook("text")
            for (line in book){
                textViewTV.append(line + "\n")
            }
        } else{
            textViewTV.setText("")
        }
    }
}