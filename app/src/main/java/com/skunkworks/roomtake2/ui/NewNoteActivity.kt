package com.skunkworks.roomtake2.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import com.skunkworks.roomtake2.R
import com.skunkworks.roomtake2.db.Note
import kotlinx.android.synthetic.main.activity_new_note.*
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class NewNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)


        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(edit_note.text) || TextUtils.isEmpty(edit_title.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val title = edit_title.text.toString()
                val note = edit_note.text.toString()
                val notea = Note(title,note)
                replyIntent.putExtra(EXTRA_REPLY, notea)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }

}