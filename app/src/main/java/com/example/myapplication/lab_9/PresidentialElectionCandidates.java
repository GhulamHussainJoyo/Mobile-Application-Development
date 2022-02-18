package com.example.myapplication.lab_9;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class PresidentialElectionCandidates extends AppCompatActivity implements PresidentialElectionCandidates_frag1.onSomeEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presidential_election_candidates);

    }

    public void dispatchInformations() {

    }

    @Override
    public void someEvent(int s) {
        Fragment frag1 = getFragmentManager().findFragmentById(R.layout.fragment_presidential_election_candidates_frag1);
        Toast.makeText(this,s+"",Toast.LENGTH_LONG).show();
    }
}
