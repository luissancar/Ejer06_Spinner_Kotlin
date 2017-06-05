package com.example.luissancar.ejer06_spinner_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinnerAdapter=ArrayAdapter.createFromResource(this,R.array.operacion,android.R.layout.simple_spinner_item)
        spinner.adapter=spinnerAdapter


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                val selected = parent.getItemAtPosition(pos).toString()
                if (op1.text.toString().isEmpty())
                    op1.setText("0")
                if (op2.text.toString().isEmpty())
                    op2.setText("0")
                val o1=op1.text.toString().toInt()
                val o2=op2.text.toString().toInt()
                var res:Int=0
                when (selected) {
                    "Suma"->res=o1+o2
                    "Resta"->res=o1-o2
                    "Multiplica"->res=o1*o2
                    "Divide"->if (o2==0) {
                                res = -1
                                val context = applicationContext
                                Toast.makeText(context,"Divión por 0",Toast.LENGTH_LONG).show()
                            }
                              else
                                res=o1/o2

                }
                resulado.text=res.toString()

            }


            override fun onNothingSelected(parent: AdapterView<out Adapter>?) {
            }

        }


    }
}
