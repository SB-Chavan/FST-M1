#Activity 14
''''
Using Recursion:
   Write a program that asks the user how many Fibonnaci numbers to generate and then generates them.
   Hint: The Fibonnaci seqence is a sequence of numbers where the next number in the sequence is the
     sum of the previous two numbers in the sequence. The sequence looks like this: 1, 1, 2, 3, 5, 8, 13, …
'''

def fibonacci(num):
    if num <= 1:
        return num
    else:
        return(fibonacci(num-1) + fibonacci(num-2))

nterms = int(input("Enter a number: "))

if nterms <= 0:
    print("Please enter the valid number")
else:
    print("Fibonacci Sequence if givern number: ")
    for i in range(nterms):
        print(fibonacci(i))