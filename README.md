# Progetto_OOP
Questo è il repository che contiene il progetto svolto da Caponi Luca e Catalini Federico 
per l'esame di Programmazione ad Oggetti (A.A. 2019-2020) del corso di Laurea in Ingegneria Informatica e dell'Automazione presso l'Università Politecnica delle Marche.

## Introduzione
Il progetto consiste in una SpringBoot application, creata nell'ambiente java, usando l'IDE eclipse, che permette di acquisire e modellare dati da una API esterna. Il macrotema era quello di effettuare, definendo un insieme di stati (o un continente) e un determinato lasso di tempo, uno studio riguardo le statistiche Covid-19, facendo ottenere all’utente la lista degli stati ordinati secondo una classifica per numeri di contagi (dalla nazione con più casi a quella meno colpita dalla pandemia). Per fare questo dovevamo importare da una API predefinita (Get Countries) i dati identificativi di tutti i paesi del mondo. 
Per mostrare tutti questi passi al meglio, mostriamo il diagramma UML dei casi d'suo così da introdurre nella maniera più semplice possibile al funzionamento del progetto:

![diagramma_uso_sfondo](https://user-images.githubusercontent.com/64077382/97744559-bfa59700-1ae7-11eb-856f-0c36b24ca697.JPG)



La prima parte del lavoro è stata quella di pensare a come strutturare il progetto e per fare ciò ci è stato molto utile il linguaggio UML (Unified Modeling Language). In questa prima parte abbiamo iniziato a pensare al funzionamento della nostra applicazione:
1.	acquisizione dei dati dall'API GET COUNTRIES
2.	parsing di quest'ultima in una lista creata ad hoc per i nostri scopi
3.	parsing di una seconda API (Get By Country All Status) per riprendere i nostri dati
4.	caricamento all’interno di una classe Eclipse dei continenti con relativi paesi (Le API disponibili non permettevano di distinguere le nazioni per continente)   
5.	gestione delle chiamate (GET o POST) effettuate dall'utente
Per far questo abbiamo iniziato a pensare ai vari pacchetti che ci sarebbero serviti per suddividere il nostro lavoro al meglio rendendolo il più semplice e chiaro possibile anche per lo sviluppo del codice poi.


Ovviamente in seguito per ogni pacchetto abbiamo sviluppato tutte le varie classi che andavano ad implementare il progetto, così facendo abbiamo creato l'UML Class Diagram:

![TotalClassDiagram](https://user-images.githubusercontent.com/64077382/97726871-fcfe2a80-1acf-11eb-916e-52eed5aea081.png)


e il diagramma UML dei packages:

![Package](https://user-images.githubusercontent.com/64077382/97726850-f7a0e000-1acf-11eb-91fb-f6687deab566.png)


### ProgettoOOP.app
Package che contiene il main il quale richiama i metodi necessari per il corretto funzionamento del programma.

![App](https://user-images.githubusercontent.com/64077382/97726784-e657d380-1acf-11eb-8437-4f2d969b7b21.png)


### ProgettoOOP.app.controller
Package che contiene il controller dell'applicazione, ovvero la classe che gestisce tutte le chiamate GET o POST dell'utente.

![Controller](https://user-images.githubusercontent.com/64077382/97726797-e952c400-1acf-11eb-9d46-adb60bb822af.png)


### ProgettoOOP.app.service
Package che implementa i servizi resi disponibili attraverso l'applicazione, e che poi verranno richiamati nel controller (e quindi in risposta all'utente).

![Service](https://user-images.githubusercontent.com/64077382/97726854-f96aa380-1acf-11eb-8ad4-fb6b260d4f56.png)


### ProgettoOOP.app.database
Package che gestisce il download dei dati direttamente dalle chiamate alle API.

![Database](https://user-images.githubusercontent.com/64077382/97726824-f079d200-1acf-11eb-8761-fefd04731091.png)


### ProgettoOOP.app.model
Package che contiene tutte le classi che servono a implementare un oggetto Country e CountryAllStatus.

![Model](https://user-images.githubusercontent.com/64077382/97726847-f5d71c80-1acf-11eb-82f6-ffbf65d8bc53.png)


### ProgettoOOP.app.stats
Package che contiene le classi che elaborano le statistiche sul numero di contagi giornalieri e sulle loro variazioni percentuali.

![Stats](https://user-images.githubusercontent.com/64077382/97726859-fa9bd080-1acf-11eb-9cef-3c912fda6c2e.png)


### ProgettoOOP.app.filters
Package che permette di filtrare i paesi caricati in base al continente richiesto dall'utente sulla rotta /countries/{continente}

![Filters](https://user-images.githubusercontent.com/64077382/97726841-f40d5900-1acf-11eb-80aa-8c1517e4a280.png)


### Progetto.app.exception
Package per gestire le eccezioni che possono essere lanciate dal programma

![Exception](https://user-images.githubusercontent.com/64077382/97726832-f2439580-1acf-11eb-9f47-fc208a273394.png)



# Funzionamento
Mostriamo ora come utilizzare l'applicazione attraverso le sue chiamate e come quest'ultime funzionano.

## Chiamate
| Rotta | Metodo | Descrizione |
| :------------- |:----:| :------------- |
| /totalcountries | GET  | Restituisce tutti i paesi disponibili, ovvero il contenuto dell'API "GET Countries" |
| /countries | POST  | Permette all'utente di inserire i paesi |
| /countries | GET  | Restituisce i paesi inseriti dall'utente |
| /countries/{continent}| GET | Una volta impostato un continente nella rotta, restituisce soltanto i paesi inseriti appartenenti a quel continente|
| /metadata | GET  | Restituisce i metadati di un oggetto di tipo "Countries"  |
| /totalallstatus | GET  | Restituisce (per ogni paese precedentemente inserito) il totale dei casi confermati, dei decessi, dei ricoverati e degli attuali positivi nel periodo compreso tra la data iniziale inserita e quella finale |
| /covid/{status} | GET  | Stila le classifiche dei paesi caricati dall'utente in base al numero decrescente di confermati/decessi/ricoverati/positivi (a seconda della rotta richiesta)|
| /stats | GET  | Restituisce le statistiche sul numero dei contagi giornalieri e sulle loro variazioni percentuali per i paesi inseriti precedentemente dall'utente  |
| /stats/filter | GET  | Restituisce le statistiche filtrate in base alla soglia imposta dall'utente  |


In seguito, mostriamo i diagrammi delle sequenze per ogni chiamata. Questo è un diagramma previsto dall'UML utilizzato per descrivere uno scenario, ovvero una determinata sequenza di azioni in cui tutte le scelte sono state già effettuate.


### /totalcountries (GET)

![getTotalCountries](https://user-images.githubusercontent.com/64077382/97734115-05a72e80-1ad9-11eb-9c19-02184c6541b6.png)


### /countries (POST)

![postCountries](https://user-images.githubusercontent.com/64077382/97734128-093ab580-1ad9-11eb-9cae-57ca59a2c62e.png)


### /countries (GET)

![getCountries](https://user-images.githubusercontent.com/64077382/97734121-08098880-1ad9-11eb-8b92-fcf434edeb7f.png)


### /countries/{continent} (GET)

![getFilteredCountries](https://user-images.githubusercontent.com/64077382/97734134-0c35a600-1ad9-11eb-9c41-78c88ac04e89.png)


### /metadata (GET)

![getMetadata](https://user-images.githubusercontent.com/64077382/97734186-1a83c200-1ad9-11eb-8d30-86ab5f5b6d0a.png)


### /totalallstatus (GET)

![getTotalCountryAllStatus](https://user-images.githubusercontent.com/64077382/97734150-10fa5a00-1ad9-11eb-9770-5595cd0d9e7a.png)


### /covid/{status} (GET)

![getRankingStatus](https://user-images.githubusercontent.com/64077382/97734163-135cb400-1ad9-11eb-900f-8c41da240e9c.png)


### /stats (GET)

![getStats](https://user-images.githubusercontent.com/64077382/97734171-15267780-1ad9-11eb-9640-153416099652.png)


### /stats/filter (GET)

![getFilteredStats](https://user-images.githubusercontent.com/64077382/97734177-1788d180-1ad9-11eb-8ca3-6648fbdf1306.png)



 # Filtri
 Le API Postman importate non presentavano alcun attributo Continente. Abbiamo dunque gestito manualmente i 248 paesi del mondo catalogandoli nel loro continente di appartenenza.
Inserendo un paese con la chiamata POST viene riportato dunque il suo continente, inoltre attraverso un filtro applicabile usufruendo della rotta /countries/{continent} viene mostrata all'utente la lista dei paesi inseriti filtrata per il continente.


# Componenti

### Caponi Luca: Ha scritto il ReadMe
### Catalini Federico: Ha generato i diagrammi UML

Gli autori hanno ragionato l'idea del progetto e sviluppato il codice 
collaborando in totale sincronia, sia da remoto che in presenza.  



















