package uteq.solutions.contenedores1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import Adaptadores.AdaptadorNoticias;
import Clases.Noticia;

public class MainActivity2 extends AppCompatActivity implements
        AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Data
        Noticia[] noticias =
                new Noticia[]{
                        new Noticia("Noticia 1", "SubNoticia Contenido  Contenido Contenido Contenido  1"),
                        new Noticia("Noticia 2", "SubNoticia Contenido  Contenido Contenido Contenido  2"),
                        new Noticia("Noticia 3", "SubNoticia Contenido  Contenido Contenido Contenido  3"),
                        new Noticia("Noticia 4", "SubNoticia Contenido  Contenido Contenido Contenido  4")};

        AdaptadorNoticias adaptadornoticias = new AdaptadorNoticias(this, noticias);
        ListView lstOpciones = (ListView)findViewById(R.id.lstListaNoticias);
        lstOpciones.setAdapter(adaptadornoticias);

        //asigno el encaezado
        View header = getLayoutInflater().inflate(R.layout.lyencabezado, null);
        lstOpciones.addHeaderView(header);

        lstOpciones.setOnItemClickListener(this);



    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(this,"Item Seleccionado: " + ((Noticia)adapterView.getItemAtPosition(i)).getTitulo() ,
                Toast.LENGTH_LONG).show();


    }
}