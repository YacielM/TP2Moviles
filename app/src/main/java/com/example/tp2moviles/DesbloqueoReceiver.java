package com.example.tp2moviles;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class DesbloqueoReceiver extends BroadcastReceiver {
    private static final String TAG = "DesbloqueoReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_USER_PRESENT.equals(intent.getAction())) {
            // 1) Toast
            Toast.makeText(context, "Pantalla desbloqueada detectada", Toast.LENGTH_LONG).show();

            // 2) Logcat
            Log.d(TAG, "Evento ACTION_USER_PRESENT recibido");

            // 3) Abrir app de llamadas con número (ACTION_DIAL evita permisos)
            Intent dial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:2664553747"));
            dial.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
                context.startActivity(dial);
            } catch (Exception e) {
                Log.e(TAG, "No se pudo abrir la app de llamadas", e);
            }
        }
    }
}
