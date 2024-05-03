# Treffipeli

Tarkoitus:

Treffipeli on suunniteltu tarjoamaan pelaajille viihdyttävää ja vuorovaikutteista ajanvietettä. Peli antaa mahdollisuuden käyttää mielikuvitusta ja luoda hauskoja tilanteita kuvitteellisten treffikokemusten kautta. Tavoitteena on nauttia yhdessäolosta, luoda hupaisia muistoja ja viettää rentoa aikaa ystävien seurassa. Peli yhdistää juoman nauttimisen ja pelin pelaamisen luoden hauskan ja rentouttavan ilmapiirin.

Pelin kulku:

1.	Jokainen pelaaja kirjoittaa kolme hyvää ja kolme huonoa piirrettä fiktiivisestä treffikumppanistaan erillisille lapuille.
2.	Laput taitetaan ja laitetaan pipoon tai muuhun säilytysastiaan.
3.	Pelaajat istuvat ympyrässä.
4.	Peli alkaa siten, että ensimmäinen pelaaja nostaa yhden lapun piposta.
5.	KAIKKI pelaajat juovat "ensimmäisille treffeille" ennen kuin ensimmäinen pelaaja lukee ääneen, mitä lapussa lukee. Sen jälkeen pelaaja päättää, haluaako hän jatkaa fiktiivisen treffikumppaninsa kanssa vai erota.
6.	Jos pelaaja haluaa jatkaa treffikumppanin kanssa, on seuraavan pelaajan vuoro. Jos pelaaja haluaa erota, hän heittää lapun pois. Sen jälkeen kaikki pelaajat juovat ja on seuraavan pelaajan vuoro.
7.	Peli jatkuu samalla kaavalla, ja kaikki pelaajat juovat jokaisen kolmansille, viidensille ja kuudensille treffeille.
8.	Peli päättyy, kun kaikki pelaajat ovat käyneet kuusilla treffeillään.

Käyttöliittymä
https://www.figma.com/file/w838b3bW6LBu98DKPo6hQJ/Treffipeli?type=design&node-id=2%3A2&mode=design&t=ilmjYHuqAJE0XGyR-1



//RedWine ryhmän projekti, tarkoituksena tehdä korttipeli, jonka client skaalaautuu eri laitteille.
Pelin säännöt yms. selvitellään myöhemmin. Projekti voi mahdolliseti käyttää jotain kysymys/trivia pohjaista avointa dataa api kutsuilla, mutta lähtökohtaisesti tarvitaan omaa tietokantaa.

# Teknologiat

- Java 17
- SpringBoot 3.2.2
- Spring Web
- Spring WebSocket
- Spring Data JPA
- Spring Security
- H2 Database
- jaxb
- jjwt
- gson

# Asennus

Projektin mukana tulee dockerfile tiedosto, jonka avulla palvelimen voi pystyttää helposti konttiin. Tuorein versio löytyy myös dockerhubista tägillä sajaris/juomapeliback.

Konttiasennukseen tarvitsee pelkästään Dockerin.

## Asennus komennot

### 1.a Imagen luonti
```
# docker build -f .\juomapeli.Dockerfile . -t <Imagen nimi>
```

### 1.b Imagen pull
```
# docker pull sajaris/juomapeliback:latest
```

### 2 Kontin luominen
```
# docker run -p 127.0.0.1:8080:8080 -d --rm <Imagen nimi>
```

# backlogit
Tarinat: https://github.com/users/SajariS/projects/5/views/2
Sprintti: https://github.com/users/SajariS/projects/6/views/1

# Yhteystidot

- Karl Tamme
- Sampo Lehtonen
- Sampo Westerholm
- Santeri Sajari, santeri.sajari@gmail.com
