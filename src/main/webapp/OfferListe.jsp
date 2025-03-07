
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Job Offers List</title>
  <style>
    table {
      width: 100%;
      border-collapse: collapse;
    }
    th, td {
      border: 1px solid black;
      padding: 8px;
      text-align: left;
    }
    th {
      background-color: #f2f2f2;
    }
  </style>
</head>
<body>
<h1>Job Offers</h1>

<table>
  <tr>
    <th>ID</th>
    <th>Title</th>
    <th>Description</th>
    <th>Recruiter ID</th>
    <th>Actions</th>
  </tr>
  <c:forEach var="offre" items="${offres}">
    <tr>
      <td>${offre.id}</td>
      <td>${offre.title}</td>
      <td>${offre.description}</td>
      <td>${offre.recruiter}</td>
      <td>
        <a href="jobOffers?action=view&id=${offre.id}">View</a>
        <a href="jobOffers?action=update&id=${offre.id}">Edit</a>
        <a href="jobOffers?action=delete&id=${offre.id}" onclick="return confirm('Are you sure you want to delete this job offer?');">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>

<a href="jobOfferForm.jsp">Create New Job Offer</a>
</body>
</html>
