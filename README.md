# starwars

## Resource:
Star Wars api (https://swapi.co/)

## Objective:
* Create a command-line application that takes a planet name from the Star Wars universe and returns a list of people that are from that planet.
* `StarwarDemo` is just for command-line / Web Browser demo purpose.
* Trying to use actor and Akka Http REST API to achieve non-blocking, reactive, event-driven.

## How To Run (requires SBT):
1) in Mac Terminal or Windows Command Prompt, type `sbt clean compile`

2) after above-sbt-commands completes, then type `sbt run`

3) in Web Browser, paste in the following URL - `http://localhost:8080/starwars?planetName=Tatooine`

4a) after pasting above URL, you should see the following output:
```
Luke Skywalker
C-3PO
Darth Vader
Owen Lars
Beru Whitesun lars
R5-D4
Biggs Darklighter
Anakin Skywalker
Shmi Skywalker
Cliegg Lars
```
4b) in Web Browser, another example URL is - `http://localhost:8080/starwars?planetName=Alderaan`

4c) after pasting second-example-URL, you should see the following output:
```
Leia Organa
Bail Prestor Organa
Raymus Antilles
```

## TODOs:
* with latest commit, only working for **single-word planet name** (*see above examples*)
* may need some URL parameter encode/decode for multi-words name (*specifically peopleName*)

## Contributing / MRs
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.