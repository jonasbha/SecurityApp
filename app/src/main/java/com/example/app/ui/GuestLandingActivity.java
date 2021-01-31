package com.example.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.controller.GuestController;
import com.example.app.ui.courses.guest.GuestDatasikkerhetActivity;
import com.example.core.model.persistence.fakes.FakeAccountRepository;

public class GuestLandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_landing);
        config();
    }

    private void config() {
        GuestController guestController = new GuestController(new FakeAccountRepository());
        TextView course = findViewById(R.id.courseTV);
        ListView courses = findViewById(R.id.coursesLV);

        courses.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, guestController.getCourseEntries()));

        courses.setOnItemClickListener((parent, view, position, id) -> {
            if (position == 0) {
                startActivity(new Intent(GuestLandingActivity.this, GuestDatasikkerhetActivity.class));
            }
        });
    }
}