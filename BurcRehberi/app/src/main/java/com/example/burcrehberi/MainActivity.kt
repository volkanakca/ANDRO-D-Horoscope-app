package com.example.burcrehberi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var tumBurcBilgileri:ArrayList<Burc>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor=resources.getColor(R.color.statusBarColor)

        veriKaynagihazirla()




        var myBaseAdapter=BurclarBaseAdapter(this,tumBurcBilgileri)
        listBurclar.adapter=myBaseAdapter
        listBurclar.setOnItemClickListener { parent, view, position, id ->
         var intent= Intent(this@MainActivity,DetayActivity2::class.java)
            intent.putExtra("tıklanılkanOgePosition",position)
            intent.putExtra("tumBurcBilgileri",tumBurcBilgileri)
            startActivity(intent)
        }






    }

    private fun veriKaynagihazirla() {
        tumBurcBilgileri=ArrayList<Burc>(12)
        var burclar=resources.getStringArray(R.array.burclar)
        var burcTarihleri=resources.getStringArray(R.array.burcTarih)
        var burcResimleri=arrayOf(R.drawable.koc,R.drawable.boga,R.drawable.ikizler,R.drawable.yengec,R.drawable.aslan,R.drawable.basak,R.drawable.terazi,R.drawable.akrep,R.drawable.yay,R.drawable.oglak,R.drawable.kova,R.drawable.balik)
        var burcBuyukResimleri=arrayOf(R.drawable.kocbuyuk,R.drawable.bogabuyuk,R.drawable.ikizlerbuyuk,R.drawable.yengecburcubuyuk,R.drawable.aslanbuyuk,R.drawable.basakbuyuk,R.drawable.terazibuyuk,R.drawable.akrepbuyuk,R.drawable.yaybuyuk,R.drawable.oglakbuyuk,R.drawable.kovabuyuk,R.drawable.balikbuyuk)
        var burcGenelOzellikler=resources.getStringArray(R.array.burcGenelOzellikller)
        for(i in 0..11){
            var arrayListeAtanacakBurc=Burc(burclar[i],burcTarihleri[i],burcResimleri[i],burcBuyukResimleri[i],burcGenelOzellikler[i])

             tumBurcBilgileri.add(arrayListeAtanacakBurc)
        }


    }
}