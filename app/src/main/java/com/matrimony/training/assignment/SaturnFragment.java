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
 * {@link SaturnFragment.OnFragmentSaturnInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SaturnFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SaturnFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentSaturnInteractionListener mListener;
    ArrayList<String> planetDataSaturn;
    TextView planetSaturn,massSaturn,volumeSaturn,gravitySaturn,surfaceAreaSaturn,satelliteSaturn;
    ImageView mImageView;
    Button nextSaturn,previousSaturn;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SaturnFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SaturnFragment newInstance(String param1, String param2) {
        SaturnFragment fragment = new SaturnFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SaturnFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        planetDataSaturn = new ArrayList<>();
        planetDataSaturn = mListener.getSaturnData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_saturn, container, false);
        mImageView=(ImageView)view.findViewById(R.id.PhotoSaturn);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.swipe("saturn");
            }
        });


        nextSaturn=(Button) view.findViewById(R.id.next);
        nextSaturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.nextFragment(planetDataSaturn.get(5));
                Log.v("BUTTON", "CLICKED");
            }
        });
        previousSaturn=(Button) view.findViewById(R.id.previous);
        previousSaturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.previousFragment(planetDataSaturn.get(5));
                Log.v("BUTTON","PREVIOUS");
            }
        });

        planetSaturn = (TextView) view.findViewById(R.id.planetTagName);
        massSaturn = (TextView) view.findViewById(R.id.massTagName);
        volumeSaturn=(TextView) view.findViewById(R.id.volumeTagName);
        gravitySaturn=(TextView) view.findViewById(R.id.gravityTagName);
        surfaceAreaSaturn=(TextView) view.findViewById(R.id.surfaceTagName);
        satelliteSaturn=(TextView) view.findViewById(R.id.satelliteTagName);
        planetSaturn.setText(planetDataSaturn.get(5));
        massSaturn.setText(planetDataSaturn.get(0));
        volumeSaturn.setText(planetDataSaturn.get(1));
        gravitySaturn.setText(planetDataSaturn.get(2));
        surfaceAreaSaturn.setText(planetDataSaturn.get(3));
        satelliteSaturn.setText(planetDataSaturn.get(4));

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
            mListener = (OnFragmentSaturnInteractionListener) activity;
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
    public interface OnFragmentSaturnInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
        public  ArrayList<String> getSaturnData();
        public void nextFragment(String planet);
        public  void previousFragment(String planet);
        public  void swipe(String planet);
    }

}
