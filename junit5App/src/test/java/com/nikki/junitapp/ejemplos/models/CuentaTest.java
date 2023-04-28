package com.nikki.junitapp.ejemplos.models;

import com.nikki.junitapp.ejemplos.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.math.BigDecimal;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS);
class CuentaTest {
    Cuenta cuenta;

    @BeforeEach
    void initMetodoTest(){
        cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        System.out.println("Iniciando el metodo");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finalizando el metodo de prueba.");
    }

    @BeforeAll// static le pertenece a la clase y no a la instancia
    static void beforeAll() {
        System.out.println("Inicializando el test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando el test ");
    }

    @Test
    @DisplayName("probando el nombre de la centa corriente!")
    void testNombreCuenta(){
//      cuenta.setPersona("Andres");
        String esperado = "Andres";
        String real = cuenta.getPersona();
//      Assertions.assertEquals(esperado, real);
        assertNotNull(real, () -> "la cuenta no puede ser nula");//mensajes en caso de error
        assertEquals(esperado, real, "el nombre de la cuenta no es el que se esperaba: se esperaba " + esperado
        + "sin embargo fue " + real);
        assertTrue(real.equals(esperado), "nombre cuenta esperada debe ser igual a la real");
    }

    @Test
    @DisplayName("probando el saldo de la cuenta corriente!, mayor que cero, valor esperado")
    void testSaldoCuenta(){
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @DisplayName("testeando referencias qe sean iguales con el metodo equals")
    void testReferenciaCuenta(){
        cuenta = new Cuenta("John Doe", new BigDecimal("8999.9999"));
        Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal("8999.9999"));

//      assertNotEquals(cuenta2, cuenta);
        assertEquals(cuenta2, cuenta);

    }

    @Test
    void testDebitoCuenta(){
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCreditoCuenta(){
        cuenta.credito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testDineroInsuficienteExceptionCuenta(){
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1500));
        });
        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente";
        assertEquals(esperado, actual);
    }

    @Test
    void testTransferirDineroCuentas(){
        Cuenta cuenta1 = new Cuenta("Jhon Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1500.8989"));
        Banco banco = new Banco();
        banco.setNombre("Banco del estado");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
        assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
        assertEquals("3000", cuenta1.getSaldo().toPlainString());
    }

    @Test
    @Disabled //deshabilitar el metodo
    @DisplayName("probando relaciones entre las cuentas y el banco con assertAll")
    void testRelacionBancoCuentas(){
        fail();
        Cuenta cuenta1 = new Cuenta("Jhon Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal("1500.8989"));
        Banco banco = new Banco();
        banco.addCuentas(cuenta1);
        banco.addCuentas(cuenta2);

        banco.setNombre("Banco del estado");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
        assertAll(
                () -> {assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());},
                () -> {assertEquals("3000", cuenta1.getSaldo().toPlainString());},
                () -> {assertEquals(2, banco.getCuentas().size());},
                () -> {assertEquals("Banco del estado", cuenta1.getBanco().getNombre() );},
                () -> {assertEquals("Andres", banco.getCuentas().stream()
                        .filter(c -> c.getPersona().equals("Andres"))
                        .findFirst()
                        .get().getPersona());},
                () -> {assertTrue(banco.getCuentas().stream()
                        .anyMatch(c -> c.getPersona().equals("Andres")));}
        );
    }


    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testSoloWindows() {

    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testSoloLinuxMac() {

    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void testNoWindows() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testJdk8() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_15)
    void testJdk15() {
    }

    @Test
    @DisabledOnJre(JRE.JAVA_15)
    void testNoJdk15() {
    }

    @Test
    void testImprimirSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((k, v) -> System.out.println( k + "  : " + v));
    }

    @Test
    @EnabledIfSystemProperty(named = "java.version", matches = "18")
    void testJavaVersion() {
    }

    @Test
    @DisabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void testNoArquitectura64() {
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
    void testArquitectura32() {
    }

    @Test
    @EnabledIfSystemProperty(named = "user.name", matches = "nikki")
    void testUserName() {
    }

    @Test
    @EnabledIfSystemProperty(named = "ENV", matches = "dev")
    void testDev() {
    }

    
}