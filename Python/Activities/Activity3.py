#Activity 3
''''
Using Python:

    Make a two-player Rock-Paper-Scissors game.
    Remember the rules:
        Rock beats scissors
        Scissors beats paper
        Paper beats rock

'''

user1 = (input("Choose from Rock, paper or Scissors? User1 value:")).lower()
user2 = input("Choose from Rock, paper or scissors? User2 value:")

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


