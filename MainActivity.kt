package com.andresfuster.pratica1masa

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.andresfuster.pratica1masa.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            btnCalculo.setOnClickListener {
                var Altura: Double = NumeroC.text.toString().toDouble();
                var Peso: Double = NumeroD.text.toString().toDouble();
                var IMC: Double = NumeroC.text.toString().toDouble() /
                        (NumeroC.text.toString().toDouble() * 2);
                if (NumeroC.text.isEmpty() || NumeroD.text.isEmpty()){
                    val text = "Escribe un valor para calcular el IMC"
                    val duration = Toast.LENGTH_SHORT
                    Toast.makeText(applicationContext, text, duration).show()
                }else{
                        txtResul.text = IMC.toString();
                }

                if (rbHombre.isChecked){
                    when(IMC > 0.0){
                        IMC < 18.5 -> txtInfo.text == "Peso inferior al normal"
                        IMC >= 18.5 -> txtInfo.text == "Normal"
                        IMC <= 24.9 -> txtInfo.text == "Normal"
                        IMC >= 25.0 -> txtInfo.text == "Sobrepeso"
                        IMC <= 29.9 -> txtInfo.text == "Sobrepeso"
                        IMC > 30.0 -> txtInfo.text == "Obesidad"
                    }
                }else if(rbMujer.isChecked){
                    when(IMC > 0.0) {
                        IMC < 18.5 -> txtInfo.text == "Peso inferior al normal"
                        IMC >= 18.5 -> txtInfo.text == "Normal"
                        IMC <= 23.9 -> txtInfo.text == "Normal"
                        IMC >= 24.0 -> txtInfo.text == "Sobrepeso"
                        IMC <= 28.9 -> txtInfo.text == "Sobrepeso"
                        IMC > 29.0 -> txtInfo.text == "Obesidad"
                    }
                }
            }
        }
    }
}