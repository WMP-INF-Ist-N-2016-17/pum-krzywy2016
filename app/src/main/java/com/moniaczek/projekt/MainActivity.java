package com.moniaczek.projekt;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    private Button btnLogout;
    private Session session;
    ListView lv;
    SearchView sv;
    String[] movie = {"Intruz", "Nietykalni", "Iluzja", "Kod da Vinci ", "Siedem dusz", "Transformers"};
    ArrayAdapter<String> adapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView1);
        sv = (SearchView) findViewById(R.id.searchView1);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movie);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String cities = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(com.moniaczek.projekt.MainActivity.this, cities, Toast.LENGTH_LONG).show();

                        if (position == 0) {
                            //code specific to first list item
                            Intent myIntent = new Intent(view.getContext(), com.moniaczek.projekt.Activity1.class);
                            startActivityForResult(myIntent, 0);
                        }
                        if (position == 1) {
                            //code specific to first list item
                            Intent myIntent = new Intent(view.getContext(), com.moniaczek.projekt.Activity2.class);
                            startActivityForResult(myIntent, 0);
                        }
                        if (position == 2) {
                            //code specific to first list item
                            Intent myIntent = new Intent(view.getContext(), com.moniaczek.projekt.Activity3.class);
                            startActivityForResult(myIntent, 0);
                        }
                        if (position == 3) {
                            //code specific to first list item
                            Intent myIntent = new Intent(view.getContext(), com.moniaczek.projekt.Activity4.class);
                            startActivityForResult(myIntent, 0);
                        }
                        if (position == 4) {
                            //code specific to first list item
                            Intent myIntent = new Intent(view.getContext(), com.moniaczek.projekt.Activity5.class);
                            startActivityForResult(myIntent, 0);
                        }
                        if (position == 5) {
                            //code specific to first list item
                            Intent myIntent = new Intent(view.getContext(), com.moniaczek.projekt.Activity6.class);
                            startActivityForResult(myIntent, 0);
                        }
                    }


                });

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                adapter.getFilter().filter(text);
                return false;
            }
        });


        session = new Session(this);
        if (!session.loggedin()) {
            logout();
        }
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void logout() {
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
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

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
