# Zadání:

- Vvytvořte konzolovou aplikaci, která bude obsahovat vlastní in-memory databázi osob
- Osoba je definována jménem, příjmením a rodným číslem. Rodné číslo je pro každou osobu unikátní.
- Program by neměl využívat žádné externí knihovny ani databáze.

## Vstupy a výstupy:
Uživatel dostane na výběr ze tří možností:
- přidat osobu
- odebart osobu
- vyhledat osobu podle rodného čísla.

Po skončení každé akce bude uživatel dotázán, jestli chce program ukončit, nebo pokračovat.

**Přidání osoby:**
- uživatel bude požádán o vyplnění údajů dané osoby
- každý z údajů by měl být validován
    - jméno a příjmení nesmí být prázdné
    - rodné číslo musí být ve formátu YYMMDDXXXX nebo YYMMDD/XXXX
- pokud již daná osoba v databázi je, měl by program vyhodit výjimku

**Odebrání osoby:**
- uživatel bude vyzván k identifikaci osoby, kterou chce smazat
- pokkud daná osoba v databázi není, měl by program vyhodit výjimku

**Vyhledání osoby podle rodného čísla:**
- uživatel bude vyzván k vyplnění rodného čísla
- pokud osoba existuje, budou zobrazeny její údaje
- *u vyhledané osoby bude dopočítán věk podle rodného čísla*
- pokud osoba neexistuje, bude vyhozena výjimka
