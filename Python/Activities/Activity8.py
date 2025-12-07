#Activity 8
'''
Given a list of numbers, return True if first and last number of a list is same.

    Bonus points if you can make the user enter their own list.
'''

#Code

numbers = input ("please enter the list of numners: ").split(", ")

sum = 0

firstNum = int(numbers[0])
lastNum = int(numbers[-1])

if firstNum == lastNum:
    print(True)
else:
    print(False)

