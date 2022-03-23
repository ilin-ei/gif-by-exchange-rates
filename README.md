«апуск приложени€ через Docker:

 - выполните gradle build из IDE;
 - выполните docker build --tag gif . в директории с Dockerfile
 - запустите приложение docker run -p8080:8080 gif
 
 
–абота с приложением:

 - запустите GifdemoApplication
 - пропишите в адресной строке localhost:8080/currencyExchanges/rates

 ƒл€ изменени€ валюты, сравниваемой с USD, подставьте одно значение из currency codes файла application.properties в currency