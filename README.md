# Progetto_OOP
Questo è il repository che contiene il progetto svolto da **Caponi Luca** e **Catalini Federico** 
per l'esame di Programmazione ad Oggetti (A.A. 2019-2020) del corso di Laurea in Ingegneria Informatica e dell'Automazione presso l'Università Politecnica delle Marche.

## Introduzione
Il progetto consiste in una SpringBoot application, creata nell'ambiente java usando l'IDE Eclipse, che permette di acquisire e modellare dati da più API esterne, restituendoli in formato JSON. 

Il macrotema ha come obiettivo quello di stilare (definendo un insieme di stati e un determinato lasso di tempo) delle classifiche dei paesi in base ai parametri "confirmed", "deaths", "recovered" e "active". Inoltre, sono state elaborate le statistiche riguardo i contagi giornalieri e le loro variazioni percentuali.

La nostra applicazione, comunicando con le API fornite, permette all'utente di caricare una lista di nazioni e di ottenere per gli stati inseriti le classifiche sopracitate (dalla nazione con più casi, decessi, ricoverati o attualmente positivi a quella meno colpita dalla pandemia). Per far questo è stato necessario effettuare il parsing di un'API predefinita (**GET Countries**) contenente i dati identificativi di tutti i paesi del mondo ("Country, "Slug" ed "ISO2"). Inoltre, i dati da elaborare sono stati ottenuti richiamando l'API **GET By Country All Status**, la quale, però, non fornisce i dati giorno per giorno, ma restituisce una sommatoria dei casi registrati dal 22 Gennaio 2020 in poi. E' stato dunque nostro compito calcolare i dati giornalieri, necessari per stilare le classifiche e ottenere le statistiche.

Per mostrare tutti i metodi resi disponibili, mostriamo il diagramma UML dei casi d'uso così da introdurre in maniera immediata il funzionamento del progetto:

![diagramma_uso_sfondo](https://user-images.githubusercontent.com/64077382/97744559-bfa59700-1ae7-11eb-856f-0c36b24ca697.JPG)



## Sviluppo
A grandi linee, lo sviluppo del progetto è stato suddiviso nei seguenti steps:
1.	acquisizione dei dati dall'API "GET Countries" e parsing di quest'ultima, creando oggetti "Countries".
2. creazione di una classe controller per gestire le chiamate GET e POST in PostMan.
3. implementazione tramite un service dei metodi da richiamare sul controller.   
4.	inizializzazione di variabili e metodi con l'obiettivo di stilare le classifiche richieste.
5. inizializzazione di variabili e metodi con l'obiettivo di fornire le statistiche sui contagi giornalieri e                  
   le loro variazioni percentuali.
6. creazione di un filtro per la suddivisione dei paesi inseriti in base ai loro rispettivi continenti.
7. creazione di un filtro per visualizzare i giorni con un minor/maggior numero di casi confermati rispetto    
   ad un valore soglia ("threshold").
8. verifica del corretto funzionamento di metodi ed eccezioni avvalendosi di quattro classi test.

### Diagramma delle classi
Per far questo abbiamo suddiviso il nostro lavoro in diversi packages, al fine di renderlo più semplice e chiaro:

![Package](https://user-images.githubusercontent.com/64077382/97726850-f7a0e000-1acf-11eb-91fb-f6687deab566.png)


Ovviamente, in seguito, per ogni package, abbiamo sviluppato tutte le varie classi che vanno ad implementare il progetto; così facendo abbiamo creato l'UML Class Diagram:

![TotalClassDiagram](https://user-images.githubusercontent.com/64077382/97726871-fcfe2a80-1acf-11eb-916e-52eed5aea081.png)


#### ProgettoOOP.app
Package che contiene la classe "main" la quale richiama i metodi necessari per il corretto funzionamento del programma e lancia SpringBoot.

![App](https://user-images.githubusercontent.com/64077382/97726784-e657d380-1acf-11eb-8437-4f2d969b7b21.png)


#### ProgettoOOP.app.controller
Package che contiene il controller dell'applicazione, ovvero la classe che gestisce tutte le chiamate GET o POST richieste dall'utente e le eventuali eccezioni.

![Controller](https://user-images.githubusercontent.com/64077382/97726797-e952c400-1acf-11eb-9d46-adb60bb822af.png)


#### ProgettoOOP.app.service
Package che implementa i servizi resi disponibili attraverso l'applicazione, e che poi verranno richiamati nel controller (e quindi in risposta all'utente).

![Service](https://user-images.githubusercontent.com/64077382/97726854-f96aa380-1acf-11eb-8ad4-fb6b260d4f56.png)


#### ProgettoOOP.app.database
Package che gestisce il download e il parsing dei dati comunicando con le API.

![Database](https://user-images.githubusercontent.com/64077382/97726824-f079d200-1acf-11eb-8761-fefd04731091.png)


#### ProgettoOOP.app.model
Package che contiene le classi che servono a implementare un oggetto di tipo "Countries" e la classe "Metadata", necessaria per restituire i metadati.

![Model](https://user-images.githubusercontent.com/64077382/97726847-f5d71c80-1acf-11eb-82f6-ffbf65d8bc53.png)


#### ProgettoOOP.app.stats
Package che contiene le classi che elaborano le statistiche sul numero di contagi giornalieri e sulle loro variazioni percentuali.

![Stats](https://user-images.githubusercontent.com/64077382/97726859-fa9bd080-1acf-11eb-9cef-3c912fda6c2e.png)


#### ProgettoOOP.app.filters
Package che contiene le classi che permettono di filtrare i paesi caricati in base al continente richiesto dall'utente sulla rotta /countries/{continent}, la classe "FiltersAllStatus" che consente di ottenere le classifiche in base allo status immesso nella rotta, e la classe "StatsFilter" che permette di esaminare le statistiche filtrate in base a un valore soglia ("threshold").

![Filters](https://user-images.githubusercontent.com/64077382/97726841-f40d5900-1acf-11eb-80aa-8c1517e4a280.png)


#### Progetto.app.exception
Package che contiene le classi necessarie a gestire le eccezioni che possono essere lanciate all'interno del programma.
Esse, a loro volta, sono gestite dalla classe “ExceptionPrincipal”, una classe modello contenente quattro attributi chiave, che permette di restituire le eccezioni (in Postman) in formato JSON.

![Exception](https://user-images.githubusercontent.com/64077382/97726832-f2439580-1acf-11eb-9f47-fc208a273394.png)



# Funzionamento
Dopo aver avviato l'applicazione, l'utente potrà interrogarla in Postman attraverso delle chiamate all'indirizzo http://localhost:8080 .
Come rappresentato nel diagramma UML dei casi d'uso, le rotte disponibili sono otto di tipo GET e una di tipo POST.

Mostriamo ora come utilizzare l'applicazione attraverso le sue chiamate e come quest'ultime funzionano. 

## Chiamate
| Rotta | Metodo | Descrizione |
| :------------- |:----:| :------------ |
| /totalcountries | GET  | Restituisce tutti i paesi disponibili, ovvero il contenuto dell'API "GET Countries" |
| /countries | POST  | Permette all'utente di inserire i paesi |
| /countries | GET  | Restituisce i paesi inseriti dall'utente |
| /countries/{continent}| GET | Una volta impostato un continente nella rotta, restituisce soltanto i paesi inseriti appartenenti a quel continente|
| /metadata | GET  | Restituisce i metadati di un oggetto di tipo "Countries"  |
| /totalallstatus | GET  | Restituisce (per ogni paese precedentemente inserito) il totale dei casi confermati, dei decessi, dei ricoverati e degli attuali positivi nel periodo compreso tra la data iniziale inserita e quella finale |
| /covid/{status} | GET  | Stila le classifiche dei paesi caricati dall'utente in base al numero decrescente di confermati/decessi/ricoverati/positivi (a seconda della rotta richiesta)|
| /stats | GET  | Restituisce le statistiche sul numero dei contagi giornalieri e sulle loro variazioni percentuali per i paesi inseriti precedentemente dall'utente  |
| /stats/filter | GET  | Restituisce le statistiche filtrate in base alla soglia imposta dall'utente  |

### Esempio di funzionamento

* **L'utente vuole visualizzare tutti i paesi che può ricercare:**

[esempio di chiamata GET "/totalcountries"](https://github.com/LucaCaponi99/Progetto_OOP/blob/master/app/Esempi%20di%20chiamate%20e%20risposte%20POSTMAN/GETTotalcountries.jpg)


* **Per inserire il paese in modo corretto visiona la tipologia e la descrizione dei metadati:**

[esempio di chiamata GET "/metadata"](https://github.com/LucaCaponi99/Progetto_OOP/blob/master/app/Esempi%20di%20chiamate%20e%20risposte%20POSTMAN/GETMetadata.jpg)


* **Carica i paesi su cui vuole stilare le classifiche e/o ottenere le statistiche:** 

[esempio di chiamata POST "/countries"](https://github.com/LucaCaponi99/Progetto_OOP/blob/master/app/Esempi%20di%20chiamate%20e%20risposte%20POSTMAN/POSTCountries.jpg)


* **Visualizza la lista dei paesi inseriti:**

[esempio di chiamata GET "/countries"](https://github.com/LucaCaponi99/Progetto_OOP/blob/master/app/Esempi%20di%20chiamate%20e%20risposte%20POSTMAN/GETCountries.jpg)


* **La lista può essere filtrata per continente; l'utente avrà la possibilità (ad esempio) di visualizzare a schermo i paesi europei caricati:**

[esempio di chiamata GET "/countries/{{continent}}"](https://github.com/LucaCaponi99/Progetto_OOP/blob/master/app/Esempi%20di%20chiamate%20e%20risposte%20POSTMAN/GETCountries-continent.jpg)


* **Il fruitore del programma, oltre alle classifiche, potrà richiedere un sommario della situazione Covid, sia per il periodo di default (1 Marzo 2020-1 Aprile 2020) che per un periodo a sua scelta:**

[esempio di chiamata GET "/totalallstatus"](https://github.com/LucaCaponi99/Progetto_OOP/blob/master/app/Esempi%20di%20chiamate%20e%20risposte%20POSTMAN/GETTotalallstatus.jpg)

[esempio di chiamata GET "/totallallstatus (con parametri from, to)"](https://github.com/LucaCaponi99/Progetto_OOP/blob/master/app/Esempi%20di%20chiamate%20e%20risposte%20POSTMAN/GETTotalallstatus_from-to.jpg)


* **Un possibile cliente dell'applicazione, come già anticipato, potrà visualizzare le classifiche in base al numero di casi:**

**- CONFERMATI:**
[esempio di chiamata GET "/covid/confirmed"](https://github.com/LucaCaponi99/Progetto_OOP/blob/master/app/Esempi%20di%20chiamate%20e%20risposte%20POSTMAN/GETConfirmed.jpg)

**- DECESSI:**
[esempio di chiamata GET "/covid/deaths"](https://github.com/LucaCaponi99/Progetto_OOP/blob/master/app/Esempi%20di%20chiamate%20e%20risposte%20POSTMAN/GETDeaths.jpg)

**- RICOVERATI:**
[esempio di chiamata GET "/covid/recovered"](https://github.com/LucaCaponi99/Progetto_OOP/blob/master/app/Esempi%20di%20chiamate%20e%20risposte%20POSTMAN/GETRecovered.jpg)

**- ATTIVI:**
[esempio di chiamata GET "/covid/active"](https://github.com/LucaCaponi99/Progetto_OOP/blob/master/app/Esempi%20di%20chiamate%20e%20risposte%20POSTMAN/GETActive.jpg)


* **L'utente può osservare le statistiche giornaliere sul numero dei casi confermati con le variazioni percentuali rispetto al giorno precedente:**

[esempio di chiamata GET "/stats"](https://github.com/LucaCaponi99/Progetto_OOP/blob/master/app/Esempi%20di%20chiamate%20e%20risposte%20POSTMAN/GETStats.jpg)

* **La lista delle statistiche può essere filtrata inserendo un valore soglia: si può richiedere quindi la lista dei giorni con un numero di contagi**

**-minore** se il prefisso del valore numerico è **$lt**

**-maggiore** se il prefisso è **$gt**

[esempio di chiamata GET "/stats/filter"](https://github.com/LucaCaponi99/Progetto_OOP/blob/master/app/Esempi%20di%20chiamate%20e%20risposte%20POSTMAN/GETStatsFilter.jpg)

## Statistiche
Dopo aver caricato la lista di nazioni e stabilito un periodo da analizzare, si apre la connessione all'API GET By Country All Status, vi si estrapolano i dati e vengono generate le statistiche giornaliere sul numero di casi confermati e le loro variazioni percentuali.
Ciò è stato possibile grazie alla creazione di un oggetto di tipo **"StatsModel"** contenente tre attributi chiave:
* **"Date"**: data visualizzata.
* **"DailyConfirmed"**: casi confermati nel giorno "Date"
* **"Var"**: variazione percentuale.

#### FOCUS: "Var"
La variazione percentuale è un indice che mostra l'incremento (o il decremento) del numero di contagi rispetto al giorno prima.
La formula utilizzata per calcolare la variazione percentuale di contagi tra un giorno X e il precedente Y è la seguente:
* **Var = [(X-Y)/Y]x100**

Se nel giorno precedente non sono presenti nuovi contagi, la formula sarà:
* **Var = [(X-Y)/1]x100**

Per spiegare la formula si fa riferimento ad un esempio pratico.

**ESEMPIO:**

Nel giorno 30 Ottobre 2020 **(2020-10-30T00:00:00Z)** in Italia sono stati registrati **31079** casi confermati.

Il giorno prima **(2020-10-29T00:00:00Z)** erano **26829**.

La variazione percentuale sarà dunque:
* **Var**=[(31079-26829)/260829]x100= **15.84%**

L'oggetto StatsModel che verrebbe restituito in formato JSON sarebbe il seguente:

**"Date"**: "2020-10-30T00:00:00Z",

**"DailyConfirmed"**: 31079,

**"Var"**: "15.84%"


 ## Filtri
 Sono stati creati due filtri:
 * **Filtro per i continenti**
 Le API Postman importate non presentavano alcun attributo Continente. Abbiamo dunque gestito manualmente i 248 paesi del mondo catalogandoli nel loro continente di appartenenza.
Inserendo un paese con la chiamata POST viene riportato il suo continente, inoltre attraverso un filtro applicabile usufruendo della rotta /countries/{continent} viene mostrata all'utente la lista dei paesi inseriti filtrata per il continente. Se nella rotta verrà inserito un continente errato, il programma lancerà l'eccezione gestita **NotValidContinent()**.

* **Filtro soglia (threshold)**
Nel visualizzare la lista dei contagi giornalieri con le realtive variazioni percentuali, si è pensato di dare all'utente la possibilità di filtrare l'elenco in base ad un valore soglia (threshold) di casi confermati. L'elenco restituito conterrà solo gli oggetti di tipo StatsModel in cui i casi confermati (a cui è attribuita la chiave DailyConfirmed) sono **minori** o **maggiori** del valore richiesto dall'utente.

Il parametro **threshold** è un codice alfanumerico così costruito:
* il prefisso letterale (**$gt** o **$lt**) per far partire l'istruzione condizionale. Se il prefisso è errato si lancia l'eccezione gestita **NotValidThreshold()**. 
* il valore numerico corrispondente alla soglia. 

**ESEMPI:**

**$gt2000** = restituisce la lista dei giorni in cui si hanno **più di 2000 contagi**.

**$lt500**  = restituisce la lista dei giorni in cui si hanno **meno di 500 contagi**.


## Eccezioni
Tutte le eccezioni personalizzate ereditano dalla classe astratta **“ExceptionAbstract”**:

* L’eccezione **"NoJSONObject”** viene lanciata quando non è presente nessun JSONObject da restituire in Postman.
* L’eccezione **"NotValidCountry”** viene lanciata quando viene inserito erroneamente un paese che non esiste.
* L’eccezione **“ExistingISO2”** viene lanciata quando viene ricaricato un paese già inserito in precedenza.
* L’eccezione **“NotValidContinent”** viene lanciata quando viene richiamato nella rotta “/countries/{continent}” un continente errato o inesistente.
* L’eccezione **“NotValidStatus”** viene lanciata quando lo status inserito nella rotta “/covid/{status}” è errato o inesistente.
* L’eccezione **“NotValidThreshold”** viene lanciata quando la soglia (“threshold”) inserita come parametro per la chiamata “/stats/filter” è errata.

Il modo in cui le precedenti eccezioni vengono visualizzate in Postman viene riportato qui di seguito:





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




# Componenti

* **Caponi Luca**: Ha scritto il ReadMe
* **Catalini Federico**: Ha generato i diagrammi UML

Gli autori hanno ragionato l'idea del progetto e sviluppato il codice 
collaborando in totale sincronia, sia da remoto che in presenza.  



















