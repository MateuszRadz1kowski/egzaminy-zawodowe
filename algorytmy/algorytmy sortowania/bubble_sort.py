numbers = [
    42, 15, 8, -3, 23, 42, 4, 16, 99, 0,
    -15, 7, 88, 1, 2, -99, 55, 33, 10, 0,
    77, -22, 14, 5, 19, 66, -7, 3, 12, 45,
    8, 9, -1, 50, 27, 31, -50, 100, 21, 6
]


def sort(numbers):
    n = len(numbers)
    for i in range(n):
        for j in range(0, n - 1):
            if numbers[j] > numbers[j + 1]:
                temp_number = numbers[j]
                numbers[j] = numbers[j + 1]
                numbers[j + 1] = temp_number
    return numbers

sort(numbers)
print(numbers)
