**Vous avez été embauché en tant que développeur chez FridgeCraft, un fabricant de réfrigérateurs qui se targue de fournir des réfrigérateurs de qualité artisanale.**

FridgeCraft a décidé d’adopter la tendance des réfrigérateurs « intelligents », et c’est votre mission de créer le logiciel à intégrer dans le nouveau modèle de test.

### Instructions

L’équipe de recherche et développement vous a fourni les exigences suivantes pour la première itération du modèle de test :

1. Suivre les articles placés dans le réfrigérateur et ceux qui en sont sortis.
2. Lorsqu’un article est ajouté, le réfrigérateur doit capturer les informations concernant cet article :
   - Nom de l’article
   - Date d’expiration
   - Horodatage du moment où il a été ajouté
3. Lorsque le réfrigérateur est ouvert, les articles déjà à l’intérieur voient leur date de péremption se dégrader :
   - De 1 heure (si le réfrigérateur est scellé)
   - De 5 heures (si le réfrigérateur est ouvert)
4. Fournir un affichage formaté pour visualiser le contenu et le temps restant avant expiration :
   - Les articles expirés sont affichés en premier avec : `"EXPIRÉ : $item.name"`
   - Les articles non expirés sont affichés ensuite avec : `"$item.name : n jour(s) restant(s)"`
