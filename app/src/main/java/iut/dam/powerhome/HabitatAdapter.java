package iut.dam.powerhome;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class HabitatAdapter extends ArrayAdapter<Habitat> {

    private Activity activity;
    private int itemResId;
    private List<Habitat> items;

    public HabitatAdapter(Activity activity, int itemResId, List<Habitat> items) {
        super(activity, itemResId, items);
        this.activity = activity;
        this.itemResId = itemResId;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout = convertView;
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            layout = inflater.inflate(itemResId, parent, false);
        }

        // Récupérer les vues
        TextView residentNameTV = layout.findViewById(R.id.tv_resident_name);
        TextView floorTV = layout.findViewById(R.id.tv_floor);
        TextView applianceCountTV = layout.findViewById(R.id.tv_appliance_count);
        LinearLayout applianceIconsLL = layout.findViewById(R.id.ll_appliance_icons);

        // Récupérer l'habitat à cette position
        Habitat habitat = items.get(position);

        // Remplir les vues avec les données
        residentNameTV.setText(habitat.getResidentName());
        floorTV.setText(String.valueOf(habitat.getFloor()));

        int count = habitat.getApplianceCount();
        if (count == 0) {
            applianceCountTV.setText("Aucun équipement");
        } else if (count == 1) {
            applianceCountTV.setText("1 équipement");
        } else {
            applianceCountTV.setText(count + " équipements");
        }

        // Ajouter les icônes d'équipements
        applianceIconsLL.removeAllViews();
        List<Appliance> appliances = habitat.getAppliances();
        for (int i = 0; i < appliances.size(); i++) {
            Appliance appliance = appliances.get(i);
            ImageView iconIV = new ImageView(activity);

            // Choisir l'icône en fonction du type d'équipement
            int iconRes = getIconForAppliance(appliance.getName());
            iconIV.setImageResource(iconRes);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                dpToPx(16),
                dpToPx(16)
            );
            if (i > 0) {
                params.setMarginStart(dpToPx(4));
            }
            iconIV.setLayoutParams(params);

            applianceIconsLL.addView(iconIV);
        }

        return layout;
    }

    /**
     * Convertit les dp en pixels
     */
    private int dpToPx(int dp) {
        float density = activity.getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

    /**
     * Retourne l'icône appropriée pour un équipement donné
     */
    private int getIconForAppliance(String applianceName) {
        String nameLower = applianceName.toLowerCase();

        if (nameLower.contains("machine") && nameLower.contains("laver")) {
            return R.drawable.ic_machine_a_laver;
        } else if (nameLower.contains("aspirateur")) {
            return R.drawable.ic_aspirateur;
        } else if (nameLower.contains("climatiseur")) {
            return R.drawable.ic_climatiseur;
        } else if (nameLower.contains("fer") && nameLower.contains("repasser")) {
            return R.drawable.ic_fer_a_repasser;
        } else {
            // Par défaut, utiliser l'icône machine à laver
            return R.drawable.ic_machine_a_laver;
        }
    }
}
