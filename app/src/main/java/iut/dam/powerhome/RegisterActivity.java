package iut.dam.powerhome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    // ========== Déclaration des éléments de l'interface ==========
    private ImageView backArrow;
    private EditText nomInput;
    private EditText prenomInput;
    private EditText emailInput;
    private EditText passwordInput;
    private EditText confirmPasswordInput;
    private Button registerButton;
    private TextView loginLink;
    private LinearLayout facebookButton;

    // ========== Patterns de validation ==========
    // Nom et Prénom: alphabétique, 2 à 25 lettres
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-ZÀ-ÿ]{2,25}$");
    // Email: format email valide
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    // Mot de passe: alphanumérique + symboles, min 8 caractères
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9@#$%^&+=!]{8,}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialiser les vues
        initializeViews();

        // Configurer les écouteurs d'événements
        setupListeners();
    }

    /**
     * Initialise tous les éléments de l'interface
     */
    private void initializeViews() {
        backArrow = findViewById(R.id.backArrow);
        nomInput = findViewById(R.id.nomInput);
        prenomInput = findViewById(R.id.prenomInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        registerButton = findViewById(R.id.registerButton);
        loginLink = findViewById(R.id.loginLink);
        facebookButton = findViewById(R.id.facebookButton);
    }

    /**
     * Configure les écouteurs de clics pour tous les boutons et liens
     */
    private void setupListeners() {
        // Flèche retour
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRegister();
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLoginLink();
            }
        });

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleFacebookRegister();
            }
        });
    }

    /**
     * Gère la validation de l'inscription
     */
    private void handleRegister() {
        // Récupérer les valeurs des champs
        String nom = nomInput.getText().toString().trim();
        String prenom = prenomInput.getText().toString().trim();
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString();
        String confirmPassword = confirmPasswordInput.getText().toString();

        // Validation du nom
        if (!NAME_PATTERN.matcher(nom).matches()) {
            Toast.makeText(this, "Le nom doit contenir entre 2 et 25 lettres alphabétiques", Toast.LENGTH_SHORT).show();
            nomInput.requestFocus();
            return;
        }

        // Validation du prénom
        if (!NAME_PATTERN.matcher(prenom).matches()) {
            Toast.makeText(this, "Le prénom doit contenir entre 2 et 25 lettres alphabétiques", Toast.LENGTH_SHORT).show();
            prenomInput.requestFocus();
            return;
        }

        // Validation de l'email
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            Toast.makeText(this, "Veuillez entrer un email valide", Toast.LENGTH_SHORT).show();
            emailInput.requestFocus();
            return;
        }

        // Validation du mot de passe
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            Toast.makeText(this, "Le mot de passe doit contenir au moins 8 caractères (lettres, chiffres et symboles)", Toast.LENGTH_SHORT).show();
            passwordInput.requestFocus();
            return;
        }

        // Vérification de la confirmation du mot de passe
        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT).show();
            confirmPasswordInput.requestFocus();
            return;
        }

        // Si toutes les validations passent, naviguer vers MainActivity
        navigateToMainActivity(nom, prenom, email, password);
    }

    /**
     * Gère le clic sur "Se connecter" (retour au login)
     */
    private void handleLoginLink() {
        // Retour à l'activité de connexion
        finish();
    }

    /**
     * Gère l'inscription via Facebook
     */
    private void handleFacebookRegister() {
        // TODO: Implémenter l'inscription Facebook
    }

    /**
     * Navigate vers MainActivity après inscription réussie
     */
    private void navigateToMainActivity(String nom, String prenom, String email, String password) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("nom", nom);
        intent.putExtra("prenom", prenom);
        intent.putExtra("email", email);
        intent.putExtra("password", password);
        startActivity(intent);
        finish();
    }
}
