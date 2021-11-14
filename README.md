## Intro


The purpose of this technical task was to provide a set of data to an endpoint  which would in return process this data and provide the following functionality:
* return it as a JSON
* sorting
* filtering
* grouping of residents with the same address
* completion and 'normalisation' of data fields

## Progress

Time spent ≈6 hours

✔️Returns JSON

✔️Has sorting

✔️ Has Filtering

✔️Groups Residents at the same Address

❌️Addresses are not 'normalised' - would be achieved with an Address API provider or something?!


## Info

<details>
  <summary>Request Body</summary>

* Takes the request body of type JSON with the following parameters : `"firstname","surname","address1","address2","city","state","postcode","countrycode","gender","dateofbirth"` all of which are of type `string`
</details>
<details>
  <summary>Response Example</summary>

```
[
    {
        "address1": "2 Short Street",
        "address2": "",
        "city": "Southend",
        "state": "Essex",
        "postcode": "SS0 8BB",
        "countryCode": "UK",
        "residents": [
            {
                "firstName": "Bob",
                "surname": "Long",
                "gender": "M",
                "dateOfBirth": "1971-02-02"
            }
        ]
    }
]
```
</details>

<details>
  <summary>Sorting</summary>

* Sorting is achieved by query parameter `sortType` it takes an all lowercase argument of type `String`, currently it accepts only `city` and `postcode` as arguments.

</details>

<details>
  <summary>Filtering</summary>

* Filtering is achieved by multiple query parameters
1. `filterType` - similar to `sortType` it determines which property to filter on.  it takes an all lowercase argument of type `String`, currently it accepts only `city` and `postcode` as arguments.

2. `filterComparator` - idea was to introduce comparison operators, e.g., `contains`,`gt`,`lt`,`eq`, etc.

3. `filterCriteria` - search criteria for the defined type. Currently is looking for an exact `match`.

</details>


## Example curl commands

<details>
  <summary>Sorting by postcode curl example</summary>

## Sorting by postcode curl example
```javascript
curl --location --request POST 'localhost:8080/data-processing/process-data?sortType=postcode' \
--header 'Content-Type: application/json' \
--data-raw '[
{
"firstname": "Fred",
"surname": "Smith",
"address1": "Customs House",
"address2": "1 Long Street",
"city": "Glasgow",
"state": "Glasgow",
"postcode": "G10 1AA",
"countrycode": "UK",
"gender": "M",
"dateofbirth": "1/1/1970"
},
{
"firstname": "Bob",
"surname": "Long",
"address1": "2 Short Street",
"address2": "",
"city": "Southend",
"state": "Essex",
"postcode": "SS0 8BB",
"countrycode": "UK",
"gender": "M",
"dateofbirth": "2/2/1971"
},
{
"firstname": "Nancy",
"surname": "Bayliss",
"address1": "3 Lombard Street",
"address2": "",
"city": "Brighton",
"state": "East Sussex",
"postcode": "B23 4CC",
"countrycode": "GB",
"gender": "F",
"dateofbirth": "3/3/1973"
},
{
"firstname": "Alan",
"surname": "Johnson",
"address1": "Tower House",
"address2": "4 Clements Lane",
"city": "London",
"state": "",
"postcode": "EC14AA",
"countrycode": "",
"gender": "M",
"dateofbirth": "4/4/1974"
},
{
"firstname": "Roger",
"surname": "May",
"address1": "5 Watling Ave",
"address2": "",
"city": "Manchester",
"state": "Manchester",
"postcode": "M10 5DD",
"countrycode": "UK",
"gender": "M",
"dateofbirth": "5/5/1975"
},
{
"firstname": "Mike",
"surname": "Ward",
"address1": "8 Wrong Rd",
"address2": "",
"city": "Leeds",
"state": "W Yorks",
"postcode": "L11 6AA",
"countrycode": "UK",
"gender": "M",
"dateofbirth": "6/6/1976"
},
{
"firstname": "Sarah",
"surname": "",
"address1": "1 Long Street",
"address2": "",
"city": "Glasgow",
"state": "Glasgow",
"postcode": "G10",
"countrycode": "UK",
"gender": "F",
"dateofbirth": "7/7/1977"
},
{
"firstname": "Linda",
"surname": "James",
"address1": "8 Wrong Road",
"address2": "",
"city": "Leeds",
"state": "West Yorkshire",
"postcode": "L12 7EE",
"countrycode": "GB",
"gender": "F",
"dateofbirth": "8/8/1978"
},
{
"firstname": "Helen",
"surname": "Mirren",
"address1": "6 The Bells",
"address2": "",
"city": "Liverpool",
"state": "Liverpool",
"postcode": "LP10GG",
"countrycode": "UK",
"gender": "F",
"dateofbirth": "9/9/1979"
},
{
"firstname": "Rebecca",
"surname": "May",
"address1": "4 Clements Ln",
"address2": "",
"city": "London",
"state": "London",
"postcode": "EC1 4AA",
"countrycode": "UK",
"gender": "F",
"dateofbirth": "10/10/1980"
}
]'
```
</details>
<details>
    <summary>Filtering curl example</summary>

