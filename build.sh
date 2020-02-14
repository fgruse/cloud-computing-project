cd config-server
./gradlew clean build -x test
cd ../data-service
./gradlew clean build -x test
cd ../db-service
./gradlew clean build -x test
cd ../service-discovery
./gradlew clean build -x test
cd ../ui-service
./gradlew clean build -x test