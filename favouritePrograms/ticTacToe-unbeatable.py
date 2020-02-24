#This project is a classical tic tac toe game
#author~ Szymon Bobrowski
#date: 24.02.2020

import copy

def displayBoard(board):
    #displays the board with its free and taken filds
    print("The board visually:")
    print('-------------')
    i=0
    for element in board:
        print('| '+str(element), end=' ')
        i+=1
        if (i % 3) == 0:
            print('|')
            print('-------------')
    print()

def correctMoves(board):
    #displays all possible moves
    print("List of possible moves:")
    for element in board:
        if element in range(1,10):
            if (board.index(element))+1 == len(board):
                print(element)
                break
            print(element, end=', ')
    #print(correctMoves2(board))
    print()

def correctMoves2(board):
    #returns all possible moves
    theMoves = []
    for element in board:
        if element not in ('X', 'O'):
            theMoves.append(element-1)
    return theMoves

    
def isCorrect(move, board):
    if not move.isdecimal():
        return False
    if not int(move) in range(1, 10):
        return False
    if board[int(move)-1] == 'O' or board[int(move)-1] == 'X':
        return False
    return True

def playerMove(board):
    #controlls the move of the player
    displayBoard(board)
    correctMoves(board)
    move = input("Where to put the X: ")
    while not isCorrect(move, board):
        print("Incorrect move!")
        move = input("Where to put the X: ")
    move = int(move)
    return move

def computerMove(board):
    #controlls the move of the computer
    for move in correctMoves2(board):
        temporary = copy.copy(board[move])
        board[move] = 'O'
        if winner('O', board):
            return move
        board[move] = temporary
    
    for move in correctMoves2(board):
        temporary = copy.copy(board[move])
        board[move] = 'X'
        if winner('X', board):
            return move
        board[move] = temporary
        
    
    if board[0] == 'X' and board[8] == 'X' and 1 in correctMoves2(board): return 1
    if board[2] == 'X' and board[6] == 'X' and 1 in correctMoves2(board): return 1
    if board[6] == 'X' and board[2] == 'X' and 1 in correctMoves2(board): return 1
    if board[8] == 'X' and board[0] == 'X' and 1 in correctMoves2(board) : return 1
    
    BEST_MOVES = (4,0,2,6,8,1,3,5,7)

    for move in BEST_MOVES:
        if move in correctMoves2(board):
            return move
    
    

def winner(player, board):
    #checks if someone has won the game
    winningSituations = (
                        (0,1,2), (3,4,5), (6,7,8), #horizontally
                        (0,3,6), (1,4,7), (2,5,8), #uprigth
                        (0,4,8), (2,4,6) #aslant
                         )
    for situation in winningSituations:
        if(board[situation[0]], board[situation[1]], board[situation[2]]) == (player, player, player):
            return True
    return False

def main():
    board = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    print("This program is an unbeatable tic tac toe game.")
    choice = input("Do you want to be the one who begins?[y/n] ").lower()
    while choice not in ('y', 'n'):
        print("Unrecognized answer!")
        choice = input("Do you want to start?[y/n] ").lower()

    
    if choice == 'y':
        for i in range(9):
            board[playerMove(board)-1] = "X"
            if winner('X', board) or i==4:
                break
            board[computerMove(board)] = "O"
            if (winner('O', board)):
                break
    else:
        for i in range(9):
            board[computerMove(board)] = "O"
            if (winner('O', board) or i==4):
                break
            board[playerMove(board)-1] = "X"
            if (winner('X', board)):
                break

    if winner('O', board):
        displayBoard(board)
        print("GAME OVER")
    elif winner('X', board):
        displayBoard(board)
        print("You're the winner this time")
    else:
        displayBoard(board)
        print("This match has ended with a draw")

    input("Press enter to continue..")


    
main()







#COMMENT
