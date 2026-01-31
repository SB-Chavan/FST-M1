#Activity 16
'''
Create a car class with the following details:
Properties: manufacturer, model, make, transmission, color

Methods: accelerate(), stop()
accelerate() should print "{Manufacturer} {Model} is moving"
stop() should print "{Manufacturer} {Model} has stopped"
Using this car class, create 3 different car objects.
'''

class Car:

    def __init__(self, manufacturer, model, make, tramsmission, color):
        self.mamanufacturer = manufacturer
        self.model = model
        self.make = make
        self.tramsmission = tramsmission
        self.color = color

    def accelerate(self):
        print(self.mamanufacturer + "  " + self.model +  " has started moving ")
    
    def stop(self):
        print(self.mamanufacturer + " " + self.model + " has stopped ")
    
car1 = Car("TOYOTO", "INNOVA", "2024", "Manual", "White" )
car2 = Car("Maruti", "800", "2013", "Manual", "Red")
car3 = Car("Suzuki", "Swift", "2017", "Automatic", "Black")

car1.accelerate()
car1.stop()