#Activity 13  --Adding List Numbers:
'''
Write a function sum() such that it can accept a list of elements and print the sum of all elements
'''

#Code
# Custom function to calculate sum
def calculateSum(numbers):
	sum = 0
	for x in numbers:
		sum += x
	return sum

# Define the list of numbers
numList = [21, 30, 56, 57, 80]

# Call the sum() function with numList as argument
result = int(calculateSum(numList))

# Print sum of all list numbers
print("The sum of all the numbers of list is: ", result)

