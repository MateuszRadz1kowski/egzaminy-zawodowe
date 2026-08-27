from tablica_z_wartownikiem import szukaj_w_tablicy


def test_szukaj_w_tablicy():
    testowa_tablica = [10, 20, 30, 40, 50]

    assert szukaj_w_tablicy(testowa_tablica, 30) == 2
    assert szukaj_w_tablicy(testowa_tablica, 99) == 5

    print("Wszystkie testy zakończone sukcesem")

if __name__ == "__main__":
    test_szukaj_w_tablicy()