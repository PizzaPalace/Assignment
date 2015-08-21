package com.matrimony.training.assignment;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class PlanetInfoActivity extends AppCompatActivity implements PlanetFragment.OnFragmentInteractionListener,MercuryFragment.OnFragmentMercuryInteractionListener,EarthFragment.OnFragmentEarthInteractionListener,JupiterFragment.OnFragmentJupiterInteractionListener,NeptuneFragment.OnFragmentNeptuneInteractionListener,SaturnFragment.OnFragmentSaturnInteractionListener,UranusFragment.OnFragmentUranusInteractionListener,VenusFragment.OnFragmentVenusInteractionListener,MoonFragment.OnFragmentMoonInteractionListener
{


    String titleNmae;
    static int POSITION;

    TextView title;

   HashMap<String,ArrayList<String>> mInformation;
    public static final String SUN_TAG ="SUN TAG";
    public static final String MERCURY_TAG ="MERCURY TAG";
    public static final String VENUS_TAG ="VENUS TAG";
    public static final String EARTH_TAG ="EARTH TAG";
    public static final String MOON_TAG ="MOON TAG";
    public static final String JUPITER_TAG ="JUPITER TAG";
    public static final String SATURN_TAG ="SATURN TAG";
    public static final String URANUS_TAG ="URANUS TAG";
    public static final String NEPTUNE_TAG ="NEPTUNE TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_info);
        Log.v("LIFE","ACTIVITY ONCREATE");

        Intent intent = getIntent();

       POSITION= intent.getIntExtra("position", 0);
        title =(TextView)findViewById(R.id.activityTitle);
      //  title.setText(DataStorage.mPlanetName.get(POSITION));

        //get planet info from JSON file
        mInformation = new HashMap<>();
      if(DataStorage.mPlanetData== null)
      {
            String jsonString = getJSON(R.raw.solar_system_data);
            getPlanetInfo(jsonString);
          DataStorage.mPlanetData= mInformation;
      }
        else
      {
          mInformation=DataStorage.mPlanetData;
      }
            createFragment(POSITION);

        //create the fragment corresponding to position


    }
    private void createFragment(int position){
        Log.v("CALLED","FRGMENT");
        switch (position)
        {
            case 0:
            {
                title.setText(DataStorage.mPlanetName.get(POSITION));
                PlanetFragment fragmentSun = PlanetFragment.newInstance("sample 1","sample 2");
                FragmentManager manager =getSupportFragmentManager();
                FragmentTransaction transaction =manager.beginTransaction();
                transaction.replace(R.id.fragmentContainer, fragmentSun, SUN_TAG);
                transaction.addToBackStack(SUN_TAG);
                transaction.commit();
                break;
            }

            case 1:
            {
                title.setText(DataStorage.mPlanetName.get(POSITION));
                MercuryFragment fragmentMercury = MercuryFragment.newInstance("sample 1","sample 2");
                FragmentManager manager =getSupportFragmentManager();
                FragmentTransaction transaction =manager.beginTransaction();
                transaction.replace(R.id.fragmentContainer, fragmentMercury,MERCURY_TAG);
               transaction.addToBackStack(MERCURY_TAG);
                transaction.commit();
                break;
            }

            case 2:

            {
                title.setText(DataStorage.mPlanetName.get(POSITION));
                VenusFragment fragmentVenus = VenusFragment.newInstance("sample 1", "sample 2");
                FragmentManager manager =getSupportFragmentManager();
                FragmentTransaction transaction =manager.beginTransaction();
                transaction.replace(R.id.fragmentContainer,fragmentVenus,VENUS_TAG);
                transaction.addToBackStack(VENUS_TAG);
                transaction.commit();
                break;
            }

            case 3:
            {
                title.setText(DataStorage.mPlanetName.get(POSITION));
                EarthFragment fragmentEarth = EarthFragment.newInstance("sample 1","sample 2");
                FragmentManager manager =getSupportFragmentManager();
                FragmentTransaction transaction =manager.beginTransaction();
                transaction.replace(R.id.fragmentContainer,fragmentEarth,EARTH_TAG);
                transaction.addToBackStack(EARTH_TAG);
                transaction.commit();
                break;
            }

            case 4:
            {
                title.setText(DataStorage.mPlanetName.get(POSITION));
                MoonFragment fragmentMoon = MoonFragment.newInstance("sample 1","sample 2");
                FragmentManager manager =getSupportFragmentManager();
                FragmentTransaction transaction =manager.beginTransaction();
                transaction.replace(R.id.fragmentContainer,fragmentMoon,MOON_TAG);
               transaction.addToBackStack(MOON_TAG);
                transaction.commit();
                break;
            }

            case 5:
            {
                title.setText(DataStorage.mPlanetName.get(POSITION));
                JupiterFragment fragmentJupiter = JupiterFragment.newInstance("sample 1","sample 2");
                FragmentManager manager =getSupportFragmentManager();
                FragmentTransaction transaction =manager.beginTransaction();
                transaction.replace(R.id.fragmentContainer,fragmentJupiter,JUPITER_TAG);
               transaction.addToBackStack(JUPITER_TAG);
                transaction.commit();
                break;
            }

            case 6:
            {
                title.setText(DataStorage.mPlanetName.get(POSITION));
                SaturnFragment fragmentSaturn = SaturnFragment.newInstance("sample 1","sample 2");
                FragmentManager manager =getSupportFragmentManager();
                FragmentTransaction transaction =manager.beginTransaction();
                transaction.replace(R.id.fragmentContainer,fragmentSaturn,SATURN_TAG);
                transaction.addToBackStack(SATURN_TAG);
                transaction.commit();
                break;

            }

            case 7:
            {
                title.setText(DataStorage.mPlanetName.get(POSITION));
                UranusFragment fragmentUranus = UranusFragment.newInstance("sample 1","sample 2");
                FragmentManager manager =getSupportFragmentManager();
                FragmentTransaction transaction =manager.beginTransaction();
                transaction.replace(R.id.fragmentContainer,fragmentUranus,URANUS_TAG);
                transaction.addToBackStack(URANUS_TAG);

                transaction.commit();
                break;


            }

            case 8:
            {
                title.setText(DataStorage.mPlanetName.get(POSITION));
                NeptuneFragment fragmentNeptune = NeptuneFragment.newInstance("sample 1","sample 2");
                FragmentManager manager =getSupportFragmentManager();
                FragmentTransaction transaction =manager.beginTransaction();
                transaction.replace(R.id.fragmentContainer,fragmentNeptune,NEPTUNE_TAG);
                transaction.addToBackStack(NEPTUNE_TAG);
                transaction.commit();
                break;

            }


        }
        return;
    }

    private void getPlanetInfo(String input)
    {
        try{
            JSONObject jsonobjMain = new JSONObject(input);

            HashMap<String ,Object> map = new HashMap<>();

            Iterator<String> iterator = jsonobjMain.keys();
            while(iterator.hasNext())
            {
                String key = iterator.next();
                map.put(key, jsonobjMain.getJSONObject(key));

            }
            int turn=0;


            for(Map.Entry<String,Object> temp : map.entrySet())
            {
                turn=0;
                ArrayList<String> arrayList=new ArrayList<>();
                String key=null;
                String planetName = temp.getKey();
                JSONObject object=(JSONObject)temp.getValue();


                Iterator<String> iteratorPlanet =object.keys();

                while(iteratorPlanet.hasNext())
                {

                    key= iteratorPlanet.next();
                    if(turn!=4)
                    {
                        turn++;
                        arrayList.add(object.getString(key));
                    }

                    else{
                        JSONArray satellite = object.getJSONArray(key);
                        String satelliteString = satellite.toString();
                        /*satelliteString= satelliteString.replace("[","");
                        satelliteString= satelliteString.replace("]","");
                        Log.v("str",satelliteString);*/
                        int length=satellite.length();
                        String str="";
                        for(int index=0; index<length; index++){

                            str += satellite.getString(index);
                        }
                        arrayList.add(str);

                    }


                }
                arrayList.add(planetName);
                mInformation.put(planetName, arrayList);
               /* Log.v("keyMINFO", planetName);
                Log.v("valueINFO",arrayList.toString());*/
            }
            Log.v("JSONPARSED", "PARSED AGAIN");
            /*for(Map.Entry<String,ArrayList<String >> qwerty :mInformation.entrySet() )
            {
                Log.v("keyMAP",qwerty.getKey());
                Log.v("ValueMAP",qwerty.getValue().toString());
            }*/

        }
        catch (JSONException e)
        {
            e.printStackTrace();
            return ;
        }

    }


    private String getJSON(int resourceId)
    {   char [] buffer= new char[2048];
        int i=-1;
        InputStream inputStream =null;
        BufferedReader reader= null;
        try
        {
            inputStream= getResources().openRawResource(resourceId);

            reader = new BufferedReader( new InputStreamReader(inputStream));
            Writer writer = new StringWriter();

            while((i=reader.read(buffer))!= -1)
            {
                writer.write(buffer,0,i);
            }

            Log.v("before return","11111");
            return writer.toString();


        }

        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally {
           try{
                reader.close();
                inputStream.close();
                Log.v("finally","2222");}
           catch (Exception e)
           {
               e.printStackTrace();
               return null;
           }
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_planet_info, menu);
        Log.v("LIFE","ACTIVITY ONCREATEOPTIONSMENU");
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public ArrayList<String> getMoonData() {
        return mInformation.get("mars");//titleNmae.toLowerCase());
    }

    @Override
    public ArrayList<String> getVenusData() {
        return mInformation.get("venus");//titleNmae.toLowerCase());
    }

    @Override
    public ArrayList<String> getUranusData() {
        return mInformation.get("uranus");//titleNmae.toLowerCase());
    }

    @Override
    public ArrayList<String> getSaturnData() {
        return mInformation.get("saturn");//titleNmae.toLowerCase());
    }

    @Override
    public ArrayList<String> getNeptuneData() {
        return mInformation.get("neptune");//titleNmae.toLowerCase());
    }

    @Override
    public ArrayList<String> getMercuryData() {
       // Log.v("MErcury",mInformation.get(titleNmae.toLowerCase()).toString());
        return mInformation.get("mercury");//titleNmae.toLowerCase());
    }

    @Override
    public ArrayList<String> getJupiterData() {
        return mInformation.get("jupiter");//titleNmae.toLowerCase());
    }

    @Override
    public ArrayList<String> getEarthData()
    {
        return mInformation.get("earth");//titleNmae.toLowerCase());
    }

    @Override
    public ArrayList<String> getSunData() {
        return mInformation.get("sun");


    }

    @Override
    public void nextFragment(String planet) {
      /*  int index =DataStorage.mPlanetName.indexOf(planet.toUpperCase());
        Log.v("NEXT Fragement LIFE",Integer.toString(index));
        titleNmae= DataStorage.mPlanetName.get(index + 1);
        title.setText(titleNmae);
        if(POSITION== 8)
            index=0;
        else
            index++;
        createFragment(index);
*/
        Log.v("POSITION Button",Integer.toString(POSITION));

        if(POSITION==8)
            POSITION=0;
        else
            POSITION++;
        createFragment(POSITION);
    }

    @Override
    public void previousFragment(String planet) {
        Log.v("PREVIOUS BUTTON",Integer.toString(POSITION));
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (fm.getBackStackEntryCount()>1)
        {
            Log.v("PREVIOUS", "FUNCTION");
            // int index = arrayplanet.indexOf(planet.toUpperCase());
            Log.v("BACKSTACK COUNT BUTTON", Integer.toString(fm.getBackStackEntryCount()));

            if (POSITION!= 0) {
                POSITION--;
                titleNmae = DataStorage.mPlanetName.get(POSITION);///arrayplanet.get(index - 1);
                title.setText(titleNmae);
            }
            /*if (fm.getBackStackEntryCount() > 0) {*/
            fm.popBackStack();
            ft.commit();
           // }


        }
    }

    @Override
    public void swipe(String input) {
        Intent intent = new Intent(getApplicationContext(), SwipeImage.class);
        Log.v("ACTIVITY",input);
        intent.putExtra("planet",input);

        startActivity(intent);
    }
}