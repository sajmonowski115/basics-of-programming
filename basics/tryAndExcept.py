#This program demonstrates use of try function
#The function recognizes when there is an error in the program
#Than it stops running the code and continues to the except statement

i = 1

while(i):
    try:
        x = int(input("Type an integer number: "))
        i=0
    except:
        print("Something is wrong. Try again")
        i=1

input("Program finished successfully. Press enter to continue...")
        
