<%--
  Created by IntelliJ IDEA.
  User: cgrandval2021
  Date: 19/06/2021
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.2/css/bulma.min.css">
<script src="https://kit.fontawesome.com/573f861441.js" crossorigin="anonymous"></script>

<html>
<head>
    <title>Accueil</title>
</head>
<body>

<header>
    <div class="tile is-ancestor">
        <div class="tile is-parent is-3">
        </div>
        <div class="tile is-parent is-6">
            <article class="tile is-child box">
                <h1 class="title is-1 has-text-centered">Courses</h1>
            </article>
        </div>
    </div>
</header>

<main>
    <div class="tile is-ancestor">
        <div class="tile is-parent is-3">
        </div>
        <div class="tile is-parent is-6">
            <article class="tile is-child box  is-shadowless">
                <h2 class="subtitle is-2 has-text-centered">Listes prédéfinies</h2>
            </article>
        </div>

    </div>

    <div class="tile is-ancestor">
        <div class="tile is-vertical is-3">
        </div>
        <div class="tile is-vertical is-6">
            <div class="tile">
                <div class="tile is-parent is-vertical">


                    <c:forEach var="listeEnCours" items="${listeDesListes}">

                        <article class="tile is-child notification is-primary">

                            <div class="tile is-ancestor">
                                <div class="tile is-parent">
                                    <article class="tile is-child box notification is-primary is-shadowless">
                                        <h3 class="subtitle is-4">${listeEnCours.nom}</h3>
                                    </article>
                                    <article class="tile is-child box is-2 notification is-primary is-shadowless ">
                                        <a href="articles?liste=${listeEnCours.idListe}"><i
                                                class="fas fa-shopping-cart is-pulled-right	fas fa-2x" title="accéder au panier"></i></a>
                                    </article>
                                    <article class="tile is-child box is-2 notification is-primary is-shadowless">
                                        <a href="supp?liste=${listeEnCours.idListe}"><i
                                                class="fas fa-trash is-pulled-right	fas fa-2x" title="supprimer la liste"></i></a>
                                    </article>
                                </div>
                            </div>

                        </article>

                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <div class="tile is-ancestor">
        <div class="tile is-parent is-3">
        </div>
        <div class="tile is-parent is-6">
            <article class="tile is-child box is-shadowless has-text-centered">
                <a href="new"><span class="icon is-large has-text-primary"><i class="fas fa-plus-circle  fas fa-2x " title="ajouter"></i></span></a>
            </article>
        </div>
    </div>


</main>

<footer>
    <div class="tile is-ancestor">
        <div class="tile is-parent is-3">
        </div>
        <div class="tile is-parent is-6">
            <article class="tile is-child box is-shadowless">
                <p class="has-text-centered">Caroline G.</p>
            </article>
        </div>
    </div>
</footer>
</body>
</html>
