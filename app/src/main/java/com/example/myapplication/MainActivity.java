package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Вызываем метод суперкласса для создания Activity
        setContentView(R.layout.activity_main); // Устанавливаем макет активности (activity_main.xml)

        // Инициализация нижней панели навигации
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Проверяем, есть ли сохранённое состояние (например, при перевороте экрана)
        if (savedInstanceState == null) {
            // Если состояние отсутствует, загружаем HomeFragment по умолчанию
            loadFragment(new HomeFragment());
        }

        // Устанавливаем обработчик выбора элементов на нижней панели навигации
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null; // Переменная для хранения выбранного фрагмента

            // Проверяем, какой пункт меню был выбран
            if (item.getItemId() == R.id.my_home) {
                // Если выбран пункт "Главная", создаём HomeFragment
                selectedFragment = new HomeFragment();
            } else if (item.getItemId() == R.id.my_exit) {
                // Если выбран пункт "Выход", завершаем приложение
                finishAffinity(); // Завершает все активности и закрывает приложение
                return true; // Возвращаем true, так как обработка выполнена
            } else if (item.getItemId() == R.id.my_button) {
                Toast.makeText(MainActivity.this,"Hohohoho!", Toast.LENGTH_LONG).show();
        }

            // Если выбран какой-либо фрагмент, загружаем его
            if (selectedFragment != null) {
                loadFragment(selectedFragment);
            }

            return true; // Возвращаем true, чтобы указать, что выбор обработан
        });
    }

    // Метод для загрузки фрагментов в контейнер
    private void loadFragment(Fragment fragment) {
        // Используем FragmentManager для управления транзакциями фрагментов
        getSupportFragmentManager()
                .beginTransaction() // Начинаем транзакцию
                .replace(R.id.fragment_container, fragment) // Заменяем текущий фрагмент новым
                .commit(); // Подтверждаем транзакцию
    }
}


