#Activity 10 Tuple Number Checker
'''
Given a tuple of numbers, iterate through it and print only those numbers which are divisible by 5

    Bonus points if you can make the user enter their own tuple.
'''


#Code:
num_tuple = (10, 25, 46, 56, 80, 100, 175)

print("Tuple Number List:", num_tuple)

for x in num_tuple:
    if x % 5 == 0:
        print("Numbers divisible by 5: ", x)
    