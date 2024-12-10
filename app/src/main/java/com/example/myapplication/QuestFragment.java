package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class QuestFragment extends Fragment {

    private final String[] tasks = {
            "Задание 1: Найди елочную игрушку с подсказкой!",
            "Задание 2: Ответь на вопрос: сколько у оленя Санты ног?",
            "Задание 3: Спой любую новогоднюю песню!",
            "Задание 4: Придумай свое новогоднее желание!"
    };

    private int currentTaskIndex = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_quest, container, false);

        TextView taskTextView = view.findViewById(R.id.task_text);
        ProgressBar progressBar = view.findViewById(R.id.progress_bar);
        Button nextButton = view.findViewById(R.id.next_button);

        progressBar.setMax(tasks.length);
        updateTask(taskTextView, progressBar);

        nextButton.setOnClickListener(v -> {
            currentTaskIndex++;
            if (currentTaskIndex < tasks.length) {
                updateTask(taskTextView, progressBar);
            } else {
                // Переход на FinalFragment
                FinalFragment finalFragment = new FinalFragment();
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, finalFragment) // R.id.fragment_container — контейнер для фрагментов
                        .addToBackStack(null) // Добавляем в стек возврата, если нужно вернуться назад
                        .commit();
            }
        });

        return view;
    }

    private void updateTask(TextView taskTextView, ProgressBar progressBar) {
        taskTextView.setText(tasks[currentTaskIndex]);
        progressBar.setProgress(currentTaskIndex + 1);
    }
}
