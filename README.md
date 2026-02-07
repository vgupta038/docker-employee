Docker network create::
docker network create emp-dept-net

MySQL container create command:
docker run --network emp-dept-net --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=employee_db -e MYSQL_USER=vishal -e MYSQL_PASSWORD=vishal -v C:\docker-mysql-data:/var/lib/mysql -d -p 3306:3306 mysql/mysql-server

Employee service create command::
docker run --network emp-dept-net --name employee-container -d -p 8080:8080 8a9fe7887162
