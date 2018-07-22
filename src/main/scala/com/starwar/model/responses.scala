package com.starwar.model


sealed trait Response[T] {
  def count: Int
  def next: Option[URL]
  def previous: Option[URL]
  def results: Array[T]
}
case class PeopleResponse(count: Int, next: Option[URL], previous: Option[URL], results: Array[Person]) extends Response[Person]
case class PlanetsResponse(count: Int, next: Option[URL], previous: Option[URL], results: Array[Planet]) extends Response[Planet]

// PlanetsResponse
/*
{
	"count": 61,
	"next": "https://swapi.co/api/planets/?page=2",
	"previous": null,
	"results": [
		{
			"name": "Alderaan",
			"rotation_period": "24",
			"orbital_period": "364",
			"diameter": "12500",
			"climate": "temperate",
			"gravity": "1 standard",
			"terrain": "grasslands, mountains",
			"surface_water": "40",
			"population": "2000000000",
			"residents": [
				"https://swapi.co/api/people/5/",
				"https://swapi.co/api/people/68/",
				"https://swapi.co/api/people/81/"
			],
			"films": [
				"https://swapi.co/api/films/6/",
				"https://swapi.co/api/films/1/"
			],
			"created": "2014-12-10T11:35:48.479000Z",
			"edited": "2014-12-20T20:58:18.420000Z",
			"url": "https://swapi.co/api/planets/2/"
		},
		{
			"name": "Yavin IV",
			"rotation_period": "24",
			"orbital_period": "4818",
			"diameter": "10200",
			"climate": "temperate, tropical",
			"gravity": "1 standard",
			"terrain": "jungle, rainforests",
			"surface_water": "8",
			"population": "1000",
			"residents": [],
			"films": [
				"https://swapi.co/api/films/1/"
			],
			"created": "2014-12-10T11:37:19.144000Z",
			"edited": "2014-12-20T20:58:18.421000Z",
			"url": "https://swapi.co/api/planets/3/"
		},
		{
			"name": "Hoth",
			"rotation_period": "23",
			"orbital_period": "549",
			"diameter": "7200",
			"climate": "frozen",
			"gravity": "1.1 standard",
			"terrain": "tundra, ice caves, mountain ranges",
			"surface_water": "100",
			"population": "unknown",
			"residents": [],
			"films": [
				"https://swapi.co/api/films/2/"
			],
			"created": "2014-12-10T11:39:13.934000Z",
			"edited": "2014-12-20T20:58:18.423000Z",
			"url": "https://swapi.co/api/planets/4/"
		},
		{
			"name": "Dagobah",
			"rotation_period": "23",
			"orbital_period": "341",
			"diameter": "8900",
			"climate": "murky",
			"gravity": "N/A",
			"terrain": "swamp, jungles",
			"surface_water": "8",
			"population": "unknown",
			"residents": [],
			"films": [
				"https://swapi.co/api/films/2/",
				"https://swapi.co/api/films/6/",
				"https://swapi.co/api/films/3/"
			],
			"created": "2014-12-10T11:42:22.590000Z",
			"edited": "2014-12-20T20:58:18.425000Z",
			"url": "https://swapi.co/api/planets/5/"
		},
		{
			"name": "Bespin",
			"rotation_period": "12",
			"orbital_period": "5110",
			"diameter": "118000",
			"climate": "temperate",
			"gravity": "1.5 (surface), 1 standard (Cloud City)",
			"terrain": "gas giant",
			"surface_water": "0",
			"population": "6000000",
			"residents": [
				"https://swapi.co/api/people/26/"
			],
			"films": [
				"https://swapi.co/api/films/2/"
			],
			"created": "2014-12-10T11:43:55.240000Z",
			"edited": "2014-12-20T20:58:18.427000Z",
			"url": "https://swapi.co/api/planets/6/"
		},
		{
			"name": "Endor",
			"rotation_period": "18",
			"orbital_period": "402",
			"diameter": "4900",
			"climate": "temperate",
			"gravity": "0.85 standard",
			"terrain": "forests, mountains, lakes",
			"surface_water": "8",
			"population": "30000000",
			"residents": [
				"https://swapi.co/api/people/30/"
			],
			"films": [
				"https://swapi.co/api/films/3/"
			],
			"created": "2014-12-10T11:50:29.349000Z",
			"edited": "2014-12-20T20:58:18.429000Z",
			"url": "https://swapi.co/api/planets/7/"
		},
		{
			"name": "Naboo",
			"rotation_period": "26",
			"orbital_period": "312",
			"diameter": "12120",
			"climate": "temperate",
			"gravity": "1 standard",
			"terrain": "grassy hills, swamps, forests, mountains",
			"surface_water": "12",
			"population": "4500000000",
			"residents": [
				"https://swapi.co/api/people/3/",
				"https://swapi.co/api/people/21/",
				"https://swapi.co/api/people/36/",
				"https://swapi.co/api/people/37/",
				"https://swapi.co/api/people/38/",
				"https://swapi.co/api/people/39/",
				"https://swapi.co/api/people/42/",
				"https://swapi.co/api/people/60/",
				"https://swapi.co/api/people/61/",
				"https://swapi.co/api/people/66/",
				"https://swapi.co/api/people/35/"
			],
			"films": [
				"https://swapi.co/api/films/5/",
				"https://swapi.co/api/films/4/",
				"https://swapi.co/api/films/6/",
				"https://swapi.co/api/films/3/"
			],
			"created": "2014-12-10T11:52:31.066000Z",
			"edited": "2014-12-20T20:58:18.430000Z",
			"url": "https://swapi.co/api/planets/8/"
		},
		{
			"name": "Coruscant",
			"rotation_period": "24",
			"orbital_period": "368",
			"diameter": "12240",
			"climate": "temperate",
			"gravity": "1 standard",
			"terrain": "cityscape, mountains",
			"surface_water": "unknown",
			"population": "1000000000000",
			"residents": [
				"https://swapi.co/api/people/34/",
				"https://swapi.co/api/people/55/",
				"https://swapi.co/api/people/74/"
			],
			"films": [
				"https://swapi.co/api/films/5/",
				"https://swapi.co/api/films/4/",
				"https://swapi.co/api/films/6/",
				"https://swapi.co/api/films/3/"
			],
			"created": "2014-12-10T11:54:13.921000Z",
			"edited": "2014-12-20T20:58:18.432000Z",
			"url": "https://swapi.co/api/planets/9/"
		},
		{
			"name": "Kamino",
			"rotation_period": "27",
			"orbital_period": "463",
			"diameter": "19720",
			"climate": "temperate",
			"gravity": "1 standard",
			"terrain": "ocean",
			"surface_water": "100",
			"population": "1000000000",
			"residents": [
				"https://swapi.co/api/people/22/",
				"https://swapi.co/api/people/72/",
				"https://swapi.co/api/people/73/"
			],
			"films": [
				"https://swapi.co/api/films/5/"
			],
			"created": "2014-12-10T12:45:06.577000Z",
			"edited": "2014-12-20T20:58:18.434000Z",
			"url": "https://swapi.co/api/planets/10/"
		},
		{
			"name": "Geonosis",
			"rotation_period": "30",
			"orbital_period": "256",
			"diameter": "11370",
			"climate": "temperate, arid",
			"gravity": "0.9 standard",
			"terrain": "rock, desert, mountain, barren",
			"surface_water": "5",
			"population": "100000000000",
			"residents": [
				"https://swapi.co/api/people/63/"
			],
			"films": [
				"https://swapi.co/api/films/5/"
			],
			"created": "2014-12-10T12:47:22.350000Z",
			"edited": "2014-12-20T20:58:18.437000Z",
			"url": "https://swapi.co/api/planets/11/"
		}
	]
}
 */

