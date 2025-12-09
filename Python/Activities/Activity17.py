#Activity 17 --Writing CSV file
'''
Using Pandas:

Write the following data into a CSV file.
Usernames 	Passwords
admin 	password
Charles 	Charl13
Deku 	AllMight
'''


import pandas

data ={
    "username": ["vinode", "sachin", "sandip", "ankush"],
    "password": ["pass1","pass2", "pass3", "pass4"]

}

dataframe=pandas.DataFrame(data)

print(dataframe)

dataframe.to_csv("SampleCredentials.csv", index=False)
