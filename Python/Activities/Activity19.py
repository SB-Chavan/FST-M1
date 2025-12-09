#Activity 19
'''
Using Pandas:

Write the following data into an excel file:
FirstName 	LastName 	Email 	PhoneNumber
Satvik 	Shah 	satshah@example.com 	4537829158
Avinash 	Kati 	avinashk@example.com 	5892184058
Lahri 	Rath 	lahri.rath@example.com 	4528727830
'''

import pandas

from pandas import ExcelWriter

#Create dictionory
data = {
    "FirstName":["Satvik", "Avinash", "Lahri" ],
    "LastName": ["Shah", "Kati", "Rathi"],	
    "Email":["satshah@example.com", "avinashk@example.com", "lahri.rath@example.com"],
    "PhoneNumber": ["4537829158", "5378291598", "397829158"]

}

dataframe = pandas.DataFrame(data)

print(dataframe)

writer =ExcelWriter('activity19.xlsx')

dataframe.to_excel(writer, 'Sheet1', index =False)

writer.close()

