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
 * {@link NeptuneFragment.OnFragmentNeptuneInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NeptuneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NeptuneFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentNeptuneInteractionListener mListener;
    ArrayList<String> planetDataNeptune;
    TextView planetNeptune,massNeptune,volumeNeptune,gravityNeptune,surfaceAreaNeptune,satelliteNeptune;
    ImageView mImageView;
    Button nextNeptune,previousNeptune;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NeptuneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NeptuneFragment newInstance(String param1, String param2) {
        NeptuneFragment fragment = new NeptuneFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public NeptuneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        planetDataNeptune = new ArrayList<>();
        planetDataNeptune = mListener.getNeptuneData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_neptune, container, false);
        mImageView=(ImageView)view.findViewById(R.id.PhotoNeptune);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.swipe("neptune");
            }
        });


        nextNeptune=(Button) view.findViewById(R.id.next);
        nextNeptune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.nextFragment(planetDataNeptune.get(5));
                Log.v("BUTTON", "CLICKED");
            }
        });

        previousNeptune=(Button) view.findViewById(R.id.previous);
        previousNeptune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.previousFragment(planetDataNeptune.get(5));
                Log.v("BUTTON","PREVIOUS");
            }
        });

        planetNeptune = (TextView) view.findViewById(R.id.planetTagName);
        massNeptune = (TextView) view.findViewById(R.id.massTagName);
        volumeNeptune=(TextView) view.findViewById(R.id.volumeTagName);
        gravityNeptune=(TextView) view.findViewById(R.id.gravityTagName);
        surfaceAreaNeptune=(TextView) view.findViewById(R.id.surfaceTagName);
        satelliteNeptune=(TextView) view.findViewById(R.id.satelliteTagName);
        planetNeptune.setText(planetDataNeptune.get(5));
        massNeptune.setText(planetDataNeptune.get(0));
        volumeNeptune.setText(planetDataNeptune.get(1));
        gravityNeptune.setText(planetDataNeptune.get(2));
        surfaceAreaNeptune.setText(planetDataNeptune.get(3));
        satelliteNeptune.setText(planetDataNeptune.get(4));


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
            mListener = (OnFragmentNeptuneInteractionListener) activity;
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
    public interface OnFragmentNeptuneInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
        public  ArrayList<String> getNeptuneData();
        public  void nextFragment(String planet);
        public  void previousFragment(String planet);
        public  void swipe(String planet);
    }

}
