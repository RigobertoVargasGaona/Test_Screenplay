package org.example.tasks;

import org.example.utils.hooks.SesionVariable;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.models.CredencialesInicioSesion;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.example.userinterfaces.autenticacion.*;

public class Autenticarse implements Task {

    private List<CredencialesInicioSesion> credenciales;
    public Autenticarse(List<CredencialesInicioSesion> credenciales) {
        this.credenciales = credenciales;
    }


    public static Autenticarse aute(List<CredencialesInicioSesion> credenciales) {
        return Instrumented.instanceOf(Autenticarse.class)
                .withProperties(credenciales);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        String originalWindow = driver.getWindowHandle();
        String usuario = credenciales.get(0).getUsuario();
        String clave = credenciales.get(0).getClave();

        actor.attemptsTo(
                Click.on(BTN_GOOGLE)
        );

        // Esperar a que se abra la nueva ventana/popup (máximo 5 segundos)
        for (int i = 0; i < 10; i++) {
            if (driver.getWindowHandles().size() > 1) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Cambiar el foco a la nueva ventana/popup de Google
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Esperar a que la página de Google cargue (máximo 7 segundos de forma dinámica)
        for (int i = 0; i < 14; i++) {
            if (INPUT_EMAIL_GOOGLE.resolveFor(actor).isVisible() || BTN_CUENTA_GOOGLE.of(usuario).resolveFor(actor).isVisible()) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Si se muestra el campo para ingresar correo de Google
        if (INPUT_EMAIL_GOOGLE.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Click.on(INPUT_EMAIL_GOOGLE),
                    Enter.theValue(usuario).into(INPUT_EMAIL_GOOGLE),
                    Click.on(BTN_SIGUIENTE_GOOGLE)
            );
        } 
        // Si ya está guardada e inicia desde el selector de cuentas
        else if (BTN_CUENTA_GOOGLE.of(usuario).resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Click.on(BTN_CUENTA_GOOGLE.of(usuario))
            );
        }

        // Esperar a que el campo de contraseña sea visible (máximo 5 segundos)
        for (int i = 0; i < 10; i++) {
            if (INPUT_CLAVE_GOOGLE.resolveFor(actor).isVisible()) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Si el campo de contraseña está visible, ingresarla y dar Siguiente
        if (INPUT_CLAVE_GOOGLE.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Click.on(INPUT_CLAVE_GOOGLE),
                    Enter.theValue(clave).into(INPUT_CLAVE_GOOGLE),
                    Click.on(BTN_SIGUIENTE_PASSWORD_GOOGLE)
            );

            // Esperar un momento a que la ventana de Google se cierre y procese
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Regresar a la ventana original de Notion
        driver.switchTo().window(originalWindow);

        theActorInTheSpotlight().remember(SesionVariable.usuario.toString(), usuario
        );
    }
}