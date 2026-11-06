package com.example.quizgorysprawdzian

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val image = findViewById<ImageView>(R.id.image)
        val pytanie = findViewById<TextView>(R.id.pytanie)
        val odpowiedzGrupa = findViewById<RadioGroup>(R.id.radioGroup)
        val odpowiedz1 = findViewById<RadioButton>(R.id.odpowiedz1)
        val odpowiedz2 = findViewById<RadioButton>(R.id.odpowiedz2)
        val odpowiedz3 = findViewById<RadioButton>(R.id.odpowiedz3)

        val button = findViewById<Button>(R.id.button)

        var pytaniaLista = listOf(
            Pytanie(
                "Które to schronisko?",
                listOf("Na Rysiance","Na Wielkiej Raczy", "Na Wielkiej Rycerzowej"),
                "Na Wielkiej Raczy",
                R.drawable.zad1
            ),
            Pytanie(
                "Zwierzę na zdjęciu to",
                listOf("owczarek","wilk", "kozica"),
                "owczarek",
                R.drawable.zad2
            ),
            Pytanie(
                "W oddali są widoczne",
                listOf("Himalaje","Alpy", "Tatry"),
                "Tatry",
                R.drawable.zad3
            )

        )
        var liczbaPunktow = 0
        var aktualnePytanie = 0

        fun ustawPoczatkowyStanPytan(){
            pytanie.text = pytaniaLista[0].pytanie
            odpowiedz1.text = pytaniaLista[0].odpowiedzi[0]
            odpowiedz2.text = pytaniaLista[0].odpowiedzi[1]
            odpowiedz3.text = pytaniaLista[0].odpowiedzi[2]
            image.setImageResource(pytaniaLista[0].obraz)
        }
        ustawPoczatkowyStanPytan()

        fun ustawNastepnePytanie(){
            when (aktualnePytanie){
                0-> {
                    pytanie.text = pytaniaLista[1].pytanie
                    odpowiedz1.text = pytaniaLista[1].odpowiedzi[0]
                    odpowiedz2.text = pytaniaLista[1].odpowiedzi[1]
                    odpowiedz3.text = pytaniaLista[1].odpowiedzi[2]
                    image.setImageResource(pytaniaLista[1].obraz)
                    aktualnePytanie+=1
                    odpowiedzGrupa.clearCheck()
                    if (odpowiedz1.isChecked && odpowiedz1.text == pytaniaLista[0].odpowiedzPoprawna) liczbaPunktow+=1
                    else if (odpowiedz2.isChecked && odpowiedz2.text == pytaniaLista[0].odpowiedzPoprawna) liczbaPunktow+=1
                    else if (odpowiedz3.isChecked && odpowiedz3.text == pytaniaLista[0].odpowiedzPoprawna) liczbaPunktow+=1

                }
                1 -> {
                    pytanie.text = pytaniaLista[2].pytanie
                    odpowiedz1.text = pytaniaLista[2].odpowiedzi[0]
                    odpowiedz2.text = pytaniaLista[2].odpowiedzi[1]
                    odpowiedz3.text = pytaniaLista[2].odpowiedzi[2]
                    image.setImageResource(pytaniaLista[2].obraz)
                    aktualnePytanie+=1
                    odpowiedzGrupa.clearCheck()
                    if (odpowiedz1.isChecked && odpowiedz1.text == pytaniaLista[1].odpowiedzPoprawna) liczbaPunktow+=1
                    else if (odpowiedz2.isChecked && odpowiedz2.text == pytaniaLista[1].odpowiedzPoprawna) liczbaPunktow+=1
                    else if (odpowiedz3.isChecked && odpowiedz3.text == pytaniaLista[1].odpowiedzPoprawna) liczbaPunktow+=1
                }
                2 -> {
                    pytanie.text = pytaniaLista[0].pytanie
                    odpowiedz1.text = pytaniaLista[0].odpowiedzi[0]
                    odpowiedz2.text = pytaniaLista[0].odpowiedzi[1]
                    odpowiedz3.text = pytaniaLista[0].odpowiedzi[2]
                    image.setImageResource(pytaniaLista[0].obraz)
                    aktualnePytanie = 0
                    odpowiedzGrupa.clearCheck()
                    if (odpowiedz1.isChecked && odpowiedz1.text == pytaniaLista[2].odpowiedzPoprawna) liczbaPunktow+=1
                    else if (odpowiedz2.isChecked && odpowiedz2.text == pytaniaLista[2].odpowiedzPoprawna) liczbaPunktow+=1
                    else if (odpowiedz3.isChecked && odpowiedz3.text == pytaniaLista[2].odpowiedzPoprawna) liczbaPunktow+=1
                }
            }
        }

        button.setOnClickListener {
            for (i in 0..<pytaniaLista.size-1){
               if(i == aktualnePytanie){
                   pytanie.text = pytaniaLista[i+1].pytanie
                   odpowiedz1.text = pytaniaLista[i+1].odpowiedzi[0]
                   odpowiedz2.text = pytaniaLista[i+1].odpowiedzi[1]
                   odpowiedz3.text = pytaniaLista[i+1].odpowiedzi[2]
                   image.setImageResource(pytaniaLista[i+1].obraz)
                   odpowiedzGrupa.clearCheck()
                   if (odpowiedz1.isChecked && odpowiedz1.text == pytaniaLista[i].odpowiedzPoprawna) liczbaPunktow+=1
                   else if (odpowiedz2.isChecked && odpowiedz2.text == pytaniaLista[i].odpowiedzPoprawna) liczbaPunktow+=1
                   else if (odpowiedz3.isChecked && odpowiedz3.text == pytaniaLista[i].odpowiedzPoprawna) liczbaPunktow+=1
               }
                else if(aktualnePytanie==pytaniaLista.size-1){
                   aktualnePytanie = 0
                   pytanie.text = pytaniaLista[0].pytanie
                   odpowiedz1.text = pytaniaLista[0].odpowiedzi[0]
                   odpowiedz2.text = pytaniaLista[0].odpowiedzi[1]
                   odpowiedz3.text = pytaniaLista[0].odpowiedzi[2]
                   image.setImageResource(pytaniaLista[0].obraz)
                   odpowiedzGrupa.clearCheck()
                   if (odpowiedz1.isChecked && odpowiedz1.text == pytaniaLista[2].odpowiedzPoprawna) liczbaPunktow+=1
                   else if (odpowiedz2.isChecked && odpowiedz2.text == pytaniaLista[2].odpowiedzPoprawna) liczbaPunktow+=1
                   else if (odpowiedz3.isChecked && odpowiedz3.text == pytaniaLista[2].odpowiedzPoprawna) liczbaPunktow+=1
               }
            }
            aktualnePytanie+=1
        }
    }
}

class Pytanie(
    var pytanie: String,
    var odpowiedzi: List<String>,
    var odpowiedzPoprawna: String,
    var obraz: Int
)