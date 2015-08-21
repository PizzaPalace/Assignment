package com.matrimony.training.assignment;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class SwipeImage extends AppCompatActivity implements SwipeFragmentOne.OnFragmentOneInteractionListener,
                                                                SwipeFragmentTwo.OnFragmentTwoInteractionListener ,
                                                                SwipeFragmentThree.OnFragmentThreeInteractionListner{

     private  String titleNmae;
    ViewPager mViewPager;
    ImagePagerAdaptor mImageAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_image);
        mViewPager = (ViewPager) findViewById(R.id.swipe_image_activity);
        mImageAdaptor = new ImagePagerAdaptor(getSupportFragmentManager());
        mViewPager.setAdapter(mImageAdaptor);

        Intent intent = getIntent();
        titleNmae = intent.getStringExtra("planet");
        Log.v("life SWIPEIMAGE",titleNmae);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_swipe_image, menu);
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
    public String getPlanetName() {
        return titleNmae;
    }

    public class ImagePagerAdaptor extends FragmentPagerAdapter

    {
        public ImagePagerAdaptor(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {

            if(position == 0)
                return new SwipeFragmentOne();
            else if(position == 1)
                return new SwipeFragmentTwo();
            else if(position == 2)
                return new SwipeFragmentThree();

            return null;

        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