##Filtering curl example
```javascript


`curl --location --request POST 'localhost:8080/data-processing/process-data?filterCriteria=Southend&filterType=city' \
--header 'Content-Type: application/json' \
--data-raw '[
{
"firstname": "Fred",
"surname": "Smith",
"address1": "Customs House",
"address2": "1 Long Street",
"city": "Glasgow",
"state": "Glasgow",
"postcode": "G10 1AA",
"countrycode": "UK",
"gender": "M",
"dateofbirth": "1/1/1970"
},
{
"firstname": "Bob",
"surname": "Long",
"address1": "2 Short Street",
"address2": "",
"city": "Southend",
"state": "Essex",
"postcode": "SS0 8BB",
"countrycode": "UK",
"gender": "M",
"dateofbirth": "2/2/1971"
},
{
"firstname": "Nancy",
"surname": "Bayliss",
"address1": "3 Lombard Street",
"address2": "",
"city": "Brighton",
"state": "East Sussex",
"postcode": "B23 4CC",
"countrycode": "GB",
"gender": "F",
"dateofbirth": "3/3/1973"
},
{
"firstname": "Alan",
"surname": "Johnson",
"address1": "Tower House",
"address2": "4 Clements Lane",
"city": "London",
"state": "",
"postcode": "EC14AA",
"countrycode": "",
"gender": "M",
"dateofbirth": "4/4/1974"
},
{
"firstname": "Roger",
"surname": "May",
"address1": "5 Watling Ave",
"address2": "",
"city": "Manchester",
"state": "Manchester",
"postcode": "M10 5DD",
"countrycode": "UK",
"gender": "M",
"dateofbirth": "5/5/1975"
},
{
"firstname": "Mike",
"surname": "Ward",
"address1": "8 Wrong Rd",
"address2": "",
"city": "Leeds",
"state": "W Yorks",
"postcode": "L11 6AA",
"countrycode": "UK",
"gender": "M",
"dateofbirth": "6/6/1976"
},
{
"firstname": "Sarah",
"surname": "",
"address1": "1 Long Street",
"address2": "",
"city": "Glasgow",
"state": "Glasgow",
"postcode": "G10",
"countrycode": "UK",
"gender": "F",
"dateofbirth": "7/7/1977"
},
{
"firstname": "Linda",
"surname": "James",
"address1": "8 Wrong Road",
"address2": "",
"city": "Leeds",
"state": "West Yorkshire",
"postcode": "L12 7EE",
"countrycode": "GB",
"gender": "F",
"dateofbirth": "8/8/1978"
},
{
"firstname": "Helen",
"surname": "Mirren",
"address1": "6 The Bells",
"address2": "",
"city": "Liverpool",
"state": "Liverpool",
"postcode": "LP10GG",
"countrycode": "UK",
"gender": "F",
"dateofbirth": "9/9/1979"
},
{
"firstname": "Rebecca",
"surname": "May",
"address1": "4 Clements Ln",
"address2": "",
"city": "London",
"state": "London",
"postcode": "EC1 4AA",
"countrycode": "UK",
"gender": "F",
"dateofbirth": "10/10/1980"
}
]'
```
</details>