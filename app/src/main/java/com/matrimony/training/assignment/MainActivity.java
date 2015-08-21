 package com.matrimony.training.assignment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity{

    ListView mPlanetListView;


    LayoutInflater mlayoutInflater;
    MyAdaptor mlistAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mlayoutInflater =getLayoutInflater();
        if(mlayoutInflater == null)
        {
            Log.v("inflater","null");
        }


        mPlanetListView =(ListView) findViewById(R.id.select_listview);
        mlistAdaptor = new MyAdaptor();

        mPlanetListView.setAdapter(mlistAdaptor);

        mPlanetListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
              Intent intent = new Intent(getApplicationContext(), PlanetInfoActivity.class);
            //  intent.putExtra("planetName",arrayPlanet.get(position));
              intent.putExtra("position", position);
            //  intent.putStringArrayListExtra("arrayplanet",arrayPlanet);
              startActivity(intent);


          }
      });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public class MyAdaptor extends BaseAdapter{

        @Override
        public int getCount() {
            return DataStorage.mPlanetName.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertview, ViewGroup parent) {

            if(convertview == null)
            {
                convertview=mlayoutInflater.inflate(R.layout.list_element,parent,false);
                Log.v("NULL OBJ","CONVERTVIEW");
            }

            ImageView imageView =(ImageView)convertview.findViewById(R.id.planetImage);
            imageView.setImageResource(DataStorage.mPlanetPhoto.get(position));

            TextView textView =(TextView)convertview.findViewById(R.id.planetName);
            textView.setText(DataStorage.mPlanetName.get(position));

            /*convertview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), PlanetInfoActivity.class);
                    startActivity(intent);
                }
            });
*/
            return convertview;

        }
    }


}
