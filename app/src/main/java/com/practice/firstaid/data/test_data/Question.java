package com.practice.firstaid.data.test_data;

public class Question {
    private int number;
    private String question;
    private Answer first_answer;
    private Answer second_answer;
    private Answer third_answer;

    public Question(int number, String question, Answer first_answer, Answer second_answer, Answer third_answer) {
        this.number = number;
        this.question = question;
        this.first_answer = first_answer;
        this.second_answer = second_answer;
        this.third_answer = third_answer;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getFirst_answer() {
        return first_answer;
    }

    public void setFirst_answer(Answer first_answer) {
        this.first_answer = first_answer;
    }

    public Answer getSecond_answer() {
        return second_answer;
    }

    public void setSecond_answer(Answer second_answer) {
        this.second_answer = second_answer;
    }

    public Answer getThird_answer() {
        return third_answer;
    }

    public void setThird_answer(Answer third_answer) {
        this.third_answer = third_answer;
    }
}
