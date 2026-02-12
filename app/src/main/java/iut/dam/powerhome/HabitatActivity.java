package iut.dam.powerhome;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class HabitatActivity extends AppCompatActivity {

    private ListView habitatsLV;
    private HabitatAdapter adapter;
    private List<Habitat> habitats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habitat);

        // Initialiser les vues
        habitatsLV = findViewById(R.id.lv_habitats);

        // Initialiser les données d'habitats
        initializeHabitats();

        // Créer et configurer l'adaptateur
        adapter = new HabitatAdapter(this, R.layout.item_habitat, habitats);
        habitatsLV.setAdapter(adapter);

        // Configurer le listener de clic sur les items
        habitatsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Habitat habitat = habitats.get(position);
                showHabitatDetailsDialog(habitat);
            }
        });
    }

    /**
     * Affiche une boîte de dialogue avec les détails de l'habitat
     */
    private void showHabitatDetailsDialog(Habitat habitat) {
        // Créer le dialogue
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_habitat_details);
        dialog.getWindow().setLayout(
                (int) (getResources().getDisplayMetrics().widthPixels * 0.9),
                (int) (getResources().getDisplayMetrics().heightPixels * 0.7)
        );

        // Récupérer les vues
        TextView nomTV = dialog.findViewById(R.id.tv_dialog_nom);
        TextView prenomTV = dialog.findViewById(R.id.tv_dialog_prenom);
        TextView surfaceTV = dialog.findViewById(R.id.tv_dialog_surface);
        TextView etageTV = dialog.findViewById(R.id.tv_dialog_etage);
        ListView equipementsLV = dialog.findViewById(R.id.lv_dialog_equipements);
        Button closeBtn = dialog.findViewById(R.id.btn_dialog_close);

        // Séparer le nom complet en nom et prénom
        String[] nameParts = habitat.getResidentName().split(" ");
        String prenom = nameParts.length > 0 ? nameParts[0] : "";
        String nom = nameParts.length > 1 ? nameParts[1] : "";

        // Remplir les données
        nomTV.setText(nom);
        prenomTV.setText(prenom);
        surfaceTV.setText(habitat.getArea() + " m²");
        etageTV.setText(String.valueOf(habitat.getFloor()));

        // Configurer la liste des équipements
        ApplianceDialogAdapter applianceAdapter = new ApplianceDialogAdapter(
                this,
                habitat.getAppliances()
        );
        equipementsLV.setAdapter(applianceAdapter);

        // Configurer le bouton de fermeture
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        // Afficher le dialogue
        dialog.show();
    }

    /**
     * Initialise la liste des habitats avec des données d'exemple
     */
    private void initializeHabitats() {
        habitats = new ArrayList<>();

        // Habitat 1 - Gaëtan Leclair
        Habitat h1 = new Habitat(1, "Gaëtan Leclair", 1, 45.5);
        h1.addAppliance(new Appliance(1, "Machine à laver", "MAL-001", 2200));
        h1.addAppliance(new Appliance(2, "Aspirateur", "ASP-001", 1500));
        h1.addAppliance(new Appliance(3, "Climatiseur", "CLM-001", 1800));
        h1.addAppliance(new Appliance(4, "Fer à repasser", "FER-001", 2000));
        habitats.add(h1);

        // Habitat 2 - Cédric Boudet
        Habitat h2 = new Habitat(2, "Cédric Boudet", 1, 38.0);
        h2.addAppliance(new Appliance(5, "Aspirateur", "ASP-002", 1500));
        habitats.add(h2);

        // Habitat 3 - Gaylord Thibodeaux
        Habitat h3 = new Habitat(3, "Gaylord Thibodeaux", 2, 52.3);
        h3.addAppliance(new Appliance(6, "Climatiseur", "CLM-002", 1800));
        h3.addAppliance(new Appliance(7, "Machine à laver", "MAL-002", 2200));
        habitats.add(h3);

        // Habitat 4 - Adam Jacquinot
        Habitat h4 = new Habitat(4, "Adam Jacquinot", 3, 60.0);
        h4.addAppliance(new Appliance(8, "Fer à repasser", "FER-002", 2000));
        h4.addAppliance(new Appliance(9, "Aspirateur", "ASP-003", 1500));
        h4.addAppliance(new Appliance(10, "Climatiseur", "CLM-003", 1800));
        habitats.add(h4);

        // Habitat 5 - Abel Fresnel
        Habitat h5 = new Habitat(5, "Abel Fresnel", 3, 42.0);
        h5.addAppliance(new Appliance(11, "Machine à laver", "MAL-003", 2200));
        habitats.add(h5);
    }
}