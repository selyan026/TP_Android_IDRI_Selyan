package iut.dam.powerhome;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ApplianceDialogAdapter extends ArrayAdapter<Appliance> {

    private Context context;
    private List<Appliance> appliances;

    public ApplianceDialogAdapter(Context context, List<Appliance> appliances) {
        super(context, R.layout.item_equipement_dialog, appliances);
        this.context = context;
        this.appliances = appliances;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.item_equipement_dialog, parent, false);
        }

        Appliance appliance = appliances.get(position);

        TextView nameTV = view.findViewById(R.id.tv_equipement_name);
        TextView referenceTV = view.findViewById(R.id.tv_equipement_reference);
        TextView powerTV = view.findViewById(R.id.tv_equipement_power);
        View energyIndicator = view.findViewById(R.id.view_energy_indicator);

        nameTV.setText(appliance.getName());
        referenceTV.setText("Référence: " + appliance.getReference());
        powerTV.setText("Puissance: " + appliance.getPower() + " W");

        // Déterminer la couleur en fonction de la puissance
        int power = appliance.getPower();
        int color;

        if (power < 1000) {
            color = Color.parseColor("#4CAF50"); // Vert - Faible
        } else if (power < 2000) {
            color = Color.parseColor("#FF9800"); // Orange - Moyen
        } else {
            color = Color.parseColor("#FF5722"); // Rouge - Élevé
        }

        energyIndicator.setBackgroundColor(color);

        return view;
    }
}