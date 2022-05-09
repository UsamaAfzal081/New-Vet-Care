package com.example.musicplayer;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class dashboard extends Activity {

    public void onClick(View view) {
        Intent intent = new Intent(dashboard.this, MainActivity.class);
        startActivity(intent);
    }
}