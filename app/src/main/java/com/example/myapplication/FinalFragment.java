package com.example.myapplication;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class FinalFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate макет для FinalFragment
        View rootView = inflater.inflate(R.layout.fragment_final, container, false);

        Button nextButton = rootView.findViewById(R.id.ff_button);
        nextButton.setOnClickListener(v -> {



        // Переход на FinalFragment
       NewNim newNim= new NewNim();
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, newNim) // R.id.fragment_container — контейнер для фрагментов
                .addToBackStack(null) // Добавляем в стек возврата, если нужно вернуться назад
                .commit();


        });
        return rootView;
    }
}

