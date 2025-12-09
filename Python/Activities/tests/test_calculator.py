#Activity 21   Calculator Test
'''
Using pytest:

Create a new test file and write test to validate the following cases:

    Sum of two numbers
    Difference of two numbers
    Product of two numbers
    Quotient of two numbers
'''
import pytest


#Addition of two numbers
def test_addition():

    num1 = 10
    num2 = 20

    sum = num1 + num2

    assert sum == 30

#Difference between two numbers
def test_difference():

    num1 = 100
    num2 = 50

    diff = num1 - num2

    assert diff == 50

#Multiplication of two numbers
@pytest.mark.activity
def test_multiply():

    num1 = 15
    num2 = 2

    multiply = num1 * num2

    assert multiply == 34

# division  num1 by num2
@pytest.mark.activity 
def division():

    num1 = 40
    num2 = 10

    div = num1 / num2

    assert div == 4






    
