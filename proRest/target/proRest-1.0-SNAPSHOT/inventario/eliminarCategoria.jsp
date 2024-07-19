<%-- 
    Document   : eliminarCategoria
    Created on : 24 jun 2024, 13:10:53
    Author     : Propietario
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/inventario.css">
        
    </head>
    <body>
  <header class="header">
    <div class="hamburger-menu" id="hamburger-menu">
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
        <path
          d="M0 96C0 78.3 14.3 64 32 64H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32C14.3 128 0 113.7 0 96zM0 256c0-17.7 14.3-32 32-32H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32c-17.7 0-32-14.3-32-32zM448 416c0 17.7-14.3 32-32 32H32c-17.7 0-32-14.3-32-32s14.3-32 32-32H416c17.7 0 32 14.3 32 32z" />
      </svg>
    </div>
    <div class="mobile-nav" id="mobile-nav">

      <ul class="mobile-nav__list">
        <li class="mobile-nav__item">Inicio</li>
        <li class="mobile-nav__item">Nosotros</li>
        <li class="mobile-nav__item">Servicios</li>
        <li class="mobile-nav__item">Contacto</li>
      </ul>
    </div>
    <div class="header__navigation">
      <figure class="navigation__logo">
        <img src="${pageContext.request.contextPath}/img/logo.png" alt="Descripción de la imagen">
        <figcaption class="logo__name">Bocado Escencial</figcaption>
      </figure>
      <nav class="navigation__navbar">
        <ul class="navbar__list">
          <li class="navbar__item">Inicio</li>
          <li class="navbar__item">Nosotros</li>
          <li class="navbar__item">Productos</li>
          <li class="navbar__item">Contacto</li>
        </ul>
      </nav>
    </div>
    <div class="header__actions">
      <p class="header__rol">Admin</p>
      <div class="user__icon show-icon" id="logUser__icon">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
          <path
            d="M224 256A128 128 0 1 0 224 0a128 128 0 1 0 0 256zm-45.7 48C79.8 304 0 383.8 0 482.3C0 498.7 13.3 512 29.7 512H418.3c16.4 0 29.7-13.3 29.7-29.7C448 383.8 368.2 304 269.7 304H178.3z" />
        </svg>
      </div>
      <div class="logOut" id="logOut">
        <a class="logOut__button" href="index.html">Cerrar Sesión</a>
      </div>
    </div>

  </header>


  <main class="main">
    <div class="main__menu" id="main__menu">
      <div class="arrow" id="arrow">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 256 512">
          <path
            d="M246.6 278.6c12.5-12.5 12.5-32.8 0-45.3l-128-128c-9.2-9.2-22.9-11.9-34.9-6.9s-19.8 16.6-19.8 29.6l0 256c0 12.9 7.8 24.6 19.8 29.6s25.7 2.2 34.9-6.9l128-128z" />
        </svg>
      </div>
      <section class="main__selectCategory" id="main__selectCategory">
        <ul class="main__list">
          <li class="main__item--title">Categorias</li>
                <a class="main__item" href="agregarCategoria.jsp">
                  <li>Añadir</li>
                </a>
                <a class="main__item" href="eliminarCategoria.jsp">
                  <li>Eliminar</li>
                </a>
                <a class="main__item" href="editarCategoria.jsp">
                  <li>Editar</li>
                </a>

        </ul>
      </section>
      <section class="main__selectDish" id="main__selectDish">
        <ul class="main__list">
          <li class="main__item--title">Platos</li>
          <a class="main__item" href="agregarPlato.jsp">
            <li>Añadir</li>
          </a>
          <a class="main__item" href="eliminarPlato.jsp">
            <li>Eliminar</li>
          </a>
          <a class="main__item" href="editarPlato.jsp">
            <li>Editar</li>
          </a>
        </ul>
      </section>
    </div>
    <section class="main__section">
      <h1 class="section__title">Eliminar categoria</h1>
      <div class="search__container">
        <form class="search__form" id="search-form" action="${pageContext.request.contextPath}/listarCategorias" method="get">
          <input type="text" class="search__input" placeholder="Buscar...">
          <button type="submit" class="search__button">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
              <path
                d="M416 208c0 45.9-14.9 88.3-40 122.7L502.6 457.4c12.5 12.5 12.5 32.8 0 45.3s-32.8 12.5-45.3 0L330.7 376c-34.4 25.2-76.8 40-122.7 40C93.1 416 0 322.9 0 208S93.1 0 208 0S416 93.1 416 208zM208 352a144 144 0 1 0 0-288 144 144 0 1 0 0 288z" />
            </svg>
          </button>
          <input type="submit" value="Listar Categorías" />
        </form>
      </div>
      <div class="edit__container">
        <div class="edit__content">
          <h1 class="category__title">Categorias</h1>
          <ul class="edit__list">

            <%
                List<model.categoria.Categoria> categorias = (List<model.categoria.Categoria>) request.getAttribute("categorias");
                StringBuilder sb = new StringBuilder();

                if (categorias != null) {
                    for (model.categoria.Categoria categoria : categorias) {
                        sb.append("<a class='edit__item' href='inventario/paginaEdicionCategoria.jsp?id=").append(categoria.getId()).append("'>")
                          .append("<li>").append(categoria.getNombreCategoria()).append("</li>")
                          .append("</a>");
                    }
                } else {
                    sb.append("<p>No hay categorías disponibles.</p>");
                }

                out.print(sb.toString());
            %>

            
          </ul>
        </div>
      </div>
    </section>
  </main>



  <div class="modal" id="modal">
    <div class="modal__content">
      <span class="modal__close" id="modal-close">&times;</span>
      <h2 id="modal-title">Nombre del Plato</h2>
      <p id="modal-description">Descripción del Plato</p>
  
      <form action="eliminarCategoria" class="modal__actions" method="post">
          <input type="hidden" id="categoryId" name="categoryId">
          <button type="submit" class="modal__button modal__button--delete" id="modal-delete">Eliminar</button>
        <button type="button" class="modal__button modal__button--cancel" id="modal-cancel">Cancelar</button>
      </form>
    </div>
  </div>

  <script src="${pageContext.request.contextPath}/js/script.js"></script>
  <script src="${pageContext.request.contextPath}/js/modals.js"></script>
  
</body>

</html>