// PeopleResponse
/*
{
    "count": 87,
    "next": "https://swapi.co/api/people/?page=3",
    "previous": "https://swapi.co/api/people/?page=1",
    "results": [
        {
            "name": "Anakin Skywalker",
            "height": "188",
            "mass": "84",
            "hair_color": "blond",
            "skin_color": "fair",
            "eye_color": "blue",
            "birth_year": "41.9BBY",
            "gender": "male",
            "homeworld": "https://swapi.co/api/planets/1/",
            "films": [
                "https://swapi.co/api/films/5/",
                "https://swapi.co/api/films/4/",
                "https://swapi.co/api/films/6/"
            ],
            "species": [
                "https://swapi.co/api/species/1/"
            ],
            "vehicles": [
                "https://swapi.co/api/vehicles/44/",
                "https://swapi.co/api/vehicles/46/"
            ],
            "starships": [
                "https://swapi.co/api/starships/59/",
                "https://swapi.co/api/starships/65/",
                "https://swapi.co/api/starships/39/"
            ],
            "created": "2014-12-10T16:20:44.310000Z",
            "edited": "2014-12-20T21:17:50.327000Z",
            "url": "https://swapi.co/api/people/11/"
        },
        {
            "name": "Wilhuff Tarkin",
            "height": "180",
            "mass": "unknown",
            "hair_color": "auburn, grey",
            "skin_color": "fair",
            "eye_color": "blue",
            "birth_year": "64BBY",
            "gender": "male",
            "homeworld": "https://swapi.co/api/planets/21/",
            "films": [
                "https://swapi.co/api/films/6/",
                "https://swapi.co/api/films/1/"
            ],
            "species": [
                "https://swapi.co/api/species/1/"
            ],
            "vehicles": [],
            "starships": [],
            "created": "2014-12-10T16:26:56.138000Z",
            "edited": "2014-12-20T21:17:50.330000Z",
            "url": "https://swapi.co/api/people/12/"
        },
        {
            "name": "Chewbacca",
            "height": "228",
            "mass": "112",
            "hair_color": "brown",
            "skin_color": "unknown",
            "eye_color": "blue",
            "birth_year": "200BBY",
            "gender": "male",
            "homeworld": "https://swapi.co/api/planets/14/",
            "films": [
                "https://swapi.co/api/films/2/",
                "https://swapi.co/api/films/6/",
                "https://swapi.co/api/films/3/",
                "https://swapi.co/api/films/1/",
                "https://swapi.co/api/films/7/"
            ],
            "species": [
                "https://swapi.co/api/species/3/"
            ],
            "vehicles": [
                "https://swapi.co/api/vehicles/19/"
            ],
            "starships": [
                "https://swapi.co/api/starships/10/",
                "https://swapi.co/api/starships/22/"
            ],
            "created": "2014-12-10T16:42:45.066000Z",
            "edited": "2014-12-20T21:17:50.332000Z",
            "url": "https://swapi.co/api/people/13/"
        },
        {
            "name": "Han Solo",
            "height": "180",
            "mass": "80",
            "hair_color": "brown",
            "skin_color": "fair",
            "eye_color": "brown",
            "birth_year": "29BBY",
            "gender": "male",
            "homeworld": "https://swapi.co/api/planets/22/",
            "films": [
                "https://swapi.co/api/films/2/",
                "https://swapi.co/api/films/3/",
                "https://swapi.co/api/films/1/",
                "https://swapi.co/api/films/7/"
            ],
            "species": [
                "https://swapi.co/api/species/1/"
            ],
            "vehicles": [],
            "starships": [
                "https://swapi.co/api/starships/10/",
                "https://swapi.co/api/starships/22/"
            ],
            "created": "2014-12-10T16:49:14.582000Z",
            "edited": "2014-12-20T21:17:50.334000Z",
            "url": "https://swapi.co/api/people/14/"
        },
        {
            "name": "Greedo",
            "height": "173",
            "mass": "74",
            "hair_color": "n/a",
            "skin_color": "green",
            "eye_color": "black",
            "birth_year": "44BBY",
            "gender": "male",
            "homeworld": "https://swapi.co/api/planets/23/",
            "films": [
                "https://swapi.co/api/films/1/"
            ],
            "species": [
                "https://swapi.co/api/species/4/"
            ],
            "vehicles": [],
            "starships": [],
            "created": "2014-12-10T17:03:30.334000Z",
            "edited": "2014-12-20T21:17:50.336000Z",
            "url": "https://swapi.co/api/people/15/"
        },
        {
            "name": "Jabba Desilijic Tiure",
            "height": "175",
            "mass": "1,358",
            "hair_color": "n/a",
            "skin_color": "green-tan, brown",
            "eye_color": "orange",
            "birth_year": "600BBY",
            "gender": "hermaphrodite",
            "homeworld": "https://swapi.co/api/planets/24/",
            "films": [
                "https://swapi.co/api/films/4/",
                "https://swapi.co/api/films/3/",
                "https://swapi.co/api/films/1/"
            ],
            "species": [
                "https://swapi.co/api/species/5/"
            ],
            "vehicles": [],
            "starships": [],
            "created": "2014-12-10T17:11:31.638000Z",
            "edited": "2014-12-20T21:17:50.338000Z",
            "url": "https://swapi.co/api/people/16/"
        },
        {
            "name": "Wedge Antilles",
            "height": "170",
            "mass": "77",
            "hair_color": "brown",
            "skin_color": "fair",
            "eye_color": "hazel",
            "birth_year": "21BBY",
            "gender": "male",
            "homeworld": "https://swapi.co/api/planets/22/",
            "films": [
                "https://swapi.co/api/films/2/",
                "https://swapi.co/api/films/3/",
                "https://swapi.co/api/films/1/"
            ],
            "species": [
                "https://swapi.co/api/species/1/"
            ],
            "vehicles": [
                "https://swapi.co/api/vehicles/14/"
            ],
            "starships": [
                "https://swapi.co/api/starships/12/"
            ],
            "created": "2014-12-12T11:08:06.469000Z",
            "edited": "2014-12-20T21:17:50.341000Z",
            "url": "https://swapi.co/api/people/18/"
        },
        {
            "name": "Jek Tono Porkins",
            "height": "180",
            "mass": "110",
            "hair_color": "brown",
            "skin_color": "fair",
            "eye_color": "blue",
            "birth_year": "unknown",
            "gender": "male",
            "homeworld": "https://swapi.co/api/planets/26/",
            "films": [
                "https://swapi.co/api/films/1/"
            ],
            "species": [
                "https://swapi.co/api/species/1/"
            ],
            "vehicles": [],
            "starships": [
                "https://swapi.co/api/starships/12/"
            ],
            "created": "2014-12-12T11:16:56.569000Z",
            "edited": "2014-12-20T21:17:50.343000Z",
            "url": "https://swapi.co/api/people/19/"
        },
        {
            "name": "Yoda",
            "height": "66",
            "mass": "17",
            "hair_color": "white",
            "skin_color": "green",
            "eye_color": "brown",
            "birth_year": "896BBY",
            "gender": "male",
            "homeworld": "https://swapi.co/api/planets/28/",
            "films": [
                "https://swapi.co/api/films/2/",
                "https://swapi.co/api/films/5/",
                "https://swapi.co/api/films/4/",
                "https://swapi.co/api/films/6/",
                "https://swapi.co/api/films/3/"
            ],
            "species": [
                "https://swapi.co/api/species/6/"
            ],
            "vehicles": [],
            "starships": [],
            "created": "2014-12-15T12:26:01.042000Z",
            "edited": "2014-12-20T21:17:50.345000Z",
            "url": "https://swapi.co/api/people/20/"
        },
        {
            "name": "Palpatine",
            "height": "170",
            "mass": "75",
            "hair_color": "grey",
            "skin_color": "pale",
            "eye_color": "yellow",
            "birth_year": "82BBY",
            "gender": "male",
            "homeworld": "https://swapi.co/api/planets/8/",
            "films": [
                "https://swapi.co/api/films/2/",
                "https://swapi.co/api/films/5/",
                "https://swapi.co/api/films/4/",
                "https://swapi.co/api/films/6/",
                "https://swapi.co/api/films/3/"
            ],
            "species": [
                "https://swapi.co/api/species/1/"
            ],
            "vehicles": [],
            "starships": [],
            "created": "2014-12-15T12:48:05.971000Z",
            "edited": "2014-12-20T21:17:50.347000Z",
            "url": "https://swapi.co/api/people/21/"
        }
    ]
}
*/