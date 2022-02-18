package com.example.myapplication.lab_9;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class PresidentialElectionCandidates_frag2 extends Fragment {

    private int position = -1;
    private ImageView presedentImage;
    private TextView presentDetailsTextView;
    private int[] imagesList;


    public PresidentialElectionCandidates_frag2() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imagesList = new int[8];

        imagesList[0] = R.drawable.clinton;
        imagesList[1] = R.drawable.sanders;
        imagesList[2] = R.drawable.omalley;
        imagesList[3] = R.drawable.chafee;
        imagesList[4] = R.drawable.trump;
        imagesList[5] = R.drawable.carson;
        imagesList[6] = R.drawable.rubio;
        imagesList[7] = R.drawable.bush;



        Bundle bundle = getArguments();
        if (bundle != null)
        {
            position = bundle.getInt("selectedItem");

        }



    }

    private void setFragment(int position)
    {
        switch (position)
        {
            case 0:
                presedentImage.setImageResource(imagesList[position]);
                presentDetailsTextView.setText("Former Governer Hilary Cilton (Rhode Island)");
                break;
            case 1:
                presedentImage.setImageResource(imagesList[position]);
                presentDetailsTextView.setText("Former Governer Bernie Sanders (Rhode Island)");
                break;
            case 2:
                presedentImage.setImageResource(imagesList[position]);
                presentDetailsTextView.setText("Former Governer Marrtin O'Malley (Rhode Island)");
                break;
            case 3:
                presedentImage.setImageResource(imagesList[position]);
                presentDetailsTextView.setText("Former Governer Donald Trump (Rhode Island)");
                break;
            case 4:
                presedentImage.setImageResource(imagesList[position]);
                presentDetailsTextView.setText("Former Governer Ben Carson (Rhode Island)");
                break;
            case 5:
                presedentImage.setImageResource(imagesList[position]);
                presentDetailsTextView.setText("Former Governer Hilary Cilton (Rhode Island)");
                break;
            case 6:
                presedentImage.setImageResource(imagesList[position]);
                presentDetailsTextView.setText("Former Governer Marco Rubio (Rhode Island)");
                break;
            case 7:
                presedentImage.setImageResource(imagesList[position]);
                presentDetailsTextView.setText("Former Governer Jeb Bush (Rhode Island)");
                break;

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_presidential_election_candidates_frag2, container, false);
        presedentImage = view.findViewById(R.id.presedentImageView);
        presentDetailsTextView = view.findViewById(R.id.presedentNameTextView);

        setFragment(position);

        return view;
    }
}