'''
#open the file in read mode
file = open('to_read.txt', 'r')

#print file name
print(file.name)

#print file mode
print(file.mode)

#close the file
file.close()
'''

with open('to_read.txt', 'r') as file:

    #store lines in a list without /n symbol
    '''
    lst = []
    for line in file:
        line = line[:-1]
        lst.append(line)
    print(lst)
    '''

    #come back to the beginning of the file
    #file.seek(0)
    
    #read one line of the file
    #first_line = file.readline()
    #print(first_line)

    #show file content
    #print(file.read())

    #store file content to a variable
    #file_content = file.read()
    #print(file_content)

    #create a list containing lines of the file
    '''
    lines = []
    for line in file:
        lines.append(line)
    print(lines)
    '''
