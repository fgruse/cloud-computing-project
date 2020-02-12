# Cloud Computing Project

von [Laura Zaworski](https://github.com/LauraZaworski), [Sophie Schröder](https://github.com/sophieschrder), [Anna-Frieda Gruse](https://github.com/cosmoem)

Dieses Projekt ist im Rahmen der Lehrveranstaltung Verteilte System an der HTW Berlin im WS 19/20 entstanden.

## 1. Aufgabenstellung
Das Ziel war es, eine "sinnvolle" Anwendung zu entwickeln, die aus mindestens drei Microservices besteht, welche miteinander kommunizieren (REST). 
Dabei sollte außerdem eine Datenbank zum speichern von Daten verwendet werden sowie Spring Cloud Services wie z.B. Eureka oder Configuration Server und es sollten mindestens zwei Resilience-Patterns implementiert werden. 
Die Anwendung sollte außerdem als eine Cloud-Anwendung konzipiert sein (IaaS oder PaaS) und gut skalierbar sein.

## 2. Unsere Anwendung
### 2.1 Beschreibung
Mit unserer Anwendung kann ein Nutzer sich aktuelle Informationen zu bevorstehenden Flügen abrufen. Dazu muss er einfach die Flugnummer seines Fluges eingeben und erhält sofort Informationen über Datum, die operierende Fluggesellschaft, Abflugort, Ankunftsort und die Abflugszeit. Des weiteren wird natürlich der Flugstatus angezeigt: 'Cancelled', 'On Time', 'Delayed' oder falls die Information gerade einmal nicht verfügbar sein sollte 'Currently Not Available" ist. 

### 2.2 Aufbau

#### Micorservices

- UI-Service: User Interface
    - User kann anhand einer Flugnummer Informationen über Flüge abrufen
    - Informationen über Flüge kommen vom DB-Service
    - Informationen über Flugstatus kommen von Data-Service
    - aufgesetzt mit Spring Web und Thymeleaf
    - Port 8080
- DB-Service: Informationen über Flüge
    - kommuniziert mit einer MySQL-Datenbank (Port 3306)
    - stellt Fluginformationen über einen API-Endpoint bereit
    - Kommunikation mit API erfolgt über REST
    - Port 8083
- Data-Service: Informationen über Flugstatus
    - generiert Flugstatus pro Flugnummer zufällig (richtige Implementation hätte Rahmen des Projekts gesprengt)
    - stellt Flugstatusinformationen über einen API-Endpoint bereit
    - Kommunikation mit API erfolgt über REST
    - Port 8989

#### Infrastrukturkomponenten

- Service Discovery mit Eureka: erkennt laufende Microservices automatisch
    - Port 8761
- Configuration Server: speichert zentralisiert die Config-Dateien für alle Services 
    - Dateien befinden sich im Verzeichnis `config-server/configs`
    - in den `bootstrap.properties` jedes Services wird der Port festgelegt
    - Port 8888

#### Resilience 

- Monitoring & Health Check: mit Eureka
    - Mit Hilfe von Eureka werden nicht nur alle Services automatisch gefunden, sondern es wird auch überprüft, ob sie "gesund" sind/ laufen.
- Circuit Breaker & Fallback & Timeout: mit Hystrix
    - Falls die UI keine Informationen über den Flugstatus vom Data-Service bekommt, aber Verbindung zum DB-Service hergestellt werden kann, werden trotzdem die Fluginformationen angezeigt und statt des Flugstatus einfach "CURRENTLY NOT AVAILABLE" ausgegeben.
    - Falls die UI keine Verbindung zum DB-Service herstellen kann, kann auch nicht überprüft werden, ob die eingegebene Flugnummer überhaupt gültig ist und dementsprechend auch kein Flugstatus ausgegeben werden. Es wird als Fallback ein "leerer Flug" zurückgegeben, welcher dazu führt, dass dem User eine Error-Page angezeigt wird.
    - Dadurch dass Fallbacks genutzt werden, sobald Fehler auftreten, haben die Services gegebenenfalls Zeit sich zu erholen.
    - Mit Hilfe des Hystrix Dashboards kann das ganze beobachtet werden. Dazu muss einfach http://localhost:8080/hystrix/ aufgerufen werden und der Stream `http://localhost:8080/actuator/hystrix.stream` gemonitored werden.
    - Falls einer der Remote Services (DB & Data) zu lange braucht um zu antworten oder nicht erreichbar ist, erfolgt ein Timeout. Das ist implizit mit implementiert durch die Nutzung von `@HystrixCommand` und beträgt per Default 1000ms.
- Retries: mit Spring Retry
    - Beim Starten der Anwendung benötigen alle Services ihre Konfigurationen vom Config-Server. Falls dieser noch nicht bereit ist, schlagen Verbindungsversuche fehl. Wenn die Verbindung fehlschlägt, versuchen die Services sich innerhalb von festgelegten Intervallen erneut zu verbinden (max. 5mal). Das gibt dem Config-Server genug Zeit zu starten ohne, dass der Start der gesamten Anwendung fehlschlägt. Die Konfiguration für die Retries befindet sich bei allen Services in den `bootstrap.properties`.

#### Cloud Infrastructure

- Deployable mit CloudFoundry Dev: TODO
- Skalierbarkeit: TODO


### 2.3 Getting Started

1. Datenbank

Um die Anwendung starten zu können, muss `mysql` lokal installiert sein. Das Passwort des MySQL-root-Users ist derzeit als `systeme` festgelegt und muss entweder so gesetzt werden oder in der Datei `config-server/configs/db-service.properties` geändert werden, damit Datenbankzugriff erfolgen kann. 
Das erstellen der Datenbank sowie das füllen mit Daten passiert dann automatisch.

2. Starten der Anwendung

TODO

3. Nutzen der Anwendung

Zunächst muss die Anwendung im Browser unter https://localhost:8080/flug aufgerufen werden. Es sollte die UI erscheinen, die den User auffordert, eine Flugnummer einzugeben.

Flugnummern, für die Fluginformationen vorhanden sind:

AB459DZ, HRZ6785, EJEK753, LIR0912, JJK8865, KKF890, ABC1234, JB007, GRI6543, T69KL5, X87UL1, OS57LM, EJU5907, LX981, BA8494
