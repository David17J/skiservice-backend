# Ski-Service

# Inhaltsverzeichnis

- Auftrag
- Anforderungen
- Für welche Tools entschied ich mich?
- Was habe ich bis jetzt gemacht?
- Was ist noch inplanung
- Fazit

## Auftrag:

- Jetstream-Service Digitalisierung der Ski-Service-Auftragsverwaltung
- Lösung: Web- und Datenbank-Anwendung interne Verwaltung übernehmen, während die bestehende Online-Anmeldung erweitert wird.
- Mitarbeiter: Bis zu 10 mit passwortgeschütztem Zugriff
- Funktion: Aufträge einsehen, übernehmen, bearbeiten
- Umfang: Nur Backend

## Anforderungen

### Das Auftragsmanagement muss folgende Funktionen zur Verfügung stellen:

- Login mit Benutzername und Passwort
- Anstehende Serviceaufträge anzeigen (Liste)
- Bestehende Serviceaufträge mutieren. Dazu stehen folgende Stati zu Verfügung: Offen, InArbeit und abgeschlossen
- Aufträge löschen (ggf. bei Stornierung)

### Die Informationen zur Online-Anmeldung

- Kundenname
- E-Mail
- Telefon
- Priorität
- Dienstleistung (Angebot), Pro Serviceauftrag kann immer nur eine Dienstleistung zugeordnet werden.

### Die Firma bietet folgende Dienstleistungen (Angebot) an:

- Kleiner Service
- Grosser Service
- Rennski-Service
- Bindung montieren und einstellen
- Fell zuschneiden
- Heisswachsen

# Für welche Tools entschied ich mich?

- IDE: IntelliJ
- Docker: Um Mysql Datenbank angelegt und verbunden
- Dockercomposed: Um Datenbank zu installieren
- Java: mit Springboot Framework

Maven als Build system

- API aufgebaut mit Swagger und OpenAPI für die Beschreibung
- Swagger: Testen genutzt
- Postman: Testen
- Hibernate: Ein Java-Framework, das hilft, Datenbankoperationen einfacher zu machen. Es wandelt Java-Objekte automatisch in Datenbanktabellen um und umgekehrt (ORM – Object-Relational Mapping). So musst du weniger SQL schreiben und kannst einfacher mit Daten arbeiten.

# Was habe ich bis jetzt gemacht?

A1 Login Dialog mit Passwort für den autorisierten Zugang der Mitarbeiter (Datenänderung).

A2 In der Datenbank müssen die Informationen des Serviceauftrags und die Login Daten der Mitarbeiter verwaltet sein.

A3 Erfasste Serviceaufträge abrufbar sein.

A5 Die erfassten Serviceaufträge müssen selektiv nach Priorität abrufbar.

A6 Mitarbeiter können Aufträge löschen (z.b bei Stonierung)

A11 Das Softwareprojekt ist über ein Git-Repository zu verwalten.

# Und was ist noch inplanung

A5 Mitarbeiter können eine Statusänderung eines Auftrages vornehmen. -

A7 Die aufgerufenen API-Endpoints müssen zwecks Fehlerlokalisierung protokolliert sein -
(DB oder Protokolldatei).

A8 Datenbankstruktur muss normalisiert in der 3. NF sein inkl. referenzieller Integrität -

A9 Für die Web-API Applikation muss ein eigener Datenbankbenutzerzugang mit eingeschränkter Berechtigung -(DML) zur Verfügung gestellt werden (Benutzer root bzw. sa ist verboten).

A10 Das Web-API muss vollständig nach Open-API (Swagger) dokumentiert sein. -

A12 Ganzes Projektmanagement muss nach IPERKA dokumentiert sein. -

Grosse Bugs fixen und kleine Bugs fixen.

![alt text](image.png)

# Fazit
