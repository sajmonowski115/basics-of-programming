"""
The datastructure type that fits best for creating a json file in python
is a dictionary. If you need to create a json file based on some data
received in a pyton script store this data as a dictionary.
When you open a json file in python it is going to be stored as a dictionary.
"""

import json

#creating and writing to a file
person = {"name" : "Carol", "age" : 25, "city" : "London"}
with open('to_write.json', 'w') as file:
    json.dump(person, file)


#reading from a file
dictionary = {}
with open('to_read.json', 'r') as file:
    dictionary = json.load(file)

print(dictionary)


input("Press enter to finish the program..")
