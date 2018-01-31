package com.example.ducdv.uiteducation.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.transition.FragmentTransitionSupport;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ducdv.uiteducation.R;
import com.example.ducdv.uiteducation.base.model.AlgorithmModel;
import com.example.ducdv.uiteducation.base.rest.Config;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VisualFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VisualFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VisualFragment extends Fragment {

    private static final String ARG_PARAM = "videoId";


    // TODO: Rename and change types of parameters
    private String videoId;

    public VisualFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param data Parameter 1.
     * @return A new instance of fragment VisualFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VisualFragment newInstance(AlgorithmModel data) {
        VisualFragment fragment = new VisualFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, data.getYoutubeVideoId());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("shuu", "Visual onCreate");
        if (getArguments() != null) {
            videoId = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("shuu", "Visual onCreateView");
        // Inflate the layout for this fragment
        FragmentManager manager = getChildFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_tag, new YoutubeFragment(videoId));
        transaction.commit();
        return inflater.inflate(R.layout.fragment_visual, container, false);
    }


}
