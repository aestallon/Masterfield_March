# Programozás alapjai - beadandó feladatok

### Beadási határidő: 2022. március 27.

## 1. feladat

> - Írjuk le az alábbi utazási biztosítással kapcsolatos relációkat helyes
    > szintaktikával!
> - Igaz, (1) ha egyedül utazik és üzleti úton vesz részt és európai országba
    > utazik, akkor is igaz, (2) ha sportolási céllal utazik, legalább 18 éves
    > és még nem volt balesete
> - Igaz, (1) ha egyedül utazik és külföldi tanulmányúton vesz részt, akkor is
    > igaz, (2) ha családdal utazik (2 felnőtt és legalább 2 gyerek) és
    > tengerpari nyaraláson vesz részt és még nem volt balesete, és akkor is
    > igaz, (3) ha városnézésen vesz részt és európai országba utazik, vagy
    > nem európai országba utazik, de még nem volt balesete.
> - Változó nevek tetszőlegesen választhatók.

A feladat megoldása a `problem01` csomag `InsuranceRequirements` osztályában található. A csomag tartalmaz más
osztályokat is, melyek a megoldás teszteléséhez használhatók:

* A `Passenger` osztály tartalmazza a relációanalízéshez kellő változókat.
* A `TravelFor` enum deklaráció tartalmaz összetartozó elemeket, melyeket helytelen lenne szövegesen megadni.
* A `Test` osztály egy futtatható tesztprogramot tartalmaz. Ez tetszőlegesen módosítható, a kívánt tesztektől függően.

## 2. feladat

> - Döntsük el, hogy egy adott szó (String) tartalmaz-e ’a’ betűt (igaz/hamis)!
    > A szó csak betűket tartalmazhat! Az órán látott módon, tömbben történő
    > kereséssel oldjuk meg. Ne használjuk a String keresési metódusait!
> - Segítség: egy String-et a toCharArray() metódussal bonthatunk karakterek
    > tömbjére.
> - Bővítsük úgy a megoldást, hogy kiírja az első ’a’-t tartalmazó elem
    > pozícióját (nem biztos, hogy van ilyen elem)!

A feladat megoldása a `problem02` csomagban található. Mivel ez és a következő 2 feladat mind String típusú változókban
való karakterkereséssel foglalkozik, ez a csomag tartalmaz egy `CharFinder` osztályt: itt String-ekben történő
karakterkereséssel foglalkozó statikus metódusokat találhatunk.

A feladat megoldásának egy lehetséges implementációját mutatja be a
`Problem02Test` osztály.

## 3. feladat

> - Számoljuk meg, hogy hány ’b’ eleme van egy csak betűket tartalmazó
    > String-nek!
> - Bővítsük úgy a megoldást, hogy kiírja az összes ’b’-t tartalmazó elem
    > pozícióját!

A feladat megoldásának egy lehetséges implementációját mutatja be a
`problem03` csomagban található `Problem03Test` osztály. Az implementációhoz szükséges segédmetódusokat a `CharFinder`
osztályból statikusan importáltam.

## 4. feladat

> - Egy szavakat tartalmazó szövegben (String) előfordulhat több szóköz (space)
    > egymás után.
> - Szűrjük ki az ismétlődő szóközöket! Az eredményt egy karakter tömbben
    > adjuk meg (char[]).

A feladat megoldásának egy lehetséges implementációját mutatja be a
`problem04` csomagban található `Problem04Test` osztály. Az implementációhoz szükséges segédmetódusokat a `CharFinder`
osztályból statikusan importáltam.

## 5. feladat

> - Készítsünk dobókocka programot. A program indulásakor a felhasználó
    > megadhatja, hogy 1,2 vagy 3 dobókockával szeretne játszani. Adjuk össze
    > és írjuk ki a dobott értékek eredményeit!
> - Módosítsuk a programot, hogy 5 dobás legyen egymás után. Minden körben
    > először a számítógép dob magának, majd dob nekünk is. Adjuk össze a
    > dobott értékeket és az 5. dobás után írjuk ki, hogy ki nyert, azaz
    > kinek van több pontja.
> - Módosítsuk a programot, hogy 3 kocka esetén a csupa 6-os dobás azonnali
    > győzelmet jelentsen!

A feladat megoldását a `problem05` csomag `DiceGame` osztálya tartalmazza.

## 6. feladat

> Készítsünk tippelős játékot. A program kérjen be egy tippet (1-6) a játékostól
> és addig dobjon a kockával, amíg a dobott érték meg nem egyezik a tippelt számmal.
> Egyezés esetén írjuk ki, hogy talált és írjuk ki a dobások számát. Ekkor kilépünk
> a programból.

A feladat megoldását a `problem06` csomag `GuessingGame` osztálya tartalmazza.