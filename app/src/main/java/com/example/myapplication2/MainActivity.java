package com.example.myapplication2;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtQuestion, txtAnswer;
    Button btnShowAnswer, btnNext, btnPrev, btnManage;
    ArrayList<Flashcard> flashcards;
    int currentIndex = 0;
    boolean isAnswerVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtQuestion = findViewById(R.id.txtQuestion);
        txtAnswer = findViewById(R.id.txtAnswer);
        btnShowAnswer = findViewById(R.id.btnShowAnswer);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);
        btnManage = findViewById(R.id.btnManage);

        // Sample flashcards
        // Sample flashcards (50 Questions)
        flashcards = new ArrayList<>();

        flashcards.add(new Flashcard("What is Java?", "Java is an OOP programming language."));
        flashcards.add(new Flashcard("Capital of India?", "New Delhi"));
        flashcards.add(new Flashcard("DBMS full form?", "Database Management System"));
        flashcards.add(new Flashcard("Who is the father of Computer?", "Charles Babbage"));
        flashcards.add(new Flashcard("RAM stands for?", "Random Access Memory"));
        flashcards.add(new Flashcard("CPU stands for?", "Central Processing Unit"));
        flashcards.add(new Flashcard("Founder of C language?", "Dennis Ritchie"));
        flashcards.add(new Flashcard("SQL stands for?", "Structured Query Language"));
        flashcards.add(new Flashcard("Which company developed Android?", "Google"));
        flashcards.add(new Flashcard("HTML stands for?", "HyperText Markup Language"));

        flashcards.add(new Flashcard("OOP full form?", "Object Oriented Programming"));
        flashcards.add(new Flashcard("Primary key uniqueness?", "Yes, always unique"));
        flashcards.add(new Flashcard("IP stands for?", "Internet Protocol"));
        flashcards.add(new Flashcard("Which layer is TCP in OSI?", "Transport Layer"));
        flashcards.add(new Flashcard("AI full form?", "Artificial Intelligence"));
        flashcards.add(new Flashcard("ML full form?", "Machine Learning"));
        flashcards.add(new Flashcard("Which DB is NoSQL?", "MongoDB"));
        flashcards.add(new Flashcard("Android latest version?", "Android 15 (Vanilla Ice Cream)"));
        flashcards.add(new Flashcard("Python creator?", "Guido van Rossum"));
        flashcards.add(new Flashcard("First search engine?", "Archie"));

        flashcards.add(new Flashcard("C++ invented by?", "Bjarne Stroustrup"));
        flashcards.add(new Flashcard("What is IDE?", "Integrated Development Environment"));
        flashcards.add(new Flashcard("What is Firebase?", "A backend platform by Google for apps"));
        flashcards.add(new Flashcard("JSON full form?", "JavaScript Object Notation"));
        flashcards.add(new Flashcard("What is recursion?", "Function calling itself"));
        flashcards.add(new Flashcard("HTTP full form?", "HyperText Transfer Protocol"));
        flashcards.add(new Flashcard("URL full form?", "Uniform Resource Locator"));
        flashcards.add(new Flashcard("What is DNS?", "Domain Name System"));
        flashcards.add(new Flashcard("Compiler use?", "Convert source code to machine code"));
        flashcards.add(new Flashcard("Interpreter use?", "Executes code line by line"));

        flashcards.add(new Flashcard("Android uses which language?", "Java, Kotlin"));
        flashcards.add(new Flashcard("What is Linux?", "An open-source operating system"));
        flashcards.add(new Flashcard("IPV4 length?", "32 bits"));
        flashcards.add(new Flashcard("IPV6 length?", "128 bits"));
        flashcards.add(new Flashcard("Binary system base?", "Base 2"));
        flashcards.add(new Flashcard("Hexadecimal base?", "Base 16"));
        flashcards.add(new Flashcard("ASCII full form?", "American Standard Code for Information Interchange"));
        flashcards.add(new Flashcard("Unicode use?", "Universal character encoding standard"));
        flashcards.add(new Flashcard("Git creator?", "Linus Torvalds"));
        flashcards.add(new Flashcard("GitHub is?", "A code hosting platform"));

        flashcards.add(new Flashcard("Cloud computing example?", "AWS, Azure, GCP"));
        flashcards.add(new Flashcard("What is API?", "Application Programming Interface"));
        flashcards.add(new Flashcard("SQL command to fetch?", "SELECT"));
        flashcards.add(new Flashcard("SQL command to insert?", "INSERT INTO"));
        flashcards.add(new Flashcard("SQL command to delete?", "DELETE"));
        flashcards.add(new Flashcard("SQL command to update?", "UPDATE"));
        flashcards.add(new Flashcard("SQL command to create table?", "CREATE TABLE"));
        flashcards.add(new Flashcard("SQL command to remove table?", "DROP TABLE"));
        flashcards.add(new Flashcard("OSI layers?", "7 Layers"));
        flashcards.add(new Flashcard("TCP/IP layers?", "4 Layers"));

        showFlashcard();

        btnShowAnswer.setOnClickListener(v -> {
            isAnswerVisible = !isAnswerVisible;
            txtAnswer.setVisibility(isAnswerVisible ? View.VISIBLE : View.INVISIBLE);
        });

        btnNext.setOnClickListener(v -> {
            if (currentIndex < flashcards.size() - 1) {
                currentIndex++;
                isAnswerVisible = false;
                showFlashcard();
            }
        });

        btnPrev.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                isAnswerVisible = false;
                showFlashcard();
            }
        });

        btnManage.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ManageFlashcardsActivity.class);
            startActivity(intent);
        });
    }

    private void showFlashcard() {
        Flashcard card = flashcards.get(currentIndex);
        txtQuestion.setText(card.getQuestion());
        txtAnswer.setText(card.getAnswer());
        txtAnswer.setVisibility(View.INVISIBLE);
    }
}
