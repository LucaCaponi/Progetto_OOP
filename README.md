# Progetto_OOP
Questo è il repository che contiene il progetto svolto da Caponi Luca e Catalini Federico 
per l'esame di Programmazione A Oggetti per il secondo anno di Ingegneria Informatica e dell'Automazione

## Introduzione
Il progetto consiste in una SpringBoot application, creata nell'ambiente java, usando l'IDE eclipse, che permette di acquisire e modellare dati da una API esterna. Il macrotema era quello di effettuare, definendo un insieme di stati (o un continente) e un determinato lasso di tempo, uno studio riguardo le statistiche Covid-19, facendo ottenere all’utente la lista degli stati ordinati secondo una classifica per numeri di contagi (dalla nazione con più casi a quella meno colpita dalla pandemia). Per fare questo dovevamo importare da una API predefinita (Get Countries) i dati identificativi di tutti i paesi del mondo. 
Per mostrare tutti questi passi al meglio, mostriamo il diagramma UML dei casi d'suo così da introdurre nella maniera più semplice possibile al funzionamento del progetto:



La prima parte del lavoro è stata quella di pensare a come strutturare il progetto e per fare ciò ci è stato molto utile il linguaggio UML (Unified Modeling Language). In questa prima parte abbiamo iniziato a pensare al funzionamento della nostra applicazione:
1.	acquisizione dei dati dall'API GET COUNTRIES
2.	parsing di quest'ultima in una lista creata ad hoc per i nostri scopi
3.	parsing di una seconda API (Get By Country All Status) per riprendere i nostri dati
4.	caricamento all’interno di una classe Eclipse dei continenti con relativi paesi (Le API disponibili non permettevano di distinguere le nazioni per continente)   
5.	gestione delle chiamate (GET o POST) effettuate dall'utente
Per far questo abbiamo iniziato a pensare ai vari pacchetti che ci sarebbero serviti per suddividere il nostro lavoro al meglio rendendolo il più semplice e chiaro possibile anche per lo sviluppo del codice poi.


Ovviamente in seguito per ogni pacchetto abbiamo sviluppato tutte le varie classi che andavano ad implementare il progetto, così facendo abbiamo creato l'UML Class Diagram.


### ProgettoOOP.app.controller
Package che contiene il controller dell'applicazione, ovvero la classe che gestisce tutte le chiamate GET o POST dell'utente.


### ProgettoOOP.app.database
Package che gestisce il download dei dati direttamente dalle chiamate alle API.


### ProgettoOOP.app.model
Package che contiene tutte le classi che servono a implementare un oggetto Country e CountryAllStatus


### ProgettoOOP.app.service
Package che implementa i servizi resi disponibili attraverso l'applicazione, e che poi verranno richiamati nel controller (e quindi in risposta all'utente).

### ProgettoOOP.app.filters
Package che permette di filtrare i paesi caricati in base al continente richiesto dall'utente sulla rotta /countries/{continente}

### Progetto.app.exception
Package per gestire le eccezioni che possono essere lanciate dal programma

### ProgettoOOP.app
Package che contiene il main il quale richiama i metodi necessari per il corretto funzionamento del programma.


# Funzionamento
Mostriamo ora come utilizzare l'applicazione attraverso le sue chiamate e come quest'ultime funzionano.

## Chiamate
| Rotta| Metodo | Descrizione |
| :------------- |:----:| -------------: |
| /countries | GET  | Restituisce i paesi inseriti |
| :------------- |:----:| -------------: |
| /countries | POST  | Inserisce i paesi |
| :------------- |:----:| -------------: |
| /countries/{ISO2} | DELETE  | Cancella il paese precedentemente inserito con il suo corrispondente ISO2 passato dall'utente|
| :------------- |:----:| -------------: |
| /countries/{continent}| GET | Dato il continente, riporta solo i paesi inseriti appartenenti a quel continente|
| :------------- |:----:| -------------: |
| /totalcountryallstatus | GET  | Restituisce i parametri dei casi Covid per i paesi inseriti |
| :------------- |:----:| -------------: |
| /totalcountries | GET  | Inserisce tutti i paesi del mondo |
| :------------- |:----:| -------------: |
| /confirmed | POST  | Inserisce in classifica i paesi inseriti per numero di confermati|
| :------------- |:----:| -------------: |


In seguito, mostriamo il diagramma delle sequenze. Questo è un diagramma previsto dall'UML utilizzato per descrivere uno scenario, 
ovvero una determinata sequenza di azioni in cui tutte le scelte sono state già effettuate.


 # Filtri
 Le API Postman importate non presentavano alcun attributo Continente. Abbiamo dunque gestito manualmente i 248 paesi del mondo catalogandoli nel loro continente di appartenenza.
Inserendo un paese con la chiamata POST viene riportato dunque il suo continente, inoltre attraverso un filtro applicabile usufruendo della rotta /countries/{continent} viene mostrata all'utente la lista dei paesi inseriti filtrata per il continente.


# Componenti

### Caponi Luca: Ha scritto il ReadMe
### Catalini Federico: Ha generato i diagrammi UML

Gli autori hanno ragionato l'idea del progetto e sviluppato il codice 
collaborando in totale sincronia.  



















