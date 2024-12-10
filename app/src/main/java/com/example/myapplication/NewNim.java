package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

    public class NewNim extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate layout для фрагмента
            View rootView = inflater.inflate(R.layout.my_butten, container, false);

            return  rootView;

        }
    }
