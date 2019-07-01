# starwars

## Resource:
Star Wars api https://swapi.co/

## Objective:
* Create a command-line application that takes a planet name from the Star Wars universe and returns a list of people that are from that planet.
* `StarwarDemo` is just for command-line demo purpose.
* Trying to use actor and Akka Http REST API to achieve non-blocking, reactive, event-driven.

## Hot To Run:
1) `sbt clean compile` project
2) after above command completes, do `sbt run`
3) in Web Browser, paste in the following URL - `http://localhost:8080/starwars?planetName=Tatooine`
4) after pasting above URL, you should see the following output:
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

## TODOs:
* with latest commit, only working for single-word planet name
* may need some URL parameter encode/decode for multi-words name

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.