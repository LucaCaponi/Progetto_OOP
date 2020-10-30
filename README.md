# Progetto_OOP
Questo è il repository che contiene il progetto svolto da Caponi Luca e Catalini Federico 
per l'esame di Programmazione a Oggetti per il secondo anno di Ingegneria Informatica e dell'Automazione nell'A.A. 2019-2020.

## Introduzione
Il progetto consiste in una SpringBoot application, creata nell'ambiente java, usando l'IDE eclipse, che permette di acquisire e modellare dati da una API esterna. Il macrotema era quello di effettuare, definendo un insieme di stati (o un continente) e un determinato lasso di tempo, uno studio riguardo le statistiche Covid-19, facendo ottenere all’utente la lista degli stati ordinati secondo una classifica per numeri di contagi (dalla nazione con più casi a quella meno colpita dalla pandemia). Per fare questo dovevamo importare da una API predefinita (Get Countries) i dati identificativi di tutti i paesi del mondo. 
Per mostrare tutti questi passi al meglio, mostriamo il diagramma UML dei casi d'suo così da introdurre nella maniera più semplice possibile al funzionamento del progetto:

![diagramma_uso](https://user-images.githubusercontent.com/64077382/97726165-3d10dd80-1acf-11eb-8c8a-acdfc2d5a8fe.jpg)



La prima parte del lavoro è stata quella di pensare a come strutturare il progetto e per fare ciò ci è stato molto utile il linguaggio UML (Unified Modeling Language). In questa prima parte abbiamo iniziato a pensare al funzionamento della nostra applicazione:
1.	acquisizione dei dati dall'API GET COUNTRIES
2.	parsing di quest'ultima in una lista creata ad hoc per i nostri scopi
3.	parsing di una seconda API (Get By Country All Status) per riprendere i nostri dati
4.	caricamento all’interno di una classe Eclipse dei continenti con relativi paesi (Le API disponibili non permettevano di distinguere le nazioni per continente)   
5.	gestione delle chiamate (GET o POST) effettuate dall'utente
Per far questo abbiamo iniziato a pensare ai vari pacchetti che ci sarebbero serviti per suddividere il nostro lavoro al meglio rendendolo il più semplice e chiaro possibile anche per lo sviluppo del codice poi.


Ovviamente in seguito per ogni pacchetto abbiamo sviluppato tutte le varie classi che andavano ad implementare il progetto, così facendo abbiamo creato l'UML Class Diagram:

![TotalClassDiagram](https://user-images.githubusercontent.com/64077382/97055924-10693d00-1588-11eb-887e-5955cdeeb761.png)

e il diagramma UML dei packages:

![Package](https://user-images.githubusercontent.com/64077382/97056034-4c9c9d80-1588-11eb-9e38-cc1a7ccc3187.png)




### ProgettoOOP.app.controller
Package che contiene il controller dell'applicazione, ovvero la classe che gestisce tutte le chiamate GET o POST dell'utente.

![Controller](https://user-images.githubusercontent.com/64077382/97056185-a7ce9000-1588-11eb-821c-5c3a307461f9.png)


### ProgettoOOP.app.database
Package che gestisce il download dei dati direttamente dalle chiamate alle API.

![Database](https://user-images.githubusercontent.com/64077382/97056231-c2a10480-1588-11eb-8122-3fd7a32dbd8e.png)


### ProgettoOOP.app.model
Package che contiene tutte le classi che servono a implementare un oggetto Country e CountryAllStatus.

![Model](https://user-images.githubusercontent.com/64077382/97056663-cda86480-1589-11eb-8659-5b8798b8acbe.png)


### ProgettoOOP.app.service
Package che implementa i servizi resi disponibili attraverso l'applicazione, e che poi verranno richiamati nel controller (e quindi in risposta all'utente).

![Service](https://user-images.githubusercontent.com/64077382/97056707-e6b11580-1589-11eb-84f9-c1145a084f48.png)


### ProgettoOOP.app.filters
Package che permette di filtrare i paesi caricati in base al continente richiesto dall'utente sulla rotta /countries/{continente}

![Filters](https://user-images.githubusercontent.com/64077382/97056547-8de17d00-1589-11eb-953f-b8b40f5e4b82.png)


### Progetto.app.exception
Package per gestire le eccezioni che possono essere lanciate dal programma

![Exception](https://user-images.githubusercontent.com/64077382/97056348-0d228100-1589-11eb-8cd5-a9d39453182f.png)


### ProgettoOOP.app
Package che contiene il main il quale richiama i metodi necessari per il corretto funzionamento del programma.

![App](https://user-images.githubusercontent.com/64077382/97056790-1829e100-158a-11eb-8e97-65bc165f93a5.png)



# Funzionamento
Mostriamo ora come utilizzare l'applicazione attraverso le sue chiamate e come quest'ultime funzionano.

## Chiamate
| Rotta| Metodo | Descrizione |
| :------------- |:----:| :------------- |
| /countries | GET  | Restituisce i paesi inseriti |
| /countries | POST  | Inserisce i paesi |
| /countries/{ISO2} | DELETE  | Cancella il paese precedentemente inserito con il suo corrispondente ISO2 passato dall'utente|
| /countries/{continent}| GET | Dato il continente, riporta solo i paesi inseriti appartenenti a quel continente|
| /totalcountryallstatus | GET  | Restituisce i parametri dei casi Covid per i paesi inseriti |
| /totalcountries | GET  | Inserisce tutti i paesi del mondo |
| /confirmed | GET  | Stila una classifica dei paesi inseriti per numero di confermati|



In seguito, mostriamo i diagrammi delle sequenze per ogni chiamata. Questo è un diagramma previsto dall'UML utilizzato per descrivere uno scenario, ovvero una determinata sequenza di azioni in cui tutte le scelte sono state già effettuate.


### /countries (GET)

![getCountries](https://user-images.githubusercontent.com/64077382/97057109-d8172e00-158a-11eb-96c7-dc6b8a3ae9b3.png)


### /countries (POST)

![InsertCountry](https://user-images.githubusercontent.com/64077382/97057116-d9e0f180-158a-11eb-979a-d7c0a7522215.png)


### /countries/{ISO2} (DELETE)

![delete](https://user-images.githubusercontent.com/64077382/97057107-d6e60100-158a-11eb-8728-cef1ab2a38af.png)


### /countries/{continent} (GET)

![getFilteredCountries](https://user-images.githubusercontent.com/64077382/97057110-d8afc480-158a-11eb-8fe7-a39f7d01196a.png)


### /totalcountryallstatus (GET)

![gettotalCountryAllStatus](https://user-images.githubusercontent.com/64077382/97057114-d9485b00-158a-11eb-8d90-907ac0ff34fd.png)


### /totalcountries (GET)

![gettotalCountries](https://user-images.githubusercontent.com/64077382/97057113-d9485b00-158a-11eb-9eee-09d41061b381.png)


### /confirmed (GET)

![getstatsconfirmed](https://user-images.githubusercontent.com/64077382/97057112-d8afc480-158a-11eb-9c41-5131febc219f.png)




 # Filtri
 Le API Postman importate non presentavano alcun attributo Continente. Abbiamo dunque gestito manualmente i 248 paesi del mondo catalogandoli nel loro continente di appartenenza.
Inserendo un paese con la chiamata POST viene riportato dunque il suo continente, inoltre attraverso un filtro applicabile usufruendo della rotta /countries/{continent} viene mostrata all'utente la lista dei paesi inseriti filtrata per il continente.


# Componenti

### Caponi Luca: Ha scritto il ReadMe
### Catalini Federico: Ha generato i diagrammi UML

Gli autori hanno ragionato l'idea del progetto e sviluppato il codice 
collaborando in totale sincronia, sia da remoto che in presenza.  



















