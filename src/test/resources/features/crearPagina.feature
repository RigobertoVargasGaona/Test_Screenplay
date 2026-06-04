# language: es
# author: Rigoberto Vargas

Característica: Crear página
  Como usuario autenticado
  quiero crear una nueva página en Notion
  para poder organizar mi contenido

  @crearPagina
  Escenario: Verificar creación exitosa de una página en Notion
    Dado que el usuario está autenticado en la aplicación
      | usuario                       | clave     |
      | vargasalfonsocamilo@gmail.com | Test2026. |
    Cuando el usuario crea una nueva página
    Entonces la página debería haberse creado correctamente
