#Activity 22
#To run -->   pytest Activity22.py -m activity

import pytest

# Additon test
def test_addition():
	
    # Initialize two numbers
	num1 = 20
	num2 = 15
    
	# Add them
	sum = num1 + num2

	# Assertion
	assert sum == 35

# Subtraction test
def test_subtraction():
  
	# Initialize two numbers
	num1 = 50
	num2 = 30
    
	# Subtract them
	diff = num1 - num2

	# Assertion
	assert diff == 20

# Multiplication test
@pytest.mark.activity
def test_multiplication():
  
	# Initialize two numbers
	num1 = 6
	num2 = 10
    
	# Multiply them
	prod = num1 * num2

	# Assertion
	assert prod == 60

# Division test
@pytest.mark.activity
def test_division():
  
	# Initialize two numbers
	num1 = 100
	num2 = 10
    
	# Divide them
	quot = num1 / num2

	# Assertion
	assert quot == 10
