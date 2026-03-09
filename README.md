1. Clone repository
2. docker compose up -d

Employee Service
http://localhost:8080

postman request POST 'http://localhost:8080/employee' \
  --header 'Content-Type: application/json' \
  --body '{
    "empName":"abcd",
    "empId":"4534",
    "departmentName":"accounts"
}'
