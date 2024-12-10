package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate layout для фрагмента
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Найти кнопку по ID
        Button startButton = rootView.findViewById(R.id.start_button);

        // Установить OnClickListener для кнопки
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создать новый экземпляр QuestFragment
                QuestFragment questFragment = new QuestFragment();

                // Перейти к новому фрагменту с помощью FragmentTransaction
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, questFragment) // Заменить текущий фрагмент
                        .addToBackStack(null) // Добавить в BackStack, чтобы можно было вернуться
                        .commit();
            }
        });

        return rootView;
    }
}



