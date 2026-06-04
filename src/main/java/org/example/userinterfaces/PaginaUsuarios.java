package org.example.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaUsuarios {
    public static  final Target BOTON_MODULO_USUARIOS = Target.the("boton para ir al modulo de productos")
            .located(By.id("users-desktop-aside-button"));

    public static final Target BOTON_CREAR_USUARIO = Target.the("Boton para crear producto")
            .located(By.id("create-button"));

    public static final Target MENU_ROLES = Target.the("menu de roles")
            .located(By.id("roles-menu"));

    public static final Target OPCION_MENU_ROLES = Target.the("opcion dentro del menu de roles")
            .located(By.id("roles-menu-1-option"));

    public static final Target CAMPO_NOMBRE = Target.the("campo para el nombre del usuario")
            .located(By.id("name"));

    public static final Target CAMPO_PRIMER_APELLIDO = Target.the("campo para el primer apellido del usuario")
            .located(By.id("first_surname"));

    public static final Target CAMPO_SEGUNDO_APELLIDO = Target.the("campo para el segundo apellido del usuario")
            .located(By.id("second_surname"));

    public static final Target MENU_CIUDADES = Target.the("menu de ciudades")
            .located(By.id("cities-menu"));

    public static final Target OPCION_MENU_CIUDADES = Target.the("opcion dentro del menu de ciudades")
            .located(By.id("cities-menu-1-option"));

    public static final Target CAMPO_TELEFONO = Target.the("campo para el telefono del usuario")
            .located(By.id("phone"));

    public static final Target CAMPO_EMAIL = Target.the("campo para el correo del usuario")
            .located(By.id("email"));

    public static final Target CAMPO_DIRECCION = Target.the("campo para la direccion del usuario")
            .located(By.id("address"));

    public static final Target BOTON_CONFIRMAR = Target.the("boton para confirmar")
            .located(By.id("confirm-button"));

    public static final Target MENSAJE_DE_CONFIRMACION = Target.the("texto de confimacion que sale en una modal")
            .located(By.id(("confirm-title")));
}
