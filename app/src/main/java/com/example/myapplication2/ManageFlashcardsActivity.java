package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;

public class ManageFlashcardsActivity extends AppCompatActivity {

    EditText edtQuestion, edtAnswer;
    Button btnAdd, btnDelete, btnEdit;
    ListView listView;
    ArrayList<Flashcard> flashcards;
    ArrayAdapter<String> adapter;
    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_flashcards);

        edtQuestion = findViewById(R.id.edtQuestion);
        edtAnswer = findViewById(R.id.edtAnswer);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnEdit = findViewById(R.id.btnEdit);
        listView = findViewById(R.id.listView);

        flashcards = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getFlashcardTitles());
        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(v -> {
            String q = edtQuestion.getText().toString();
            String a = edtAnswer.getText().toString();
            if (!q.isEmpty() && !a.isEmpty()) {
                flashcards.add(new Flashcard(q, a));
                refreshList();
                edtQuestion.setText("");
                edtAnswer.setText("");
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            selectedIndex = position;
            edtQuestion.setText(flashcards.get(position).getQuestion());
            edtAnswer.setText(flashcards.get(position).getAnswer());
        });

        btnEdit.setOnClickListener(v -> {
            if (selectedIndex != -1) {
                flashcards.get(selectedIndex).setQuestion(edtQuestion.getText().toString());
                flashcards.get(selectedIndex).setAnswer(edtAnswer.getText().toString());
                refreshList();
            }
        });

        btnDelete.setOnClickListener(v -> {
            if (selectedIndex != -1) {
                flashcards.remove(selectedIndex);
                refreshList();
                edtQuestion.setText("");
                edtAnswer.setText("");
                selectedIndex = -1;
            }
        });
    }

    private void refreshList() {
        adapter.clear();
        adapter.addAll(getFlashcardTitles());
        adapter.notifyDataSetChanged();
    }

    private ArrayList<String> getFlashcardTitles() {
        ArrayList<String> titles = new ArrayList<>();
        for (Flashcard card : flashcards) {
            titles.add(card.getQuestion());
        }
        return titles;
    }
}
