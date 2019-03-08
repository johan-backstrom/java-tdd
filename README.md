# Välkomna till Testforum med tema TDD

## Förberedelser

- En IDE som Intellij, NetBeans eller Eclipse
- Klona detta repo och öppna det i vald IDE

#Agenda

## Introduktion till testautomation

### Metodik

- Precondition (given)
- Execution (when)
- Assertion (then)

### Nivåer

- Unit-testning
- Kontraktstester
- Integrations och systemtest

### Viktiga egenskaper för tester

Tester ska alltid vara oberoende av varandra och ska kunna
exekveras "själva" och i vilken ordning som helst.

Testpyramiden ger en fingervisning om hur man ska jobba med de
olika testnivåerna.

Tester ska helst förlita sig på de gränssnitt som de testar och
inte behöva ge sig ner i implementationsdetaljer vilket försvårar
refaktorisering.

### Maven

- Dependency management tool
- Build tool

### JUnit

- @Test
- @Before
- @After
- @BeforeClass
- @AfterClass
- Assert

## Unit-testning

Unit-tester anropar enskilda metoder och validerar implementationen
av logik. Väl skrivna unit-tester kan till och med anses vara en
dokumentation eller specifikation för hur koden ska fungera.

Unit-tester ska vara snabba! Testsviter som tar mer än 1 min 
kommer inte köras så ofta som de borde.

Unit-tester ska kunna checkas ut av vem som helst och köras utan
att kräva någon setup i form av installationer, skapande av data,
filer eller annat. Unit-testerna får alltså inte vara beroende av
någonting utanför själva koden.

Unit-tester ska testa så lite som möjligt, helst bara en metod/klass.

Se: https://stackoverflow.com/questions/333682/unit-testing-anti-patterns-catalogue

### Lab 1

Skriv unit-tester för de tre metoderna i klassen StringUtility.

- camelCase tar en mening och gör om den till camel case: "Hej jag heter Johan" blir "HejJagHeterJohan"
- reverse väder på ett ord "Johan" blir "nahoJ"
- isValidEmailAddress validerar en e-post-adress

## TDD: Test Driven Development

TDD är ett sätt att arbeta med att skriva kod där själva utveckling är
hårt knuten till unit-tester. TDD brukar kallas för en "Test-first"-metod.

TDD anses skapa mjukvara som är lättare att underhålla eftersom det ställer
krav på designen i form av bättre inkapsling, gränssnitt och testbarhet.

Utveckling av en nya funktioner sker genom följande steg:

1. Skriv ett test som testar den nya funktionen
2. Kör testet. Om funktionen inte är implementerad ska testet vara rött.
3. Implementera funktionaliteten
4. Kör testet. Det ska vara grönt.
5. Refaktorisera koden
6. Upprepa

https://upload.wikimedia.org/wikipedia/commons/0/0b/TDD_Global_Lifecycle.png

### Demo

Bygga en kalkulator med TDD.

### Lab 2

Implementera metoden getVehicleValue i Vehicle-klassen med hjälp av TDD. 
Den ska uppfylla följande krav:

- Bilen är värd 90% av sitt nypris
- För varje år blir den värd 20% mindre
- Beroende på skick blir den eventuellt mindre värd
  - Mint: Ingen förändring
  - Used: - 10000 kr
  - Crap: - 20000 kr
- Beroende på märke kan den vara mer värd:
  - Ferrari: + 20000 kr
  - Lamborghini + 10000 kr
- Värdet kan aldrig vara mindre än 0

### Lab 3

Skapa en metod som tar två integers som argument och 
returnerar en lista med alla primtal mellan dessa två tal.

Krav:

- Primtal är endast delbara med sig själv och 1
- Primtal är heltal
- Primtal är större än 1

Refaktorisera lösningen så att metoden blir rekursiv. Har du 
skrivit bra tester i steg ett kommer de skydda dig när det blir svårt.

## Unit testing av komplex funktionalitet och beroenden

Introduktion:

- Mockning
- Dependency injection-ish
- In memory DB (t.ex. H2)

### Lab 4

Skapa funktionalitet som läser en fil innehållande fordon
från resources-foldern, räknar ut försäkringspremien enligt 
följande regler och sedan skriver resultatet till en SQL-databas.

Filen är på följande format:

    <regnr>;<märke>;<modell>;<tillverkningsår>;<nypris>;<condition>

En testfil finns i src/test/resources/cars.txt.

Databasschemat är följande:

    CREATE TABLE InsurancePremium(licensePlate char(6), insurancePremium int);

Filen ska behandlas enligt enligt följande krav:

- Premien är 1% av nypriset
- Premien minskar med 20% för varje år efter tillverkningsåret
- Premien för märke "Mercedes" är 500 högre än annars
- Premien är aldrig mindre än 3000

Tips:

- Det finns en färdig DB-klient i klassen DatabaseClient
- Det finns en färdig setup med en in memory-db i klassen DatabaseClientTest
- Det finns en färdig metod för att läsa filer i klassen FileReadingUtility
    
## Kontraktstestning

- Del av komponenten man testar (t.ex JUnit)
- verktyg som till exempel "Pact": https://docs.pact.io/

## Integrations och systemtestning

Testar hela eller delar av systemet genom de gränssnitt som exponeras
ut från systemet.

### HTTP och REST

- Introduktion till HTTP
- Introduktion till REST
- Postman + Swagger petstore

### Demo

- Skapa och hämta ett pet från swagger petstore med postman.
- Skapa och hämta ett pet från java-kod (vi använder unitest i detta exempel).
- Hämta data som strängar och/eller objekt

### Lab 5

- Skriv test som gör en delete i petstore.
- Skriv test som uppdaterar ett befintligt pet.

Hint: Tänk på de övergripande test-stegen! given-when-then

### Testabstraktioner

Introduktion till abstraktioner för testning.

- SUT
- Testdata

### Demo

Skriv om det första testet i petstore med en abstraktion för SUT.
Skriv om "testdatat" tillatt vara en abstraktion.

### Lab 6

Skriv om alla petstore-tester till att använda abstraktioner för
testdata och SUT.