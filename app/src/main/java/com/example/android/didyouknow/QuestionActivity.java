package com.example.android.didyouknow;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 12/03/16.
 */
public class QuestionActivity extends AppCompatActivity {

    private int score = 0;
    private int index_currentProblem = 0;
    private List<Problem> allProblems = new ArrayList<Problem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_activity);

        /*
         Instanciando o Quiz.
         */
        this.allProblems.add( new Problem("Porque o teclado do computador não segue a ordem alfabética?",
                "Pra separar as letras mais usadas na lingua inglesa.",
                "Não houve pensamento prévio sobre o assunto, fizeram errado e as pessoas se acostumaram.",
                "O primeiro teclado foi feito em Madarim e o teclado americano seguiu a ordem alfabética chinesa.",
                1) );
        this.allProblems.add( new Problem("Porque se atira arroz aos noivos?",
                "A prática foi criada na Japão, onde se acredita que o arroz tenha poderes purificares, para afastar todo mal.",
                "Na antiga china, dizia-se que o arroz era símbolo de prosperidade e abundância. Joga-los significa passar boas expectativas.",
                "A tradição foi adotada para simular a neve e dar um ar de romance hollywoodiano no casamento.",
                2) );
        this.allProblems.add( new Problem("\"Os touros enxergam em braco e preto\", Então por quê eles reagem a cor vermelha?",
                "Touros não notam a diferença de cores, numa tourada o que importa é como a capa é balançada.",
                "A cor vermelha quando vista em preto e branco é uma cor tão clara que irrita a visão.",
                "Os touros de touradas são treinados a reagir a capa vermelha, mas não tem efeito algum em touros selvagens.",
                1) );
        this.allProblems.add( new Problem("Qual o significado de inescrupuloso?",
                "Aquilo que não está decidido, indecisivo",
                "Aquele que reclama de tudo.",
                "Aquele que não age pelos principios morais.",
                3) );
        this.allProblems.add( new Problem("Quantos ovos um mosquito da dengue produz em seu tempo de vida?",
                "Até 100 ovos.",
                "Até 300 ovos.",
                "Até 450 ovos.",
                3) );
        display( this.allProblems.get(0) );
        this.index_currentProblem = 0;

        //Set onClick on Next button
        Button button = (Button) findViewById(R.id.nextButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                nextQuestion();
            }
        });

    }


    /*
     Function for show the question and the answers on the screeen;
     */
    private void display(Problem problem) {
        List<String> answers = problem.getAnswer();

        TextView question_TextView = (TextView) findViewById(R.id.questionTextView);
        question_TextView.setText(problem.getQuestion());

        RadioButton radioButton = (RadioButton) findViewById(R.id.rButton1);
        radioButton.setText( answers.get((0)));

        radioButton = (RadioButton) findViewById(R.id.rButton2);
        radioButton.setText( answers.get((1)));

        radioButton = (RadioButton) findViewById(R.id.rButton3);
        radioButton.setText( answers.get((2)));
    }

    /*
    Action of the Next Button
     */
    private void nextQuestion(){
        //Analysing the current problem before getting another one.
        Problem currentProblem = this.allProblems.get( this.index_currentProblem);
        int rightChoice = currentProblem.getRealAnswer();

        RadioButton radioButton;
        if (rightChoice == 0)
            radioButton = (RadioButton) findViewById(R.id.rButton1);
        else if (rightChoice == 1)
            radioButton = (RadioButton) findViewById(R.id.rButton2);
        else if (rightChoice == 2)
            radioButton = (RadioButton) findViewById(R.id.rButton3);
        else
            return;

        if (radioButton.isChecked()) {
            score += 1;
            Toast.makeText(this, "correto!", Toast.LENGTH_SHORT ).show();
        } else{
            Toast.makeText(this, "errado!", Toast.LENGTH_SHORT ).show();
        }

        this.index_currentProblem += 1;
        if(this.index_currentProblem >=5) {
            Intent myIntent = new Intent( this , SummaryActivity.class);
            myIntent.putExtra("score", score);
            startActivity(myIntent);
            finish();
            return ;
        }
        currentProblem = this.allProblems.get( this.index_currentProblem);
        display(currentProblem);
    }



}
