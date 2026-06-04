package org.example.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class EliminarPaginaUI extends PageObject {

    // Cuerpo principal de la aplicación Notion (punto de partida de la interacción)
    public static final Target BODY_NOTION =
            Target.the("cuerpo principal de Notion")
                    .located(By.cssSelector("body.notion-body"));

    // Botón de búsqueda (lupa) de la barra lateral de Notion
    public static final Target BTN_BUSCAR =
            Target.the("botón Buscar (lupa) de la barra lateral")
                    .located(By.xpath("//div[@role='button' and @aria-label='Buscar']"));

    // Campo de texto del buscador de Notion (quickFind / search input)
    public static final Target INPUT_BUSCAR =
            Target.the("campo de búsqueda de Notion")
                    .located(By.xpath("//input[@placeholder or @aria-label='Buscar' or contains(@class,'search')][1]"));

    // Primer resultado de búsqueda en el panel de quickFind
    public static final Target PRIMER_RESULTADO_BUSQUEDA =
            Target.the("primer resultado de búsqueda")
                    .located(By.xpath("(//div[@data-inp-target='sidebar-page-item'] | //a[contains(@href,'/p/')])[1]"));

    // Ítems de página en la barra lateral
    public static final Target ITEMS_PAGINA =
            Target.the("ítems de página en la barra lateral")
                    .located(By.xpath("//div[@data-inp-target='sidebar-page-item']"));

    // Ítem de página específico por índice
    public static final Target ITEM_PAGINA_INDEX =
            Target.the("ítem de página #{0}")
                    .locatedBy("(//div[@data-inp-target='sidebar-page-item'])[{0}]");

    // Botón "..." específico por índice
    public static final Target BTN_MENU_PAGINA_INDEX =
            Target.the("botón de menú de la página #{0}")
                    .locatedBy("(//div[contains(@class,'notion-sidebar-page-menu')])[{0}]");

    // Opción "Eliminar" dentro del menú contextual desplegado
    public static final Target OPCION_ELIMINAR =
            Target.the("opción Eliminar del menú contextual")
                    .located(By.xpath("//div[@role='presentation' and contains(@class, 'xuxw1ft') and normalize-space(.)='Mover a la Papelera']"));

    // Botón de confirmación de eliminación (si Notion pide confirmar)
    public static final Target BTN_CONFIRMAR_ELIMINAR =
            Target.the("botón de confirmación de eliminación")
                    .located(By.xpath("//*[normalize-space(text())='Eliminar' or normalize-space(text())='Delete'][last()]"));
}
