import random

class ObiektTablica:
    __tablica = list
    __liczba_elementow = 0

# **********************************************
# nazwa metody: __init__
# opis metody: konstruktor klasy
# parametry: 1 - ile elementow ma miec tablica
# zwracany typ i opis: brak
# autor: 00000000
# ***********************************************
    def __init__(self,liczba_elementow):
        self.__liczba_elementow = liczba_elementow
        self.__tablica = [0]*liczba_elementow
        for i in range(0,len(self.__tablica)):
            self.__tablica[i] = random.randint(1,1000)

#**********************************************
# nazwa metody: wyswietl_elementy
# opis metody: wyswietla wszystkie elementy tablicy w formacie zgodnym z wymaganiami
# parametry: brak
# zwracany typ i opis: brak
# autor: 00000000
# ***********************************************
    def wyswietl_elementy(self):
        print("Wyswietlam wszystkie elementy tablicy")
        for i in range(0,len(self.__tablica)):
            print(f"{i}:{self.__tablica[i]}")

#**********************************************
# nazwa metody: wyszukaj_element
# opis metody: wyszukuje index na ktorym jest najblizsza wartosc wybrana przez uzytkownika
# parametry: 1 - szukana_wartosc - jaką wartosc funkcja ma znalezc
# zwracany typ i opis: zwracany typ: Int, opis: gdy znaleziono wybrana wartosc zwraca index tej wartosci, jesli nie znaleziono to zwraca -1
# autor: 00000000
# ***********************************************
    def wyszukaj_element(self,szukana_wartosc):
        print(f"Wyszukuje wartosc {szukana_wartosc}")
        if szukana_wartosc in self.__tablica: return self.__tablica.index(szukana_wartosc)
        else: return -1

#**********************************************
# nazwa metody: wartosci_nieparzyste
# opis metody: Wyswietla wszystkie wartosci nieparzyste oraz pisze ile ich jest
# parametry: brak
# zwracany typ i opis: brak
# autor: 00000000
# ***********************************************
    def wartosci_nieparzyste(self):
        print("Wyszukuje ilosc wartosci nieparzystych w tablicy i podaje je")
        ilosc_nieparzystych = 0
        for item in self.__tablica:
            if item%2!=0: 
                ilosc_nieparzystych+=1
                print(item)
        print(f"ilosc liczb nieparzystych: {ilosc_nieparzystych}")

#**********************************************
# nazwa metody: wylicz_srednia
# opis metody: wylicza srednia arytmetyczna wszystkich liczb w tablicy
# parametry: brak
# zwracany typ i opis: zwracany typ: Int, opis: zwraca srednia arytmetyczna wszystkich liczb w tablicy
# autor: 00000000
# ***********************************************
    def wylicz_srednia(self):
        print("Wyliczam średnia arytmetyczna liczb w tablicy")
        suma = 0
        for item in self.__tablica:
            suma+=item
        return suma/len(self.__tablica)



tablica = ObiektTablica(21)
tablica.wyswietl_elementy()
if tablica.wyszukaj_element(10) != -1:
    print(f"Znaleziono wartość 10 na indeksie {tablica.wyszukaj_element(10)}")
else:
    print("Nie znaleziono szukanej wartości w tablicy")

tablica.wartosci_nieparzyste()
print(f"Srednia arytmetyczna liczbw tablicy: {tablica.wylicz_srednia()}")