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
 * {@link MercuryFragment.OnFragmentMercuryInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MercuryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MercuryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentMercuryInteractionListener mListener;

    ArrayList<String> planetDataMercury;
    TextView planetMercury,massMercury,volumeMercury,gravityMercury,surfaceAreaMercury,satelliteMercury;
    ImageView mImageView;
    Button nextMercury,previousMercury;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MercuryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MercuryFragment newInstance(String param1, String param2) {
        MercuryFragment fragment = new MercuryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MercuryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        planetDataMercury = new ArrayList<>();
        planetDataMercury = mListener.getMercuryData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_mercury, container, false);
        mImageView=(ImageView)view.findViewById(R.id.PhotoMercury);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.swipe("mercury");
            }
        });


        nextMercury=(Button) view.findViewById(R.id.next);
        nextMercury.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.nextFragment(planetDataMercury.get(5));
                Log.v("BUTTON",planetDataMercury.get(5));
            }
        });

        previousMercury=(Button) view.findViewById(R.id.previous);
        previousMercury.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.previousFragment(planetDataMercury.get(5));
                Log.v("BUTTON","PREVIOUS");
            }
        });

        planetMercury = (TextView) view.findViewById(R.id.planetTagName);
        massMercury = (TextView) view.findViewById(R.id.massTagName);
        volumeMercury=(TextView) view.findViewById(R.id.volumeTagName);
        gravityMercury=(TextView) view.findViewById(R.id.gravityTagName);
        surfaceAreaMercury=(TextView) view.findViewById(R.id.surfaceTagName);
        satelliteMercury=(TextView) view.findViewById(R.id.satelliteTagName);

        Log.v("mercury","fragment data assigned");
        planetMercury.setText(planetDataMercury.get(5));
        massMercury.setText(planetDataMercury.get(0));
        volumeMercury.setText(planetDataMercury.get(1));
        gravityMercury.setText(planetDataMercury.get(2));
        surfaceAreaMercury.setText(planetDataMercury.get(3));
        satelliteMercury.setText(planetDataMercury.get(4));

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
            mListener = (OnFragmentMercuryInteractionListener) activity;
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
    public interface OnFragmentMercuryInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
        public  ArrayList<String> getMercuryData();
        public void nextFragment(String planet);
        public void swipe(String planet);
        public void previousFragment(String planet);
    }


}
