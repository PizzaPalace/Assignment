package com.matrimony.training.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Rutuja on 19-08-2015.
 */
public class DataStorage {
    public static HashMap<String,ArrayList<String>> mPlanetData = null;

    public static ArrayList<Integer>mPlanetPhoto= new ArrayList<>(Arrays.asList( R.drawable.list_sun,R.drawable.list_mercury,R.drawable.list_venus,R.drawable.list_earth,
                                                     R.drawable.list_mars,R.drawable.list_jupiter,R.drawable.list_saturn,R.drawable.list_uranus,R.drawable.list_neptune));
   
   
    public static ArrayList<String>mPlanetName=new ArrayList<>(Arrays.asList( "SUN","MERCURY", "VENUS", "EARTH", "MARS", "JUPITER", "SATURN", "URANUS", "NEPTUNE"));

    
    public static ArrayList<Integer> sun= new ArrayList<>(Arrays.asList(R.drawable.sun1,R.drawable.sun2,R.drawable.sun3));
    public static ArrayList<Integer> earth= new ArrayList<>(Arrays.asList(R.drawable.earth1,R.drawable.earth2,R.drawable.earth3));
    public static ArrayList<Integer> jupiter= new ArrayList<>(Arrays.asList(R.drawable.jupiter1,R.drawable.jupiter2,R.drawable.jupiter3));
    public static ArrayList<Integer> mars= new ArrayList<>(Arrays.asList(R.drawable.mars1,R.drawable.mars2,R.drawable.mars3));
    public static ArrayList<Integer> mercury= new ArrayList<>(Arrays.asList(R.drawable.mercury1,R.drawable.mercury2,R.drawable.mercury3));
    public static ArrayList<Integer> neptune= new ArrayList<>(Arrays.asList(R.drawable.neptune1,R.drawable.neptune2,R.drawable.neptune3));
    public static ArrayList<Integer> saturn= new ArrayList<>(Arrays.asList(R.drawable.saturn1,R.drawable.saturn2,R.drawable.saturn3));
    public static ArrayList<Integer> uranus= new ArrayList<>(Arrays.asList(R.drawable.uranus1,R.drawable.uranus2,R.drawable.uranus3));
    public static ArrayList<Integer> venus= new ArrayList<>(Arrays.asList(R.drawable.venus1,R.drawable.venus2,R.drawable.venus3));

    public static HashMap<String,ArrayList<Integer>> mImageData=new HashMap<>();

    static {

        mImageData.put("sun",sun);
        mImageData.put("earth",earth);
        mImageData.put("jupiter",jupiter);
        mImageData.put("mars",mars);
        mImageData.put("mercury",mercury);
        mImageData.put("neptune",neptune);
        mImageData.put("saturn",saturn);
        mImageData.put("uranus",uranus);
        mImageData.put("venus",venus);
    }
}
