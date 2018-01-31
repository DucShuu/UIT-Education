package com.example.ducdv.uiteducation.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ducdv.uiteducation.R;
import com.example.ducdv.uiteducation.base.model.AlgorithmModel;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DescFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DescFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DescFragment extends Fragment {

    private static final String ARG_PARAM = "description";

    // TODO: Rename and change types of parameters
    private String description;

    public DescFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param data Parameter 1.
     * @return A new instance of fragment DescFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DescFragment newInstance(AlgorithmModel data) {
        DescFragment fragment = new DescFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, data.getDescription());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("shuu", "Desc onCreate");
        if (getArguments() != null) {
            description = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("shuu", "Desc onCreateView");
        View view = inflater.inflate(R.layout.fragment_desc, container, false);;

        TextView description = view.findViewById(R.id.lbl_desc);
        description.setText(this.description);
        description.setMovementMethod(new ScrollingMovementMethod());

        return view;
    }


}
