# language: es
# author: Rigoberto Vargas

Característica: Eliminar página
  Como usuario autenticado
  quiero eliminar una página en Notion
  para poder gestionar mi contenido

  @eliminarPagina
  Escenario: Verificar eliminación exitosa de una página en Notion
    Dado que el usuario está autenticado para eliminar una página
      | usuario                       | clave     |
      | vargasalfonsocamilo@gmail.com | Test2026. |
    Cuando el usuario elimina la primera página disponible
    Entonces la página debería haberse eliminado correctamente
