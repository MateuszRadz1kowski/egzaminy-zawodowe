import random

small_letters = "abcdefghijklmnopqrstuvwxyz"
capital_letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
diactric_letters = "ąęłńóśźżĄĘŁŃÓŚŹŻ"
numbers = "0123456789"
special_characters = "!@#$%^&*()_+"
avalible_characters = ["small_letters","small_letters", "small_letters", "capital_letters", "capital_letters", "capital_letters", "diactric_letters", "diactric_letters", "numbers", "numbers", "special_characters", "special_characters" ]

def generate_password():
    random_password = ""
    for i in range(len(avalible_characters)):
        random_character_type = random.choice(avalible_characters)
        match random_character_type:
            case "small_letters":
                random_password += random.choice(small_letters) 
            case "capital_letters":
                random_password += random.choice(small_letters)
            case "diactric_letters":
                random_password += random.choice(small_letters) 
            case "numbers":
                random_password += random.choice(small_letters) 
            case "special_characters":
                random_password += random.choice(small_letters)

    return random_password

for i in range(0,5):
    print(f"Hslo nr {i+1}: {generate_password()}")