package org.example.tasks;

import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;

import static org.example.userinterfaces.autenticacion.*;

public class CrearPagina implements Task {

    public static CrearPagina nueva() {
        return Tasks.instrumented(CrearPagina.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        // 1. Esperar a que el botón "Añadir página" esté presente (máximo 10 segundos)
        for (int i = 0; i < 20; i++) {
            if (BTN_AGREGAR_PAGINA.resolveFor(actor).isPresent()) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // 2. Hacer clic en el botón "Añadir página" usando Javascript
        WebElement btnAgregar = BTN_AGREGAR_PAGINA.resolveFor(actor);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnAgregar);

        // 3. Esperar a que el campo de título de la página esté visible (máximo 10 segundos)
        for (int i = 0; i < 20; i++) {
            if (INPUT_TITULO_PAGINA.resolveFor(actor).isVisible()) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // 4. Generar un nombre único para la página
        String nombrePagina = "Página Camilo " + UUID.randomUUID().toString().substring(0, 8);

        // 5. Escribir el título en la página
        actor.attemptsTo(
                Click.on(INPUT_TITULO_PAGINA),
                Enter.theValue(nombrePagina).into(INPUT_TITULO_PAGINA)
        );

        // Esperar 3 segundos para ver la página creada
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
