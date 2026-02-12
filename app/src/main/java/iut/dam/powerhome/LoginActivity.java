package iut.dam.powerhome;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    // ========== Déclaration des éléments de l'interface ==========
    private ImageView backArrow;
    private EditText emailInput;
    private EditText passwordInput;
    private Button loginButton;
    private TextView forgotPasswordLink;
    private TextView createAccountLink;
    private LinearLayout facebookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialiser les vues
        initializeViews();

        // Configurer les écouteurs d'événements
        setupListeners();
    }

    public void func(View view) {
        Log.i("LoginActivity:func", "Button clicked!");
    }

    /**
     * Initialise tous les éléments de l'interface
     */
    private void initializeViews() {
        backArrow = findViewById(R.id.backArrow);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        forgotPasswordLink = findViewById(R.id.forgotPasswordLink);
        createAccountLink = findViewById(R.id.createAccountLink);
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

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });

        forgotPasswordLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleForgotPassword();
            }
        });

        createAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCreateAccount();
            }
        });

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleFacebookLogin();
            }
        });
    }

    private void handleLogin() {
        // Récupérer les valeurs des champs
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString();

        // Validation des identifiants (abcd & p: EFGH)
        if (email.equals("abcd") && password.equals("EFGH")) {
            // Identifiants corrects, naviguer vers MainActivity
            navigateToMainActivity(email, password);
        } else {
            // Identifiants incorrects
            Toast.makeText(this, "Identifiant ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Gère le clic sur "Mot de passe oublié"
     */
    private void handleForgotPassword() {
        // TODO: Afficher un dialog ou naviguer vers une activité de récupération
    }

    /**
     * Gère le clic sur "Créer un compte"
     */
    private void handleCreateAccount() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    /**
     * Gère la connexion via Facebook
     */
    private void handleFacebookLogin() {
        // TODO: Implémenter la connexion Facebook
    }

    /**
     * Navigate vers HabitatActivity après connexion réussie
     */
    private void navigateToMainActivity(String email, String password) {
        Intent intent = new Intent(this, HabitatActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email", email);
        bundle.putString("password", password);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
