#This program is a hangman game
#author ~ Szymon Bobrowski
#date: 22.02.2020

import sys

HANGMAN = (
#initial state
"""
 ------
 |   
 |
 |
 |
 |
 |
 |
 |
--------
""",
"""
 ------
 |    |
 |
 |
 |
 |
 |
 |
 |
--------
""",
"""
 ------
 |    |
 |    O
 |
 |
 |
 |
 |
 |
--------
""",
"""
 ------
 |    |
 |    O
 |   -+-
 |
 |
 |
 |
 |
--------
""",
"""
 ------
 |    |
 |    O
 |  /-+-/
 |
 |
 |
 |
 |
--------
""",
"""
 ------
 |    |
 |    O
 |  /-+-/
 |    | 
 |
 |
 |
 |
--------
""",
"""
 ------
 |    |
 |    O
 |  /-+-/
 |    | 
 |    |
 |
 |
 |
--------
""",
"""
 ------
 |    |
 |    O
 |  /-+-/
 |    | 
 |    |
 |   |
 |   
 |
--------
""",
"""
 ------
 |    |
 |    O
 |  /-+-/
 |    | 
 |    |
 |   |
 |   |
 |
--------
""",
"""
 ------
 |    |
 |    O
 |  /-+-/
 |    | 
 |    |
 |   | |
 |   |
 |
--------
""",
"""
 ------
 |    |
 |    O
 |  /-+-/
 |    | 
 |    |
 |   | |
 |   | |
 |
--------
"""
)

#print(len(HANGMAN))

#print(HANGMAN[4])


def display(word):
    for letter in word:
        print(letter, end=' ')
    print('\n')

print("This program is a classic hangman game.")
print("Try to guess the word or you may end up badly..")
print("Have some fun and good luck body!")

KEYWORD = "programming"
#print(len(KEYWORD))

guessedLetters = ['_','_','_','_','_','_','_', '_','_','_','_']
guessedWord = ''
#print(len(guessedWord))

print("The word you need to guess is given in such a form:")
display(guessedLetters)

lives = len(HANGMAN)
while lives != 0:
    print("Your options are:\n\
    1) guess a letter in the word\n\
    2) guess the word")
    choice = input("Which option do you choose: ")

    while not choice.isdecimal() or int(choice) not in (1, 2):
        print("Unrecognised command!")
        choice = input("Which option do you choose: ")
        
    choice = int(choice)
    if choice == 1:
        guess = input("Type the letter you think the word includes: ")

        while len(guess) > 1 or not guess.isalpha():
            if len(guess) > 1:
                print("It's not one letter. No cheating please.")
                guess = input("Type the letter you think the word includes: ")
            elif not guess.isalpha():
                print("That's not really a letter.")
                guess = input("Type the letter you think the word includes: ")

        guess = guess.lower()
        if guess in KEYWORD:
            print("You're correct! There is such a letter in the word!")
            if guess == 'm':
                guessedLetters[6] = guess
                guessedLetters[7] = guess
            elif guess == 'r':
                guessedLetters[1] = guess
                guessedLetters[4] = guess
            elif guess == 'g':
                guessedLetters[3] = guess
                guessedLetters[10] = guess
            else:
                guessedLetters[KEYWORD.find(guess)] = guess
            display(guessedLetters)
            if '_' not in guessedLetters:
                print("That's indeed the word! Congratulations body!")
                sys.stdout.write('\a')
                sys.stdout.write('\a')
                sys.stdout.write('\a')
                sys.stdout.flush()
                print()

                break
        else:
            print("Sorry dude, no such letter in the keyword.")
            print(HANGMAN[11-lives])
            lives -= 1
            print("Number of remaining tries: ", lives)
            display(guessedLetters)
    elif choice == 2:
        guessedWord = input("What do you think the hidden word is: ")
        if guessedWord.lower() == KEYWORD:
            print("That's indeed the word! Congratulations body!")
            sys.stdout.write('\a')
            sys.stdout.write('\a')
            sys.stdout.write('\a')
            sys.stdout.flush()
            print()
            break
        else:
            print("Sorry. That's not it.")
            print(HANGMAN[11-lives])
            lives -= 1
            print("Number of remaining tries: ", lives)
            display(guessedLetters)

if lives == 0:
    print("GAME OVER")


input("Press enter to continue..")
#useful comment
