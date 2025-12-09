#Activity 20   --Reading Excel Files
'''
Using Pandas:
Use pandas to read data the Excel file

    Print the number of rows and columns
    Print the data in the emails column only
    Sort the data based on FirstName in ascending order and print the data

Hint: You can use DataFrame.shape to get the number of rows and columns
'''

#Code:

import pandas

dataframe = pandas.read_excel('Activity20_EXL.xlsx')

print("All Excel Data:")
print(dataframe)

print("Number of rows and columns in excel (row, col): ")
print(dataframe.shape)

print("The all email Id's: ")
print(dataframe["Email"])


print("Sort the data with firstname as ascnding and print")
print(dataframe.sort_values("FirstName"))
