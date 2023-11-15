# Customer API
## Get All Customer
Endpoint : GET /customerss

## Create New Customer
Endpoint : POST /customers

#### Request Body :
```json
{
  "customerId": 1,
  "companyName" : "Sample",
  "contactName" : "Sample",
  "contactTitle" : "CEO",
  "address" : "Sample",
  "city" : "Sample",
  "country" : "Sample"
}
```
#### Response Update (Success) :
```json
{
  
}
```

#### Response Update (Failed) :
```json
{
  
}
```

## Update Customer
Endpoint : PUT /customers

#### Request Body :

```json
{
  "customerId": 1,
  "companyName" : "Sample",
  "contactName" : "Sample",
  "contactTitle" : "CEO",
  "address" : "Sample",
  "city" : "Sample",
  "country" : "Sample"
}
```

#### Response Update (Success) :
```json
{
  
}
```

#### Response Update (Failed) :
```json
{
  
}
```

## Remove Customer
Endpoint : DELETE /customers/{id}

#### Request Param :

```json
{
  "id": 1,
}
```

#### Response Update (Success) :
```json
{
  
}
```

#### Response Update (Failed) :
```json
{
  
}
```
