<%@ page session="true" %>

<header class="header">
            <%
                //Usuario usuario = (Usuario) session.getAttribute("usuario");
                //String nombreUsuario = usuario.getNombreUsuario();
                //int rolUsuario = usuario.getRol();
                int rolUsuario = 1;
            %>
          <div class="hamburger-menu" id="hamburger-menu">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
              <path
                d="M0 96C0 78.3 14.3 64 32 64H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32C14.3 128 0 113.7 0 96zM0 256c0-17.7 14.3-32 32-32H416c17.7 0 32 14.3 32 32s-14.3 32-32 32H32c-17.7 0-32-14.3-32-32zM448 416c0 17.7-14.3 32-32 32H32c-17.7 0-32-14.3-32-32s14.3-32 32-32H416c17.7 0 32 14.3 32 32z" />
            </svg>
          </div>
          <div class="mobile-nav" id="mobile-nav">
            <ul class="mobile-nav__list">
                <li class="mobile-nav__item"><a href="/proRest/main.jsp" class="menu-link">Inicio</a></li>
              <li class="mobile-nav__item"><a class="menu-link">Nosotros</a></li>
              <li class="mobile-nav__item"><a class="menu-link">Ver Carta</a></li>
              <%
                StringBuilder sb = new StringBuilder();
               
                if (rolUsuario >= 1 && rolUsuario <= 4) {
                    
                    sb.append("<li class='mobile-nav__item'><p class='menu-link'>Reservas</p>"
                    + "<ul class='navbar__sublist'>"
                    + "<li class='navbar__subitem'><a href='/proRest/reservas/hacerReserva.jsp'>Hacer Reserva</a></li>");
                    if (rolUsuario <= 3) {
                        sb.append("<li class='navbar__subitem'><a href='index.jsp'>Administrar Reservas</a></li>");
                    }
                    sb.append("</ul>"
                    + "</li>");
                    
                    
                    if (rolUsuario <= 3){
                        sb.append("<li class='mobile-nav__item'><p class='menu-link'>Pedido</p>"
                        + "<ul class='navbar__sublist'>");
                        sb.append("<li class='navbar__subitem'><a href='index.jsp'>Tomar Pedido</a></li>"
                        + "<li class='navbar__subitem'><a href='index.jsp'>Administrar Pedidos</a></li>");
                        sb.append("</ul>"
                        + "</li>");
                    }

                    if (rolUsuario <= 2) {
                        sb.append("<li class='mobile-nav__item'><a class='menu-link'>Administrar Carta</a></li>");
                        sb.append("<li class='mobile-nav__item'><p class='menu-link'>Administrar Platos</p>"
                        + "<ul class='navbar__sublist'>");
                        sb.append("<li class='navbar__subitem'><a href='/proRest/paginaPlatos?opcion=categoria'>Categorias</a></li>"
                        + "<li class='navbar__subitem'><a href='/proRest/paginaPlatos?opcion=plato'>Platos</a></li>");
                        sb.append("</ul>"
                        + "</li>");
                        
                        sb.append("<li class='mobile-nav__item'><p class='menu-link'>Administrar Usuarios</p>"
                        + "<ul class='navbar__sublist'>");
                        sb.append("<li class='navbar__subitem'><a href='/proRest/paginaUsuarios?opcion=cliente'>Clientes</a></li>"
                        + "<li class='navbar__subitem'><a href='/proRest/paginaUsuarios?opcion=empleado'>Empleados</a></li>");
                        if (rolUsuario == 1){
                            sb.append("<li class='navbar__subitem'><a href='/proRest/paginaUsuarios?opcion=administrador'>Administradores</a></li>");
                        }
                        sb.append("</ul>"
                        + "</li>");
                    }
      
                }

                out.print(sb.toString());
            %>

            </ul>
          </div>
          <div class="header__navigation">
            <figure class="navigation__logo">
              <img src="${pageContext.request.contextPath}/img/logo.png" alt="Descripción de la imagen">
              <figcaption class="logo__name">Bocado Escencial</figcaption>
            </figure>
            
          </div>
          <div class="header__actions">
              <p class="header__rol">
                  <%
                      out.print(rolUsuario);
                  %>
              </p>
            <div class="user__icon show-icon" id="logUser__icon">
              <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                <path
                  d="M224 256A128 128 0 1 0 224 0a128 128 0 1 0 0 256zm-45.7 48C79.8 304 0 383.8 0 482.3C0 498.7 13.3 512 29.7 512H418.3c16.4 0 29.7-13.3 29.7-29.7C448 383.8 368.2 304 269.7 304H178.3z" />
              </svg>
            </div>
            <div class="logOut" id="logOut">
              <a class="logOut__button" href="autenticacionUsuario?accion=cerrarSesion">Cerrar Sesión</a>
            </div>
          </div>

        </header>
