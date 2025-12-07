#Activity 7
'''
Write a Python program to calculate the sum of all the elements in a list.
Bonus points if you can make the user enter their own list.
'''
#Code

numbers = input("Please enter the list of numbers: ").split(", ")
sum = 0
for x in  numbers:
    sum += int(x)

print(sum)