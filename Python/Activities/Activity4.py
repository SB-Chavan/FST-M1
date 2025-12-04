#Activity 4
'''
Using Loops:

    Enhance the previously written Rock-Paper-Scissors code so that it asks the user if they want to play another round.
    If they say 'Yes', the game should begin again.
    If they say 'No', the game should exit.
'''



while True:
    user1 = (input("Choose from Rock, paper or Scissors? User1 value:")).lower()
    user2 = (input("Choose from Rock, paper or scissors? User2 value:")).lower()

    print(user1)
    print(user2)
    if user1 == user2:
        print("Tie")
    elif user1 == "rock":
        if user2 == "scissors":
            print("Rock Wins!")
        else:
            print("Paper Wins")
    elif user1 == "scissors":
        if user2 == "paper":
            print("Scissors Wins!")
        else:
            print("Rock Wins!")
    elif user1 == "paper":
        if user2 == "Rock":
            print("Paper Wins!")
        else:
            print("Scissors Wins!")
    else:
        print("Invalid Input .. Try again with valid input")


    replay=input("Do you want to replay the game? Yes / No: ").lower()

    if(replay == "yes"):
        pass
    elif(replay == "no"):
        raise SystemExit
    else:
        print("Invalid Input ..Terminating..")
        raise SystemExit
    

 

