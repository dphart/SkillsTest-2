package me.danielhartman.skillstest;


import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import me.danielhartman.skillstest.databinding.FragmentOneLayoutBinding;

public class FragmentOnePresenter extends Presenter {

    FragmentOneLayoutBinding binding;
    boolean isGameInProgress;
    int numberToGuess;
    List<Integer> numbersGuessed;

    @Override
    public void onResume() {
        startGame();
        onClickButton();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        binding = null;
        numbersGuessed = null;
    }

    public void displayCorrectNumber(int answer){
        binding.answerTextView.setText(String.valueOf(answer));
    }

    public int getRandomInt(){
        return (int)(Math.random()*10);
    }

    public void onClickButton(){
        binding.guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGame();
            }
        });
    }

    public Integer getTextFromEditText(EditText editText) {
        if (editText!=null){
            String textVal = editText.getText().toString();
            return Integer.parseInt(textVal);
        }else{
            return null;
        }
    }

    public void startGame(){
        numberToGuess = getRandomInt();
        numbersGuessed = new ArrayList<>();
        resetGameText();
        displayCorrectNumber(numberToGuess);
        isGameInProgress = true;
    }

    public void clearInput(){
        binding.textInputEditText.setText("");
    }

    public void resetGameText(){
        binding.guessButton.setText("Guess");
        displayNumbersGuessed();

    }

    public boolean isGuessCorrect(int guess){
        return guess == numberToGuess;
    }


    public List<Integer> addNumberToGuesses(int guess){
        numbersGuessed.add(guess);
        return numbersGuessed;
    }

    public void incorrectGuess(int guess){
        addNumberToGuesses(guess);
        displayNumbersGuessed();
    }

    public void displayNumbersGuessed(){
        binding.guessesTextView.setText(getStringOfGuesses());

    }

    public String getStringOfGuesses(){
        String incorrectGuesses = "";
        for (int i : numbersGuessed){
            incorrectGuesses += String.valueOf(i) + " ";
        }
        return incorrectGuesses;
    }

    public void playGame(){
        if (isGameInProgress){
            Integer guess = getTextFromEditText(binding.textInputEditText);
            clearInput();
            if (isGuessCorrect(guess)){
                gameWon();
            }else{
                incorrectGuess(guess);
            }
        }else {
            startGame();
        }
    }

    public void gameWon(){
        isGameInProgress = false;
        binding.guessButton.setText("You Win!, Play Again?");
    }

    public void present(FragmentOneLayoutBinding binding){
        this.binding = binding;
    }
}
