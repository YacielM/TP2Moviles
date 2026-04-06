package com.example.tp2moviles;

import android.content.IntentFilter;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private DesbloqueoReceiver desbloqueoReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        desbloqueoReceiver = new DesbloqueoReceiver();
        IntentFilter filter = new IntentFilter(android.content.Intent.ACTION_USER_PRESENT);
        registerReceiver(desbloqueoReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (desbloqueoReceiver != null) {
            unregisterReceiver(desbloqueoReceiver);
            desbloqueoReceiver = null;
        }
    }
}