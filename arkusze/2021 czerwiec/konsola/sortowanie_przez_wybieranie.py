# nazwa funkcji: znajdz_index_minimalny
# parametry wejsciowe: start_index - index miejca w tablicy w ktorym jest najnowsza posortowana liczba
# wartosc zwracana: index_min - zwraca index na ktorym miejscu jest najnizsza liczba w tablicy

class Sort():
    def __init__(self, array):
        self.array = array
        for i in range(0, 10):
            self.array.append(int(input("Wpisz liczbe do sortowania: ")))

    def __znajdz_index_minimalny(self, start_index):
        index_min = start_index

        for i in range(start_index, len(self.array)):
            if self.array[i] < self.array[index_min]:
                index_min = i

        return index_min

    def sortuj(self):
        for i in range(len(self.array)):
            index_min = self.__znajdz_index_minimalny(i)

            self.array[i], self.array[index_min] = self.array[index_min], self.array[i]

            print(f"Krok {i + 1}: {self.array}")


wybieranie = Sort([])

wybieranie.sortuj()

print("Wynik końcowy:", wybieranie.array)