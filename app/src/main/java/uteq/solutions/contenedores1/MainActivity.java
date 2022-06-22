package uteq.solutions.contenedores1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{

    TextView txtItemSel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.- Datos
        final String[] datos =
                new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};
        //2.- Adaptador
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //3.- Enlazar el Adaptador con la Vista (Spinner)
        Spinner cmbOpciones = (Spinner)findViewById(R.id.cbOpciones);
        cmbOpciones.setAdapter(adaptador);

        cmbOpciones.setOnItemSelectedListener(this);

        txtItemSel = (TextView)findViewById(R.id.txtItemSeleccionado);


        ArrayAdapter<String> adaptador2 =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, datos);
        ListView lstOpciones = (ListView)findViewById(R.id.lstLista);
        lstOpciones.setAdapter(adaptador2);



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        txtItemSel.setText("Item Seleccionado: " + adapterView.getItemAtPosition(i));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        txtItemSel.setText("No hay Item Seleccionado ");
    }
}