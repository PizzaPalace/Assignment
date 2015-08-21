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
 * {@link JupiterFragment.OnFragmentJupiterInteractionListener} interface
 * to handle interaction events.
 * Use the {@link JupiterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JupiterFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentJupiterInteractionListener mListener;

    ArrayList<String> planetDataJupiter;
    TextView planetJupiter,massJupiter,volumeJupiter,gravityJupiter,surfaceAreaJupiter,satelliteJupiter;
    ImageView mImageView;
    Button nextJupiter,previousJupiter;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JupiterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JupiterFragment newInstance(String param1, String param2) {
        JupiterFragment fragment = new JupiterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public JupiterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        planetDataJupiter = new ArrayList<>();
        planetDataJupiter = mListener.getJupiterData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this f    ragment
        View view=inflater.inflate(R.layout.fragment_jupiter, container, false);
        mImageView=(ImageView)view.findViewById(R.id.PhotoJupiter);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.swipe("jupiter");
            }
        });


        nextJupiter=(Button) view.findViewById(R.id.next);
        nextJupiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.nextFragment(planetDataJupiter.get(5));
                Log.v("BUTTON", "CLICKED");
            }
        });

        previousJupiter=(Button) view.findViewById(R.id.previous);
        previousJupiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.previousFragment(planetDataJupiter.get(5));
                Log.v("BUTTON","PREVIOUS");
            }
        });


        planetJupiter = (TextView) view.findViewById(R.id.planetTagName);
        massJupiter = (TextView) view.findViewById(R.id.massTagName);
        volumeJupiter=(TextView) view.findViewById(R.id.volumeTagName);
        gravityJupiter=(TextView) view.findViewById(R.id.gravityTagName);
        surfaceAreaJupiter=(TextView) view.findViewById(R.id.surfaceTagName);
        satelliteJupiter=(TextView) view.findViewById(R.id.satelliteTagName);
        planetJupiter.setText(planetDataJupiter.get(5));
        massJupiter.setText(planetDataJupiter.get(0));
        volumeJupiter.setText(planetDataJupiter.get(1));
        gravityJupiter.setText(planetDataJupiter.get(2));
        surfaceAreaJupiter.setText(planetDataJupiter.get(3));
        satelliteJupiter.setText(planetDataJupiter.get(4));


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
            mListener = (OnFragmentJupiterInteractionListener) activity;
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
    public interface OnFragmentJupiterInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
        public  ArrayList<String> getJupiterData();
        public void nextFragment(String planet);
        public void previousFragment(String planet);
        public  void swipe(String planet);
    }

}
