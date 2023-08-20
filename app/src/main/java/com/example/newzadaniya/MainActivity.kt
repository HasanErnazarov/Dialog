package com.example.newzadaniya

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initviews()
    }

    private fun initviews() {
        val bSimple = findViewById<Button>(R.id.bt_simple)
        val bCustom = findViewById<Button>(R.id.bt_custom)
        val btDone = findViewById<Button>(R.id.bt_done)

        val dialog = Dialog(this)



        bSimple.setOnClickListener {

            val dialog = AlertDialog.Builder(this)

            dialog.setMessage("Bu yerda ustang bor")
            dialog.setCancelable(true)
            dialog.setTitle("Reklama sarlavhasi")
            dialog.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@MainActivity, "Yes tugmasi bosildi", Toast.LENGTH_SHORT)
                        .show()
                }
            })

            dialog.setNegativeButton("no", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@MainActivity, "NO tugmasi bosildi", Toast.LENGTH_SHORT)
                        .show()
                }
            })

            dialog.show()

        }


        bCustom.setOnClickListener {
            dialog.setContentView(R.layout.custom_dialog)
            dialog.setCancelable(false)

            val etValue = dialog.findViewById<EditText>(R.id.et_qidir)
            val bDone = dialog.findViewById<Button>(R.id.bt_done)
            val ivCansel = dialog.findViewById<ImageView>(R.id.iv_cancel)
            ivCansel.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()

        }

    }
}