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
 * {@link EarthFragment.OnFragmentEarthInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EarthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EarthFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentEarthInteractionListener mListener;
    ArrayList<String> planetDataEarth;
    TextView planetEarth,massEarth,volumeEarth,gravityEarth,surfaceAreaEarth,satelliteEarth;
    ImageView mImageView;
    Button nextEarth,previousEarth;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EarthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EarthFragment newInstance(String param1, String param2) {
        EarthFragment fragment = new EarthFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public EarthFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        planetDataEarth = new ArrayList<>();
        planetDataEarth = mListener.getEarthData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_earth, container, false);
        mImageView=(ImageView)view.findViewById(R.id.PhotoEarth);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.swipe("earth");
            }
        });


        nextEarth=(Button) view.findViewById(R.id.next);
        nextEarth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.nextFragment(planetDataEarth.get(5));
                Log.v("BUTTON", "CLICKED");
            }
        });
        previousEarth=(Button) view.findViewById(R.id.previous);
        previousEarth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.previousFragment(planetDataEarth.get(5));
                Log.v("BUTTON","PREVIOUS");
            }
        });


        planetEarth = (TextView) view.findViewById(R.id.planetTagName);
        massEarth = (TextView) view.findViewById(R.id.massTagName);
        volumeEarth=(TextView) view.findViewById(R.id.volumeTagName);
        gravityEarth=(TextView) view.findViewById(R.id.gravityTagName);
        surfaceAreaEarth=(TextView) view.findViewById(R.id.surfaceTagName);
        satelliteEarth=(TextView) view.findViewById(R.id.satelliteTagName);
        planetEarth.setText(planetDataEarth.get(5));
        massEarth.setText(planetDataEarth.get(0));
        volumeEarth.setText(planetDataEarth.get(1));
        gravityEarth.setText(planetDataEarth.get(2));
        surfaceAreaEarth.setText(planetDataEarth.get(3));
        satelliteEarth.setText(planetDataEarth.get(4));


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
            mListener = (OnFragmentEarthInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface OnFragmentEarthInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
        public  ArrayList<String> getEarthData();
        public void nextFragment(String position);
        public void previousFragment(String position);
        public void swipe(String planet);
    }

}
