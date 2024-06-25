Koristim Microsoft SQL Server za bazu
SQL Server image za docker:  mcr.microsoft.com/azure-sql-edge
Redis image za docker(koji trenutno ne radi): redis:alpine3.20
1. potrebno je napraviti praznu tablicu (Ja koristim Azure Data Studio jer sam na macu)
2. hibernate.fcg.xml sadrzi propertije za url "jdbc:sqlserver://localhost:1433;databaseName=IME_TABLICE;encrypt=true;trustServerCertificate=true" i propertije za username i password
3. application.properties sadrzi identicne propertije koje također treba napisati
4. tablica se puni pokretanjem file-a "FillDatabase"
5. nakon toga "ZadatakApplication" pokrece server koji komunicira sa bazom i filtrira podatke
6. username i password za spring security je "admin" i "adminPass"
