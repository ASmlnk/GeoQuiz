package com.bignerdranch.android.geoquiz

import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel: ViewModel() {

    var currentIndex = 0
    var isCheater = false
    var answerIsTrue = false
    var isCheaterIndex = 0
    var cheaterIndexAttempts = 3

    private val questionBlank = listOf(
        Question(R.string.question_australia,true),
        Question(R.string.question_oceans,true),
        Question(R.string.question_mideast,false),
        Question(R.string.question_africa,false),
        Question(R.string.question_americas,true),
        Question(R.string.question_asia,true))

    val currentQuestionAnswer: Boolean
        get() = questionBlank[currentIndex].answer
    val currentQuestionText: Int
        get() = questionBlank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = ( currentIndex + 1 ) % questionBlank.size
    }
    fun answerTextShowAnswerButton(answerIsTrue: Boolean): Int {
        val answerText = when {
            answerIsTrue -> R.string.true_button
            else -> R.string.false_button
        }
        return answerText
    }
    fun updateCheaterIndexAttempts() {
        cheaterIndexAttempts -= isCheaterIndex
    }
}