package ca.serenacassell.wordsearch;
/*
This game is a word searching game where you have to find words from letters on a grid.
We would like you to write a program to help find if a word is present on the board.
Given a 2D character array representing the game board, as well as a word in the form of a string, implement a function isInBoard that
determines if the word is in the board.

A word is a valid word on the board when its letters are adjacent (above, below, left, or right), in order.
You cannot use the same position more than once when forming a word.

For example on this board, APPLE is valid and ALPHA is not:
B S D A D
I O P P E
Q R L G Z
L P E O O
A H S K J

//  */

import java.util.*;

public class WordSearch {

    private static BoardCoordinates isLetterOnBoard(Board theBoard, char theLetter, int letterInWord, List<BoardCoordinates> coordinatesList){
        //TODO: Check the cross-pattern of the current location, ignoring any locations that have already been used.

        //check up
        //check down
        //check left
        //check right

        return null;
    }

    private static boolean isWordOnBoard(Board theBoard, String wordToCheck){
        List<BoardCoordinates> coordinateList = new ArrayList<>();

        BoardCoordinates startingPoint = theBoard.getCurrentLocation().copy();

        for (int charNum=0; charNum < wordToCheck.length(); charNum++) {
            char letterToFind = wordToCheck.charAt(charNum);

            if (charNum == 0){
                //Traverse the board to find the first letter
                while (theBoard.getCurrentLocation() != null && theBoard.getChar() != letterToFind){
                    theBoard.updateLocationOnBoard();
                }

                if (theBoard.getCurrentLocation() != null){
                    startingPoint = theBoard.getCurrentLocation().copy();
                    coordinateList.add(startingPoint);
                    System.out.println(letterToFind+" found at "+startingPoint.getPrintOutput());
                }else{
                    //No need to continue processing. The first letter is not on the board at all.
                    theBoard.resetLocation(startingPoint);
                    System.out.println(wordToCheck + " cannot be found");
                    return false;
                }

            }else{
                //Find a subsequent letter
                if (coordinateList.size() > 0) {
                    //TODO: BoardCoordinates subsequentLetter = isLetterOnBoard();
                    //Check to see if current letter is in cross pattern and not already used.
                    //Found: Easy, add to list, next letter
                    //Not Found: Hard. Back up one letter, black list this location
                    //List<BoardCoordinates> currentWordAttempt
                    //List<BoardCoordinates> blackListedLocations??
                    //This is harder than it seems....
                }
            }

        }

        //Overall, was the word found?
        if (coordinateList.size() > 0) {
            return true;
        }else{
            return false;
        }
    }

    private static void doTest(int testNumber, Board board, String word, boolean expectation){
        boolean testResult = isWordOnBoard(board, word);

        if (testResult == expectation)
            System.out.println("Test " + testNumber + " passed.\n");
        else
            System.out.println("Test " + testNumber + " failed. Expected: " + expectation + " Actual: " + testResult + "\n");
    }

    public static void main(String[] args) {
        char[][] boardArray = {
                {'B', 'S', 'D', 'A', 'D'},
                {'I', 'O', 'P', 'P', 'E'},
                {'Q', 'R', 'L', 'G', 'Z'},
                {'L', 'P', 'E', 'O', 'O'},
                {'A', 'H', 'S', 'K', 'J'}
        };

        Board theBoard = new Board(boardArray);
        theBoard.print();
        System.out.println("\nTests:");

        doTest(1, theBoard, "XRAY", false);
        doTest(2, theBoard, "APPLE", true);
        //doTest(2, board, "ALPHA", false);
    }


}
