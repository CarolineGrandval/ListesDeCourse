<%--
  Created by IntelliJ IDEA.
  User: cgrandval2021
  Date: 19/06/2021
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.2/css/bulma.min.css">
<script src="https://kit.fontawesome.com/573f861441.js" crossorigin="anonymous"></script>
<html>
<head>
    <title>Panier</title>
</head>
<body>
<header>
    <h1>Courses</h1>
</header>

<main>

    <div class="tile is-ancestor">
        <div class="tile is-parent is-3">
        </div>
        <div class="tile is-parent is-6">
            <article class="tile is-child box  is-shadowless">
                <h2 class="subtitle is-2">Votre panier</h2>
                <p class="subtitle is-3	">${liste.nom}</p>
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
                        <form class="form" action="${pageContext.request.contextPath}/articles" method="post">
                            <c:forEach var="art" items="${listeArticles}">
                                <div class="field">
                                    <div class="control">
                                        <label class="checkbox">
                                            <input type="checkbox" id="article" name="bouton" value="${art.id}"
                                                   } ${art.coche==true?"checked":"" } >
                                                ${art.nom}</label>
                                    </div>
                                </div>
                            </c:forEach>

                            <input class="button is-primary" type="submit" value="Valider">
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
            <article class="tile is-child box">
                <a href="accueil"><i class="fas fa-home"></i></a>
            </article>
        </div>
    </div>


</main>

<footer>Caroline G.</footer>
</body>
</html>
