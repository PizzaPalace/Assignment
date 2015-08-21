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
 * {@link UranusFragment.OnFragmentUranusInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UranusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UranusFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentUranusInteractionListener mListener;
    ArrayList<String> planetDataUranus;
    TextView planetUranus,massUranus,volumeUranus,gravityUranus,surfaceAreaUranus,satelliteUranus;
    ImageView mImageView;
    Button nextUranus,previousUranus;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UranusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UranusFragment newInstance(String param1, String param2) {
        UranusFragment fragment = new UranusFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public UranusFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        planetDataUranus = new ArrayList<>();
        planetDataUranus = mListener.getUranusData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_uranus, container, false);
        mImageView=(ImageView)view.findViewById(R.id.PhotoUranus);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.swipe("uranus");
            }
        });


        nextUranus=(Button) view.findViewById(R.id.next);
        nextUranus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.nextFragment(planetDataUranus.get(5));
                Log.v("BUTTON", "CLICKED");
            }
        });



        previousUranus=(Button) view.findViewById(R.id.previous);
        previousUranus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.previousFragment(planetDataUranus.get(5));
                Log.v("BUTTON","PREVIOUS");
            }
        });

        planetUranus = (TextView) view.findViewById(R.id.planetTagName);
        massUranus = (TextView) view.findViewById(R.id.massTagName);
        volumeUranus=(TextView) view.findViewById(R.id.volumeTagName);
        gravityUranus=(TextView) view.findViewById(R.id.gravityTagName);
        surfaceAreaUranus=(TextView) view.findViewById(R.id.surfaceTagName);
        satelliteUranus=(TextView) view.findViewById(R.id.satelliteTagName);
        planetUranus.setText(planetDataUranus.get(5));
        massUranus.setText(planetDataUranus.get(0));
        volumeUranus.setText(planetDataUranus.get(1));
        gravityUranus.setText(planetDataUranus.get(2));
        surfaceAreaUranus.setText(planetDataUranus.get(3));
        satelliteUranus.setText(planetDataUranus.get(4));

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
            mListener = (OnFragmentUranusInteractionListener) activity;
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
    public interface OnFragmentUranusInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
        public  ArrayList<String> getUranusData();
        public void nextFragment(String planet);
        public void previousFragment(String planet);
        public void swipe(String planet);
    }

}
