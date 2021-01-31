package com.example.app.ui.courses.guest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.app.R;
import com.example.app.controller.GuestController;
import com.example.app.tools.MainAdapter;
import com.example.core.model.persistence.fakes.FakeAccountRepository;

public class GuestDatasikkerhetActivity extends AppCompatActivity {

    private GuestController guestController;
    private TextView course;
    private TextView message;
    private ExpandableListView messages;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_datasikkerhet);
        config();
    }

    private void config() {
        guestController = new GuestController(new FakeAccountRepository());
        course = findViewById(R.id.coursecodeTV);
        message = findViewById(R.id.messagesTV);
        messages = findViewById(R.id.exp_list_view);

        adapter = guestController.getMessageComments("ITF25019-1 21V");
        messages.setAdapter(adapter);
    }

}