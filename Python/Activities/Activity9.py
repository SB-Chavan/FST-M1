#Activity 9-- Combining List
'''
Given a two list of numbers create a new list such that 
new list should contain only odd numbers from the first list and even numbers from the second list.
'''

firstList =[10, 20, 40, 70, 55, 67]
secondList = [34, 80, 90, 13, 19, 21]

thirdList = []


#Get  odd numbers from first List
for x in firstList:
    if (x % 2 != 0):
        thirdList.append(x)
    

#Get even numbers from secondList

for y in secondList:
    if(y % 2 == 0):
        thirdList.append(y)


print (thirdList)
