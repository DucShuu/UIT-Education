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
 * {@link CodeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CodeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CodeFragment extends Fragment {

    private static final String ARG_PARAM = "codeDemo";

    private String codeDemo;

    public CodeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param data Parameter 1.
     * @return A new instance of fragment CodeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CodeFragment newInstance(AlgorithmModel data) {
        CodeFragment fragment = new CodeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, data.getCodeDemo());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("shuu", "Code onCreate");
        if (getArguments() != null) {
            codeDemo = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("shuu", "Code onCreateView");
        View view = inflater.inflate(R.layout.fragment_code, container, false);

        TextView codeDemo = view.findViewById(R.id.lbl_code);
        codeDemo.setText(this.codeDemo);
        codeDemo.setMovementMethod(new ScrollingMovementMethod());
        return view;
    }



}
