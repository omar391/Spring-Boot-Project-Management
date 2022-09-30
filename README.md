# Spring Boot project management API

## How to run the server:
In the terminal window write:
> make docker

It will start a docker container containing following container: 
- Spring APP : port 8080
- MySQL database 5.7 : port 3060
- phpmyadmin (db browser): port 8181

## Here we have added 3 APIs 

### Login
Run following curl query:
> curl --location --request POST 'localhost:8080/login' \
--header 'Content-Type: application/json' \
--data-raw '{
"username":"test-admin",
"password":"test-pass"
}'

Response:
```
{
"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0LWFkbWluIiwiZXhwIjoxNjY0NTYzNjY1LCJpYXQiOjE2NjQ1Mjc2NjV9.J5Vn_GGIWb92KSbMalI6NrxUsTLajUCy9MzybfEtv7KuRcCwXWCjq1sKaJAIIRC47G7AUIQIYvk8s9Kpynu2CQ",
"nickName": "Test-Project-Admin",
"accountId": 1
}
```

### Create a project:
Curl:
>curl --location --request POST 'localhost:8080/projects/create' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0LWFkbWluIiwiZXhwIjoxNjY0NTYyMTU4LCJpYXQiOjE2NjQ1MjYxNTh9.UUmT7WiK41siPYS3LYX31vsVYvWG46UuWX4AyMjYyZ3kTTQKOk7BAyaozU8siMV3wWoBi10wlSYuN1jml-n7Ow' \
--header 'Content-Type: application/json' \
--data-raw '{
"name":"Todo project",
"desc":"sample desc",
"owner":"zingman"
}'

Response:
```
{msg: 'Project is created successfully!'}
```

### List projects:
Cur:
> curl --location --request GET 'localhost:8080/projects/list' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0LWFkbWluIiwiZXhwIjoxNjY0NTYyMTU4LCJpYXQiOjE2NjQ1MjYxNTh9.UUmT7WiK41siPYS3LYX31vsVYvWG46UuWX4AyMjYyZ3kTTQKOk7BAyaozU8siMV3wWoBi10wlSYuN1jml-n7Ow' \
--header 'Content-Type: application/json' \
--data-raw '{
"pageNo":0,
"count":10
}'

Response:
```
{
    "state": "SUCCESS",
    "msg": "Get project list successful!",
    "data": {
        "total": 1,
        "list": [
            {
                "id": 3,
                "name": "Todo project",
                "intro": "sample desc",
                "owner": "zingman",
                "status": "PRE",
                "startDate": null,
                "endDate": null
            }
        ]
    }
}
```