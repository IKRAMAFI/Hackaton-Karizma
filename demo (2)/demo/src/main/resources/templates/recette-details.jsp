<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="header.jsp" %>

<div class="container">
    <h2>Détails de la recette</h2>
    <c:if test="${recette ne null}">
        <p>ID: ${recette.id}</p>
        <p>Nom: ${recette.nom}</p>
        <!-- Add other details based on your model -->
    </c:if>
</div>

<%@ include file="footer.jsp" %>