package com.example.chat_apps

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ListChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_chat)

        val listView: ListView = findViewById(R.id.listView)


        val chats = listOf(
            "Yo, what's good?!",
            "Ayy, you good fam?",
            "Yo, you tryna link up later?",
            "Stay up, we got this!",
            "Ain't nobody messin' with us, for real!"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, chats)
        listView.adapter = adapter
    }
}
