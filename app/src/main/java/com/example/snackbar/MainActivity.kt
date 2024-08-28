package com.example.snackbar
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var inputField: EditText
    private lateinit var outputField: TextView
    private lateinit var saveButton: Button
    private lateinit var deleteButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputField = findViewById(R.id.inputField)
        outputField = findViewById(R.id.outputField)
        saveButton = findViewById(R.id.saveButton)
        deleteButton = findViewById(R.id.deleteButton)

        saveButton.setOnClickListener {
            val inputText = inputField.text.toString()
            outputField.text = inputText
        }

        deleteButton.setOnClickListener {
            showDeleteConfirmationDialog()
        }
    }

    private fun showDeleteConfirmationDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Подтвердите удаление")
            .setPositiveButton("Удалить") { _, _ ->
                outputField.text = ""
                Snackbar.make(findViewById(android.R.id.content), "Данные удалены", Snackbar.LENGTH_SHORT).show()
            }
            .setNegativeButton("Отмена", null)
        builder.create().show()
    }
}