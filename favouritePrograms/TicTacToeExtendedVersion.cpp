#include <iostream>
#include <cstdlib>
#include <cstdio>
using namespace std;

void visualBoard ( string board[], int boardSideSize ) // the board is changeable and reacts to each player's move
{
    int a = 0;
    for ( int i = 0; i < boardSideSize; i++ )
    {
        for ( int i = 0; i < boardSideSize; i++ )
        {
            cout << board[a];
            if ( a <= 9 || board[a] == "x" || board[a] == "o" )
            {
                cout << " ";
            }
            cout << "|";
            a++;
        }
        cout << endl;
}
}

void possibleMoves ( string board[], int boardSideSize ) // this function is used to show the player all the free fields that can be taken
{
    int boardSize = boardSideSize*boardSideSize;
    cout << "List of remaining possible moves: ";
    for ( int i = 0; i < boardSize - 1; i++ )
    {
        if ( board[i] != "x" && board[i] != "o" )
        {
            cout << board[i] << ", ";
        }
        if ( i % 20 == 0 )
            cout << endl;
    }

    if ( board[boardSize - 1] != "x" && board[boardSize - 1] != "o" )
    {
        cout << board[boardSize - 1];
    }
    cout << endl;
}

bool winningSituation ( string board[], string playerFigure, int boardSideSize )
{
    int a = 0;
    for ( int i = 0; i < boardSideSize; i++ ) // here it is checked whether any four figures are set next to each other horizontally
    {
        for ( int i = 0; i <= boardSideSize - 3; i++ )
        {
            if ( board[a] == playerFigure && board[a+1] == playerFigure && board[a+2] == playerFigure && board[a+3] == playerFigure )
                {
                    return true;
                }
                a++;
        }
    }

    for ( int i = 0; i < boardSideSize*boardSideSize; i++ )  // here it is checked whether any four figures are set next to each other vertically
    {
        if ( board[i] == playerFigure && board[i+boardSideSize] == playerFigure && board[i+boardSideSize*2] == playerFigure && board[i+boardSideSize*3] == playerFigure )
        {
            return true;
        }
    }

    for ( int i = 0; i < boardSideSize*boardSideSize; i++ )  // here it is checked whether any four figures are set next to each other aslant
    {
        if ( board[i] == playerFigure && board[i+boardSideSize+1] == playerFigure && board[i+boardSideSize*2+2] == playerFigure && board[i+boardSideSize*3+3] == playerFigure )
        {
            return true;
        }
    }
    for ( int i = 0; i < boardSideSize*boardSideSize; i++ )  // here it is checked whether any four figures are set next to each other aslant
    {
        if ( board[i] == playerFigure && board[i+boardSideSize-1] == playerFigure && board[i+boardSideSize*2-2] == playerFigure && board[i+boardSideSize*3-3] == playerFigure )
        {
            return true;
        }
    }
    return false;
}

void playerMove ( string board[], int playerNumber, int boardSideSize )
{
    possibleMoves( board, boardSideSize );
    visualBoard( board, boardSideSize );
    int theMove;
    switch ( playerNumber )
    {
        case 1:
        cout << "It's first player's move. Choose where you want to put the cross in: ";
        cin >> theMove;
        break;
        case 2:
        cout << "It's second player's move. Choose where you want to put the circle in: ";
        cin >> theMove;
        break;
    }
    while ( board[theMove] == "x" || board[theMove] == "o" || theMove < 0 || theMove >= boardSideSize*boardSideSize )
    {
        cout << "This field has already been taken or the number is incorrect.\nGive it another try: ";
        cin >> theMove;
    }
    switch ( playerNumber )
    {
        case 1:
        board[theMove] = "x";
        break;
        case 2:
        board[theMove] = "o";
        break;
    }
    cout << endl;
}

int main()
{
    cout << "This is an extended tic-tac-toe game, in which\nthe players can choose the size of the board." << endl;
    cout << "This time to win you need to put 4 of your figures next to each other\nhorizontally, vertically or aslant." << endl;
    cout << "Remember that the board is always a square!\nSize of its side must be a number between 4 and 10.\n" << endl;
    cout << "The side's size of the board for this play: ";
    string board[100] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99"};
    int x;
    cin >> x;
    while ( x < 4 || x > 10 )
    {
        cout << "Wrong number! Give it another try. The side's size of the board for this play: ";
        cin >> x;
    }
    string firstPlayerFigure = "x";
    string secondPlayerFigure = "o";
        for ( int i = 0; i < x*x; i++ )
    {
        playerMove( board, 1, x );
        if (winningSituation( board, firstPlayerFigure, x ))
        {
            cout << "Congratulations! The first player has won!" << endl;
            visualBoard( board, x );
            _exit(true);
        }
        playerMove( board, 2, x );
        if (winningSituation( board, secondPlayerFigure, x ))
        {
            cout << "Congratulations! The second player has won!" << endl;
            visualBoard( board, x );
            _exit(true);
        }
    }
    cout << "There are no winners this time!" << endl;
}











//tactic comment

