package com.example.chat_apps;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;

public class ListChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_chat);

        ListView listView = findViewById(R.id.listView);
        // Percakapan menggunakan bahasa slang khas Amerika kulit hitam
        String[] chats = {
                "Yo, what's good?!",
                "Ayy, you good fam?",
                "Yo, you tryna link up later?",
                "Stay up, we got this!",
                "Ain't nobody messin' with us, for real!"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chats);
        listView.setAdapter(adapter);
    }
}
