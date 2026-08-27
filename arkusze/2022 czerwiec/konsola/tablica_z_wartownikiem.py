from random import randint



def wypelnij_tablice(tablica,tablica_dlugosc):
    for i in range(0,tablica_dlugosc):
        tablica.append(randint(1,100))

def szukaj_w_tablicy(tablica,wartosc_szukana):
    tablica.append(wartosc_szukana)
    for i in range(len(tablica)):
        if(tablica[i]==wartosc_szukana):
            tablica.pop()
            return i

if __name__ == '__main__':
    tablica = []
    wartosc_szukana = int(input("Wpisz jaką wartosc int szukasz w tablicy: "))
    tablica_dlugosc = 50
    wypelnij_tablice(tablica, tablica_dlugosc)
    index_wartosci = szukaj_w_tablicy(tablica, wartosc_szukana)
    print(*tablica, sep=", ")
    if tablica_dlugosc == index_wartosci :
        print("Szukanej wartośći nie znaleziono w tablicy")
    else:
        print(f"Znaleziono szukaną wartość {wartosc_szukana} pod indeksem {index_wartosci}")
