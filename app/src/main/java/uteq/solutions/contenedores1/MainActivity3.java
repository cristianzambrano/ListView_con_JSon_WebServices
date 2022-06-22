package uteq.solutions.contenedores1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Adaptadores.AdaptadorUsuarios;
import Clases.Usuario;
import WebService.WebService;
import WebService.Asynchtask;

public class MainActivity3 extends AppCompatActivity
        implements Asynchtask {

    ListView lstUsuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://reqres.in/api/users",
                datos, MainActivity3.this,MainActivity3.this);
        ws.execute("GET");


        lstUsuarios = (ListView)findViewById(R.id.lstUsuarios);

        View header = getLayoutInflater().inflate(R.layout.lyencabezado, null);
        lstUsuarios.addHeaderView(header);

    }

    @Override
    public void processFinish(String result) throws JSONException {

        JSONObject JSONlista =  new JSONObject(result);
        JSONArray JSONlistaUsuarios=  JSONlista.getJSONArray("data");

        ArrayList<Usuario>  datosUsuarios = Usuario.JsonObjectsBuild(JSONlistaUsuarios);

        AdaptadorUsuarios adapatorUsuario = new AdaptadorUsuarios(this, datosUsuarios);

        lstUsuarios.setAdapter(adapatorUsuario);
        //Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}