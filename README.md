## Lab 1

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

## Lab 2

Skapa en metod som tar två integers som argument och 
returnerar en lista med alla primtal mellan dessa två tal.

Krav:

- Primtal är endast delbara med sig själv och 1
- Primtal är heltal
- Primtal är större än 1

Refaktorisera lösningen så att metoden blir rekursiv. Har du 
skrivit bra tester i steg ett kommer de skydda dig när det blir svårt.