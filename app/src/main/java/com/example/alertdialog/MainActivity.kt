package com.example.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.btnDialog1)
        val button2 = findViewById<Button>(R.id.btnDialog2)
        val button3 = findViewById<Button>(R.id.btnDialog3)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add contact")
            .setMessage("Do you want to add John to your contact list?")
            .setIcon(R.drawable.ic_add_person)
            .setPositiveButton("Yes") { _, _ ->  // não estamos usando os parâmetros nessa função lambda
                Toast.makeText(this, "You added John to your contact list", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "You didn't add John to your contact list", Toast.LENGTH_SHORT).show()
            }
            .create()

        button1.setOnClickListener {
            addContactDialog.show()
        }

        val options = arrayOf("First item", "Second item", "Third item")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options:")
            .setSingleChoiceItems(options, 0) { dialogInterface, i ->
                Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") { _, _ ->  // não estamos usando os parâmetros nessa função lambda
                Toast.makeText(this, "You accepted the SingleChoiceDialog", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You declined the SingleChoiceDialog", Toast.LENGTH_SHORT).show()
            }.create()

        button2.setOnClickListener {
            singleChoiceDialog.show()
        }

        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose your options:")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) {_, i, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "You checked ${options[i]}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "You unchecked ${options[i]}", Toast.LENGTH_SHORT).show()

                }
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You accepted the MultiChoiceDialog", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You declined the MultiChoiceDialog", Toast.LENGTH_SHORT).show()
            }.create()

        button3.setOnClickListener {
            multiChoiceDialog.show()
        }
    }
}