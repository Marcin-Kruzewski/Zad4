# Zad4

movies api:

post ```/movies```:
  - parameter ```title``` as ```string```
    - adds new ```movie``` with ```movie.title=title```
    - returns ```movies``` json

get ```/movies```:
  - no parameters:
    - returns ```movies``` json
  - parameter ```id``` as ```int```:
    - returns ```movie``` json
  - parameter ```id``` as ```int``` and (```comment``` as ```string``` and/or ```stars``` as ```int```):
    - adds ```comment``` and/or ```stars``` to ```movie``` by ```id```
    - returns ```movie``` json
  
