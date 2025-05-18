Testdriven Applikation med CI

Detta är en enkel webbaserad e-handel applikation byggd med **Spring Boot**, **JPA**, och **REST** som hanterar produkter, kundvagnar och ordrar. Projektet är utvecklat med **testdriven utveckling (TDD)** och har integrerats med **GitHub Actions** för kontinuerlig integration (CI).

Applikationen består av:

- **Produkt (`Product`)** – innehåller namn och information om produkten.
- **Kundvagn (`Cart`)** – innehåller en lista av produkter.
- **Order (`Order`)** – innehåller en lista av produkter och orderdatum.

Alla resurser hanteras via REST-endpoints och testas med både enhetstester och integrationstester.

Instruktioner för att köra projektet och testerna

1. Klona projektet genom github
2. Starta applikationen
3. API-endpoints kommer då vara tillgängliga på postman på http://localhost:8080/, till exempel:
POST /products
GET /products
POST /carts

Tester kan köras genom att gå in i filen för testen och klicka på den gröna iconen bredvid @Test
