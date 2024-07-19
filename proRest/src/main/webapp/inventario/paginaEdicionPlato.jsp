<%-- 
    Document   : paginaEdicionPlato
    Created on : 20 jun 2024, 16:11:24
    Author     : Propietario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <img src="../img/logo.png" alt="Descripción de la imagen">
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
          <a class="main__item" href="añadirPlato.html">
            <li>Añadir</li>
          </a>
          <a class="main__item" href="eliminarPlato.html">
            <li>Eliminar</li>
          </a>
          <a class="main__item" href="editarPlato.html">
            <li>Editar</li>
          </a>
        </ul>
      </section>
      <section class="main__selectDish" id="main__selectDish">
        <ul class="main__list">
          <li class="main__item--title">Platos</li>
          <a class="main__item" href="añadirPlato.html">
            <li>Añadir</li>
          </a>
          <a class="main__item" href="eliminarPlato.html">
            <li>Eliminar</li>
          </a>
          <a class="main__item" href="editarPlato.html">
            <li>Editar</li>
          </a>
        </ul>
      </section>
    </div>
    <section class="main__section">
      <h1 class="section__title">Editar Plato</h1>
      <form action="#" class="section__form">
        <div class="section__addDish">
          <input type="text" placeholder="Nombre" class="addDish__input">
          <input type="text" placeholder="Categoria" class="addDish__input">
          <input type="text" placeholder="Descripción" class="addDish__input">
          <input type="text" placeholder="Precio" class="addDish__input">
          <input type="file" accept="image/*" class="addDish__img">
        </div>
        <div class="section__view">
          <h2 class="view__title">Vista</h2>
          <div class="view__card">
            <div class="view__img"></div>
            <h2 class="view__dishName">Nombre del Plato</h2>
            <p class="view__dishDescription">Descripción de ingredientes</p>
            <h2 class="view__dishCost">$10.000</h2>
          </div>
        </div>
        <button class="section__addButton">Añadir</button>
      </form>
    </section>
  </main>

  <script src="script.js"></script>
</body>

</html>
