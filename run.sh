cd config-server
./gradlew clean build -x test
docker build -t config-server .
cd ../data-service
./gradlew clean build -x test
docker build -t data-service .
cd ../db-service
./gradlew clean build -x test
docker build -t db-service .
cd ../service-discovery
./gradlew clean build -x test
docker build -t service-discovery .
cd ../ui-service
./gradlew clean build -x test
docker build -t ui-service .
cd ..
docker-compose -f docker-compose.yml up --remove-orphans