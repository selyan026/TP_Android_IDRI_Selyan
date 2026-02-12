package iut.dam.powerhome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    // Durée d'affichage du splash screen en millisecondes (3 secondes)
    private static final int SPLASH_DURATION = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Utiliser un Handler pour attendre 3 secondes puis passer à LoginActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Créer une intention pour ouvrir LoginActivity
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DURATION);
    }
}