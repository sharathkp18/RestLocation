This Spring Boot application retrieves the latitude and longitude of a restaurant by calling an external OpenStreetMap (OSM) Nominatim API.
The user provides the restaurant name and city as a single string, and the application fetches the location coordinates.

API endpoint : GET /restaurant/location
ex input : pizza hut bangalore ( Restaurant name and city )
request : http://localhost:8080/restaurant/location?name=pizza hut bangalore
ex response : {
    "restaurant": "pizza hut bangalore",
    "latitude": 12.9955319,
    "longitude": 77.5546673
}

The service then calls the external API and returns the latitude and longitude of the restaurant.

