package com.iesb.tcc.amberbr.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
//import com.google.android.gms.common.api.GoogleApiClient;
import com.iesb.tcc.amberbr.R;
import com.iesb.tcc.amberbr.activity.adapters.ListaAlertasPageAdapter;
import com.iesb.tcc.amberbr.activity.fragments.AlertasEncerradosFragment;
import com.iesb.tcc.amberbr.activity.fragments.AlertasRecentesFragment;
import com.iesb.tcc.amberbr.core.ConfiguracaoDAO;
import com.iesb.tcc.amberbr.core.MainDefaultValues;
import com.iesb.tcc.amberbr.core.MainRules;
import com.iesb.tcc.amberbr.entity.Alerta;
import com.iesb.tcc.amberbr.entity.Configuracao;
import com.iesb.tcc.amberbr.entity.Usuario;
import com.iesb.tcc.amberbr.exceptions.GenericBusinessException;
import com.iesb.tcc.amberbr.exceptions.GenericDatabaseException;

import java.util.ArrayList;
import java.util.List;

public class ListaAlertasActivity extends AppCompatActivity implements AlertasEncerradosFragment.OnFragmentInteractionListener,
        AlertasRecentesFragment.OnFragmentInteractionListener {

    private MainRules amberManager;

    /**
     * The {@link PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link FragmentStatePagerAdapter}.
     */
    //private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    //private GoogleApiClient client;

    private LocationManager mlocManager;
    private LocationListener mlocListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (this.amberManager == null){
            try {
                amberManager = new MainRules(this);
            } catch (GenericBusinessException e) {
                trataGenericBusinessException(e);
            }
        }


/*
        ConfiguracaoDAO configuracaoDAO = new ConfiguracaoDAO(this);
        configuracao = configuracaoDAO.carregaConfiguracoes();

        //Código de Teste - Início
        configuracao.setRaioAlertaPolicial(1111);
        try {
            configuracaoDAO.gravaConfiguracao(configuracao);
        } catch (GenericDatabaseException e) {
            e.printStackTrace();
        }
        //Código de Teste - Fim
*/

        setContentView(R.layout.activity_lista_alertas);

        //GPS

        mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mlocListener = new MyLocationListener();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                                                 Manifest.permission.ACCESS_COARSE_LOCATION}, 200);
        }else{
            mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
        }

        //GPS - Fim



        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        //mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_alertas_recentes_label));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_alertas_encerrados_label));
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);

        final ListaAlertasPageAdapter adapter = new ListaAlertasPageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 200: {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // {Some Code}
                }
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_alertas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("ListaAlertas Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        //Verifica se o usuário está logado. Se não estiver desvia para a LoginActivity
        if (!this.amberManager.isbLogado()) {
            Intent intentLogin = new Intent(this, LoginActivity.class);
            //intentListaJogador.putExtras("lista", this.getIntent());
            intentLogin.putExtra("logado", this.amberManager.isbLogado());
            intentLogin.putExtra("usuario", this.amberManager.getUsuario());

            startActivityForResult(intentLogin, MainDefaultValues.REQUEST_CODE_LOGIN_ACTIVITY);

        }

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

        //client.connect();
        //AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

/*
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
    }
*/

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //AppIndex.AppIndexApi.end(client, getIndexApiAction());
        //client.disconnect();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case MainDefaultValues.REQUEST_CODE_LOGIN_ACTIVITY:

                Usuario user = (Usuario) data.getSerializableExtra("usuario");
                boolean bLogado = (boolean) data.getBooleanExtra("logado", false);

                this.amberManager.setbLogado(bLogado);
                this.amberManager.setUsuario(user);


        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        if (uri == null){
            Log.d("SINVAS", "passou no onFragmentInteraction da Activity");
        }
    }
    /* Class My Location Listener */
    public class MyLocationListener implements LocationListener
    {

        @Override
        public void onLocationChanged(Location loc)
        {

            loc.getLatitude();
            loc.getLongitude();

            String Text = "Minha localização atual é: " +
                    "Latitude = " + loc.getLatitude() +
                    "Longitude = " + loc.getLongitude();

            Toast.makeText( getApplicationContext(), Text, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onProviderDisabled(String provider)
        {
            Toast.makeText( getApplicationContext(), "Gps desabilitado", Toast.LENGTH_SHORT ).show();
        }

        @Override
        public void onProviderEnabled(String provider)
        {
            Toast.makeText( getApplicationContext(), "Gps habilitado", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras)
        {

        }
    }

    private void trataGenericBusinessException(Exception e){
        e.printStackTrace();
        Toast.makeText(ListaAlertasActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
    }
}
