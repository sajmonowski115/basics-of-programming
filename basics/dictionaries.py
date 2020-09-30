engineer_age = {"John" : 27, "Simon" : 20, "Juliet" : 32}

#accessing a value of a key
print(engineer_age['John']) #27

#printing all keys
print(engineer_age.keys())

#printing all values
print(engineer_age.values())

#adding a new value
engineer_age['Martin'] = 25

#modifying a value
engineer_age['John'] = 47

#looping through dictionary keys
for key in engineer_age:
    print(key)

#looping through dictionary values
for value in engineer_age.values():
    print(value)

#getting both the keys and values at once
for key,value in engineer_age.items():
    print(key, value)

#size of the dictionary
print("length of the dictionary:", len(engineer_age))

