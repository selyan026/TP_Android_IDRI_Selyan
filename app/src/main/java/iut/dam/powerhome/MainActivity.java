package iut.dam.powerhome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView nomTextView;
    private TextView prenomTextView;
    private TextView emailTextView;
    private TextView passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialiser les vues
        nomTextView = findViewById(R.id.nomTextView);
        prenomTextView = findViewById(R.id.prenomTextView);
        emailTextView = findViewById(R.id.emailTextView);
        passwordTextView = findViewById(R.id.passwordTextView);

        // Récupérer les données de l'Intent
        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            Bundle bundle = intent.getExtras();

            // Vérifier si les données proviennent de RegisterActivity
            String nom = bundle.getString("nom");
            String prenom = bundle.getString("prenom");

            if (nom != null && prenom != null) {
                // Données de RegisterActivity
                nomTextView.setText("Nom: " + nom);
                prenomTextView.setText("Prénom: " + prenom);
                nomTextView.setVisibility(View.VISIBLE);
                prenomTextView.setVisibility(View.VISIBLE);

                String email = bundle.getString("email");
                String password = bundle.getString("password");
                emailTextView.setText("Email: " + email);
                passwordTextView.setText("Mot de passe: " + password);
            } else {
                // Données de LoginActivity
                String email = bundle.getString("email");
                String password = bundle.getString("password");
                emailTextView.setText("Identifiant: " + email);
                passwordTextView.setText("Mot de passe: " + password);
            }
        }
    }
}