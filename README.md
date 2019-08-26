# ServerManagement

Classe Connection : modèle qui représente chaque ligne de connection dans le fichier.

Classe ServerManager : contient les méthodes :

* void showConnections() : afficher la liste des connexions.

* List<String> getListServersConnectedTo(String target) : la liste des serveurs qui ont été connectés à un serveur donné durant cette heure

* List<String> getListServersConnectedFrom(String source) : la liste des serveurs auxquels un serveur donné s'est connecté durant cette heure.

* String getTopServer() : le serveur qui a généré le plus de connections durant cette heure.


Test unitaire : Classe AppTest dévelopé avec JUNIT contient les différents cas de tests.
