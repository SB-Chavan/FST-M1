#Activity 11 Fruit shop
'''
Create a Python dictionary that contains a bunch of fruits and their prices.
Write a program that checks if a certain fruit is available or not.
'''

fruitShop={
    "apple":100,
    "banana":60,
    "pineapple":80,
    "orange":120

}

availability = input ("What you want to purchase? ").lower()

if(availability in fruitShop):
    print(availability," is Available")
else:
    print(availability, "is not available in shop")
