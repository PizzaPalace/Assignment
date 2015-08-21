package com.matrimony.training.assignment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlanetFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlanetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlanetFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

   private ArrayList<String> planetDataSun;
    TextView planetSun,massSun,volumeSun,gravitySun,surfaceAreaSun,satelliteSun;
    ImageView mImageView;
    Button nextSun,previousSun;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlanetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlanetFragment newInstance(String param1, String param2) {
        PlanetFragment fragment = new PlanetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        Log.v("LIFE", "ON NEW INSTANCE");
        return fragment;
    }

    public PlanetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("LIFE","ON CREATE");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        planetDataSun = new ArrayList<>();
        planetDataSun = mListener.getSunData();
        Log.v("LIFE PLANETDATASUN",planetDataSun.toString());


       /* mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_planet, container, false);

        mImageView=(ImageView)view.findViewById(R.id.PhotoSun);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.swipe("sun");
            }
        });

        nextSun=(Button) view.findViewById(R.id.next);
        nextSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.nextFragment(planetDataSun.get(5));
                Log.v("LIFE NEXTBUTTON",planetDataSun.get(5).toString());
            }
        });

        previousSun=(Button) view.findViewById(R.id.previous);
        previousSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.previousFragment(planetDataSun.get(5));
                Log.v("BUTTON","Previouscliked");
            }
        });

        planetSun = (TextView) view.findViewById(R.id.planetTagName);
        massSun = (TextView) view.findViewById(R.id.massTagName);
        volumeSun=(TextView) view.findViewById(R.id.volumeTagName);
        gravitySun=(TextView) view.findViewById(R.id.gravityTagName);
        surfaceAreaSun=(TextView) view.findViewById(R.id.surfaceTagName);
        satelliteSun=(TextView) view.findViewById(R.id.satelliteTagName);
        planetSun.setText(planetDataSun.get(5));
        massSun.setText(planetDataSun.get(0));
        volumeSun.setText(planetDataSun.get(1));
        gravitySun.setText(planetDataSun.get(2));
        surfaceAreaSun.setText(planetDataSun.get(3));
        satelliteSun.setText(planetDataSun.get(4));

        Log.v("LIFE","ON CREATEVEIW");
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }

        Log.v("LIFE","ON ATTACH");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        Log.v("LIFE","ON DETACH");
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
        public  ArrayList<String> getSunData();
        public  void nextFragment(String planet );
        public void previousFragment(String planet);
        public  void swipe(String input);
    }

}
