debtcollector - simple debt manager
============================================================================================================================================

####ABRSTRACT

Simple debt manager that enables you to define a plan with person whose participate.

####AUTHORS

*Nerojan Rajaratnam*

<rajaratnam@et.esiea.fr>

*Quentin Chouleur* 

<chouleur@et.esiea.fr>



####CREDITS

- [font awesome](http://fontawesome.io) - Set of scalable vector icons created by Dave Gandy. licensed under the *SIL OFL 1.1*.

- [Bootstrap](http://getbootstrap.com) - HTML, CSS & JS framwork. *MIT License*.

- [Bootplus](http://aozora.github.io/bootplus/) - Enhanced bootstrap with a google-ish style. *Apache License v2.0*.


####DESCRIPTION

L'application que nous avons réalisée permet de définir des projets avec le montant déboursé pour celui ci. A cela, on rajoute des participants qui ont participé pour le projet avec leur montant. Tout cela pour voir les différentes dépenses de chaques personnes.

L'application dispose de trois IHM, un pour les personnes, un pour les participations et l'autre pour les projects.

Nous avons décidé d'utiliser Spring MVC pour vraiment séparer les parties ainsi que pour structurer notre application. Cela permet aussi d'avoir une vision globale sur notre solution. De plus, Spring MVC nous permet de gérer comme nous le souhaitons nos adresses URL.

Notre choix a été de séparer chaque processus en trois. Les trois processus étant les trois contrôleurs c'est à dire un pour chaque service mis à disposition pour l'utilisateur:

	- Gestion des projets
	- Gestion des utilisateurs
	- Gestion des participations
	
Un projet est défini par:

	- un titre
	- une date
 	- un montant total (dépense)
 
Un utilisateur est défini par:

	- un nom
	- un prénom
	- un email
	
Une partcipation est définie par:

 	- un utilisateur
 	- un montant (sa participation)
 	

Nous pouvons donc créer, modifier ou supprimer un projet et un utilisateur. De plus, nous pouvons rajouter des participants pour un projet défini préalablement. Mais pour créer des participations il faut d'abord avoir créé les utilisateurs.


####Utilisation

Les projets:

![Alt text](/src/main/webapp/resources/screenshots/plans.png?raw=true "Projets")

Création d'un projet:

![Alt text](/src/main/webapp/resources/screenshots/createPlan.png?raw=true "Creation projet")

Les utilisateurs:

![Alt text](/src/main/webapp/resources/screenshots/users.png?raw=true "Utilisateurs")

Création d'un utilisateur:

![Alt text](/src/main/webapp/resources/screenshots/createUser.png?raw=true "Creation utilisateur")

Ajout participation:

![Alt text](/src/main/webapp/resources/screenshots/participation.png?raw=true "Creation participation")

Détail gestion projets:

![Alt text](/src/main/webapp/resources/screenshots/detail-plans.png?raw=true "Gestion des projets")

Détail gestion utilisateur: 

![Alt text](/src/main/webapp/resources/screenshots/detail-users.png?raw=true "Gestion des utilisateurs")


###Spring MVC

« SPRING est effectivement un conteneur dit “ léger ”, c’est-à-dire une infrastructure similaire à un serveur d'applications J2EE. Il prend donc en charge la création d’objets et la mise en relation d’objets par l’intermédiaire d’un fichier de configuration qui décrit les objets à fabriquer et les relations de dépendances entre ces objets. Le gros avantage par rapport aux serveurs d’application est qu’avec SPRING, les classes n’ont pas besoin d’implémenter une quelconque interface pour être prises en charge par le framework (au contraire des serveur d'applications J2EE et des EJBs). C’est en ce sens que SPRING est qualifié de conteneur “ léger ”. »

Spring s’appuie principalement sur l’intégration de trois concepts clés :

l’inversion de contrôle est assurée de deux façons différentes : la recherche de dépendances et l'injection de dépendances
la programmation orientée aspect
une couche d’abstraction.
La couche d’abstraction permet d’intégrer d’autres frameworks et bibliothèques avec une plus grande facilité. Cela se fait par l’apport ou non de couches d’abstraction spécifiques à des frameworks particuliers. Il est ainsi possible d’intégrer un module d’envoi de mails plus facilement.

Source: Wikipedia





