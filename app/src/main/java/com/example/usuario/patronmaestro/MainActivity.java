package com.example.usuario.patronmaestro;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements dialogfragment.OnFragmentInteractionListener,prueba.OnFragmentInteractionListener {
 Toolbar toolbar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.ir);

        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
                dialogfragment galeria = new dialogfragment();
               galeria.setStyle(dialogfragment.STYLE_NO_FRAME,R.style.transparente);
                galeria.show(manager,"");
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
