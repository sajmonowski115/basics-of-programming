language = input("What is your language coder: ")
language = language.lower()


if language == 'python':
    print("You will have plenty of work fields to choose from..")
elif language == 'java':
    print("A lot of staff to get through but you shall be rich once you've mastered it..")
elif language == 'c++' or language == 'assembly' or language == 'c':
    print("One day you will be writing programs that run at the speed of light..")
elif language == 'javascript':
    print("You've got the potential to become reala web master..")
else:
    print("Not such a common choice but it's definitely not a downside my friend..")


num = int(input("Enter an int number: "))

if num%2 == 0 and num%5 == 0:
    print("The number is divisible by 2 and 5")
elif num%2 == 0 and num%5 != 0:
    print("The number is divisible by 2 but not by 5")
elif num%2 != 0 and num%5 == 0:
    print("The number is divisible by 5 but not by 2")
else:
    print("The number is neither divisible by 2 nor by 5")

if num%3 == 0 and num%7 == 0:
    print("The number is divisible by 3 and 7")
elif num%3 == 0 or num%7 == 0:
    print("The number is divisible by 3 or by 7")
else:
    print("The number is neither divisible by 2 nor by 5")
