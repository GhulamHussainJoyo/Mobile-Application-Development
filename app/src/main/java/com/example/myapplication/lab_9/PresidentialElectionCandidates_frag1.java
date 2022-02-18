package com.example.myapplication.lab_9;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;


public class PresidentialElectionCandidates_frag1 extends Fragment {


    public interface onSomeEventListener {
        public void someEvent(int s);
    }

    onSomeEventListener someEventListener;

    private ListView presedentNameListVIew;


    public PresidentialElectionCandidates_frag1() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            someEventListener = (onSomeEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    final String LOG_TAG = "myLogs";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_presidential_election_candidates_frag1, container, false);

        presedentNameListVIew = view.findViewById(R.id.presedentNameListVIew);

        presedentNameListVIew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getActivity().getApplicationContext(), i + "", Toast.LENGTH_LONG).show();
//                someEventListener.someEvent(i);
                sendToSecondFragment(i);


            }
        });
        return view;
    }

    public void sendToSecondFragment(int position)
    {
        PresidentialElectionCandidates_frag2 frag2 = new PresidentialElectionCandidates_frag2();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
//        bundle
        Bundle args = new Bundle();
        args.putInt("selectedItem",position);
        frag2.setArguments(args);

        ft.replace(R.id.presedentDetailFrag,frag2);
        ft.commit();


    }


}