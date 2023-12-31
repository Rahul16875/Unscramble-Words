//package com.example.unscramblewords
//
//
//import android.app.Activity
//import android.provider.SyncStateContract.Helpers.update
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.wrapContentHeight
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.text.KeyboardActions
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.AlertDialog
//import androidx.compose.material3.Button
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.MaterialTheme.colorScheme
//import androidx.compose.material3.MaterialTheme.shapes
//import androidx.compose.material3.MaterialTheme.typography
//import androidx.compose.material3.OutlinedButton
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.dimensionResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.input.ImeAction
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import kotlinx.coroutines.flow.update
//
////import com.example.unscramble.R
////import com.example.unscramble.ui.theme.UnscrambleTheme
//
//@Composable
//fun GameScreen() {
//    var userGuess by rememberSaveable {
//        mutableStateOf("")
//    }
//    var updatedScore by rememberSaveable {
//        mutableStateOf(0)
//    }
//    var usedWords: MutableSet<String> = mutableSetOf()
//     var currentWord: String
//
//    val mediumPadding = 16.dp
////    var userGuess by rememberSaveable {
////        mutableStateOf("")
////    }
////     var usedWords: MutableSet<String> = mutableSetOf()
////     lateinit var currentWord: String
////
//
//    Column(
//        modifier = Modifier
//            .verticalScroll(rememberScrollState())
//            .padding(mediumPadding),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//        Text(
//            text = stringResource(R.string.app_name),
//            style = typography.titleMedium,
//        )
//
//        GameLayout(
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight()
//                .padding(mediumPadding)
//        )
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(mediumPadding),
//            verticalArrangement = Arrangement.spacedBy(mediumPadding),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//
//            Button(
//                modifier = Modifier.fillMaxWidth(),
//                onClick = { }
//            ) {
//                Text(
//                    text = stringResource(R.string.submit),
//                    fontSize = 16.sp
//                )
//            }
//
//            OutlinedButton(
//                onClick = { },
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text(
//                    text = stringResource(R.string.skip),
//                    fontSize = 16.sp
//                )
//            }
//        }
//
////        GameStatus(score = 0, modifier = Modifier.padding(20.dp))
//    }
//}
//
////@Composable
////fun GameStatus(modifier: Modifier = Modifier) {
////    Card(
////        modifier = modifier
////    ) {
////        Text(
////            text = stringResource(R.string.score),
////            style = typography.headlineMedium,
////            modifier = Modifier.padding(8.dp)
////        )
////    }
////}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun GameLayout(modifier: Modifier = Modifier) {
//    val mediumPadding = 16.dp
//
//    Card(
//        modifier = modifier,
//        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
//    ) {
//        Column(
//            verticalArrangement = Arrangement.spacedBy(mediumPadding),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier.padding(mediumPadding)
//        ) {
//            Text(
//                modifier = Modifier
//                    .clip(shapes.medium)
//                    .background(colorScheme.surfaceTint)
//                    .padding(horizontal = 10.dp, vertical = 4.dp)
//                    .align(alignment = Alignment.End),
//                text = stringResource(R.string.word_count, 0),
//                style = typography.titleMedium,
//                color = colorScheme.onPrimary
//            )
//            Text(
//                text = "scrambleun",
//                style = typography.displayMedium
//            )
//            Text(
//                text = stringResource(R.string.instructions),
//                textAlign = TextAlign.Center,
//                style = typography.titleMedium
//            )
//            OutlinedTextField(
//                value = "",
//                singleLine = true,
//                shape = shapes.large,
//                modifier = Modifier.fillMaxWidth(),
//                colors = TextFieldDefaults.textFieldColors(containerColor = colorScheme.surface),
//                onValueChange = { },
//                label = { Text(stringResource(R.string.enter_your_word)) },
//                isError = false,
//                keyboardOptions = KeyboardOptions.Default.copy(
//                    imeAction = ImeAction.Done
//                ),
//                keyboardActions = KeyboardActions(
//                    onDone = { }
//                )
//            )
//        }
//    }
//}
//
///*
// * Creates and shows an AlertDialog with final score.
// */
//@Composable
//private fun FinalScoreDialog(
//    score: Int,
//    onPlayAgain: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    val activity = (LocalContext.current as Activity)
//
//    AlertDialog(
//        onDismissRequest = {
//            // Dismiss the dialog when the user clicks outside the dialog or on the back
//            // button. If you want to disable that functionality, simply use an empty
//            // onCloseRequest.
//        },
//        title = { Text(text = stringResource(R.string.congratulations)) },
//        text = { Text(text = stringResource(R.string.you_scored, score)) },
//        modifier = modifier,
//        dismissButton = {
//            TextButton(
//                onClick = {
//                    activity.finish()
//                }
//            ) {
//                Text(text = stringResource(R.string.exit))
//            }
//        },
//        confirmButton = {
//            TextButton(onClick = onPlayAgain) {
//                Text(text = stringResource(R.string.play_again))
//            }
//        }
//    )
//}
//
//@Composable
//fun pickRandomWordAndShuffle(
////    userGuess:String,
//    currentWord: String,
//    usedWords: MutableSet<String>
//): String {
//
//
//    // Continue picking up a new random word until you get one that hasn't been used before
//    currentWord = allWords.random()
//    return if (usedWords.contains(currentWord)) {
//        pickRandomWordAndShuffle()
//    } else {
//        usedWords.add(currentWord)
//        shuffleCurrentWord(currentWord)
//    }
//}
//
//@Composable
//private fun shuffleCurrentWord(word: String): String {
//    val tempWord = word.toCharArray()
//    // Scramble the word
//    tempWord.shuffle()
//    while (String(tempWord) == word) {
//        tempWord.shuffle()
//    }
//    return String(tempWord)
//}
//
//@Composable
//fun checkUserGuess(
//    userGuess:String,
//    updatedScore: Int,
//    currentWord:String
//) {
//
////    var usedWords: MutableSet<String> = mutableSetOf()
////    lateinit var currentWord: String
//    if (userGuess.equals(currentWord, ignoreCase = true)) {
//        // User's guess is correct, increase the score
//        // and call updateGameState() to prepare the game for next round
////        val updatedScore = _uiState.value.score.plus(SCORE_INC)
//        updatedScore = updatedScore + 1
//        updateGameState(updatedScore)
//    } else {
//        // User's guess is wrong, show an error
////            _uiState.update { currentState ->
////                currentState.copy(isGuessedWordWrong = true)
////            }
//
////            by writting below line instead of above line
////            after submit word if word is wrong then automatically next word pe aa jayega
////            usi word pe ni rahega, means error show ni karega.
//
//        updateGameState(updatedScore)
//    }
//    // Reset user guess
//    updateUserGuess("")
//}
//
//@Composable
//private fun updateGameState(updatedScore: Int) {
//    var usedWords: MutableSet<String> = mutableSetOf()
//    var currentWord: String
//
//    if (usedWords.size == MAX_WORDS){
//        //Last round in the game, update isGameOver to true, don't pick a new word
////        update { currentState ->
////            currentState.copy(
////                isGuessedWordWrong = false,
////                score = updatedScore,
////                isGameOver = true
////            )
////        }
//    } else{
//        // Normal round in the game
////        _uiState.update { currentState ->
////            currentState.copy(
////                isGuessedWordWrong = false,
////                currentScrambledWord = pickRandomWordAndShuffle(),
////                currentWordCount = currentState.currentWordCount.inc(),
////                score = updatedScore
////            )
////        }
//    }
//}
//
//@Composable
//fun updateUserGuess(guessedWord: String){
//    var userGuess by rememberSaveable {
//        mutableStateOf("")
//    }
//    userGuess = guessedWord
//}
