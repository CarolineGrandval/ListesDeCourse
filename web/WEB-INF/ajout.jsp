<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cgrandval2021
  Date: 19/06/2021
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.2/css/bulma.min.css">
<script src="https://kit.fontawesome.com/573f861441.js" crossorigin="anonymous"></script>

<html>
<head>
    <title>Nouvelle liste</title>
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
                <h2 class="subtitle is-2 has-text-centered	">Nouvelle liste</h2>
            </article>
        </div>
    </div>

    <div class="tile is-ancestor">
        <div class="tile is-vertical is-3">
        </div>
        <div class="tile is-vertical is-6">
            <div class="tile">
                <div class="tile is-parent is-vertical">
                    <article class="tile is-child">

                        <form action="${pageContext.request.contextPath}/new" method="post">

                            <div class="field is-horizontal">
                                <div class="field-label is-normal">
                                    <label class="label has-text-left" for="liste">Nom de la liste : </label>
                                </div>
                                <div class="field-body">
                                    <div class="field">
                                        <p class="control">
                                            <input class="input" type="text" id="liste" name="nomListe"
                                                   placeholder="le nom de votre liste"
                                                   value="${nomNouvelleListe}">
                                        </p>
                                    </div>
                                </div>
                            </div>

                            <c:forEach var="a" items="${listeArticles}">
                                <div class="block">
                                    <p>${a}</p></div>
                            </c:forEach>

                            <div class="field is-horizontal">
                                <div class="field-label is-normal">
                                    <label class="label has-text-left" for="article">Article : </label>
                                </div>
                                <div class="field-body">
                                    <div class="field">
                                        <p class="control is-expanded has-icons-left">
                                            <input class="input" type="text" placeholder="article à ajouter"
                                                   id="article" name="nomArticle1">
                                            <span class="icon is-small is-left"> <i class="fas fa-plus"></i> </span>
                                        </p>

                                    </div>
                                    <input type="submit" value="Ajouter" class="is-light">
                                </div>
                            </div>


                            <div class="control ">
                                <input class="button is-primary" type="submit" name="save" value="Enregistrer">
                            </div>

                        </form>

                    </article>
                </div>
            </div>
        </div>
    </div>

    <div class="tile is-ancestor">
        <div class="tile is-parent is-3">
        </div>
        <div class="tile is-parent is-6">
            <article class="tile is-child box is-shadowless has-text-centered">
                <a href="accueil"><span class="icon is-large has-text-primary">
                    <i class="fas fa-home fas fa-2x" title="accueil"></i>
                </span></a>
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
