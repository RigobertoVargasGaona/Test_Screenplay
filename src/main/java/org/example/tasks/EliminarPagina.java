package org.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Random;

import static org.example.userinterfaces.EliminarPaginaUI.*;

public class EliminarPagina implements Task {

    public static EliminarPagina alAzar() {
        return Tasks.instrumented(EliminarPagina.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        // 1. Seleccionar el body de Notion (punto de partida de la interacción)
        WebElement body = BODY_NOTION.resolveFor(actor);
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", body);

        // 2. Esperar a que el botón Buscar (lupa) esté disponible en la barra lateral
        for (int i = 0; i < 20; i++) {
            if (BTN_BUSCAR.resolveFor(actor).isPresent()) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // 3. Hacer clic en el botón Buscar (lupa) para abrir el panel de búsqueda
        WebElement btnBuscar = BTN_BUSCAR.resolveFor(actor);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnBuscar);

        // 4. Esperar a que el panel de búsqueda / quickFind se abra
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 5. Presionar Escape para cerrar el panel de búsqueda y volver a la barra lateral
        //    (solo necesitábamos confirmar que la barra lateral está cargada y activa)
        ((JavascriptExecutor) driver).executeScript(
                "document.dispatchEvent(new KeyboardEvent('keydown', {key: 'Escape', bubbles: true}));"
        );

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 6. Esperar a que haya páginas disponibles en la barra lateral
        for (int i = 0; i < 20; i++) {
            if (!ITEMS_PAGINA.resolveAllFor(actor).isEmpty()) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        int totalPaginas = ITEMS_PAGINA.resolveAllFor(actor).size();
        int indiceAzar = new Random().nextInt(totalPaginas) + 1; // XPath es base 1

        // 7. Hacer hover sobre una página seleccionada al azar
        WebElement itemSeleccionado = ITEM_PAGINA_INDEX.of(String.valueOf(indiceAzar)).resolveFor(actor);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].dispatchEvent(new MouseEvent('mouseover', {bubbles: true}));",
                itemSeleccionado
        );

        // 8. Esperar a que el botón de menú (tres puntos) sea visible
        net.serenitybdd.screenplay.targets.Target btnMenuAzar = BTN_MENU_PAGINA_INDEX.of(String.valueOf(indiceAzar));
        for (int i = 0; i < 10; i++) {
            if (btnMenuAzar.resolveFor(actor).isPresent()) {
                break;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // 9. Hacer clic en el botón "..." usando JavaScript para evitar problemas de visibilidad
        WebElement btnMenu = btnMenuAzar.resolveFor(actor);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnMenu);

        // 10. Esperar a que aparezca la opción "Eliminar" en el menú contextual
        for (int i = 0; i < 10; i++) {
            if (OPCION_ELIMINAR.resolveFor(actor).isPresent()) {
                break;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // 11. Hacer clic en la opción "Eliminar"
        actor.attemptsTo(
                Click.on(OPCION_ELIMINAR)
        );

        // 12. Esperar 2 segundos para que Notion procese la eliminación
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
