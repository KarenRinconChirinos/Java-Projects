package com.nikki.junitapp.ejemplos.models;

import com.nikki.junitapp.ejemplos.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS);
class CuentaTest {
    Cuenta cuenta;
    private TestInfo testInfo;
    private TestReporter testReporter;


    @BeforeEach
    void initMetodoTest(TestInfo testInfo, TestReporter testReporter){
        System.out.println("Iniciando el metodo");
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry(" ejecutando: " + testInfo.getDisplayName() + " " + testInfo.getTestMethod().get().getName()
                + " con las etiquetas " + testInfo.getTags());

        cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
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

    @Tag("cuenta")
    @Nested
    @DisplayName("probando  atributos de la cuenta corriente")
    class CuentaTestNombreSaldo{
        @Test
        @DisplayName("el nombre de la centa corriente!")
        void testNombreCuenta(){
            testReporter.publishEntry(testInfo.getTags().toString());
            if(testInfo.getTags().contains("cuenta")){
                testReporter.publishEntry("hacer algo con la etiqueta cuenta");
            }
            //cuenta.setPersona("Andres");
            String esperado = "Andres";
            String real = cuenta.getPersona();
            //Assertions.assertEquals(esperado, real);
            assertNotNull(real, () -> "la cuenta no puede ser nula");//mensajes en caso de error
            assertEquals(esperado, real, "el nombre de la cuenta no es el que se esperaba: se esperaba " + esperado
                    + "sin embargo fue " + real);
             assertTrue(real.equals(esperado), "nombre cuenta esperada debe ser igual a la real");
        }

        @Test
        @DisplayName("el saldo de la cuenta corriente!, mayor que cero, valor esperado")
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
    }

    @Nested
    class CuentaOperacionesTest{

        @Tag("cuenta")
        @DisplayName("Probando debito cuenta repetir") //titulo principal y los otros sonsub
        //@RepeatedTest(value = 5, name = "{displayName}Repeticion numero {currentRepetition} de {totalRepetitions}")
        @RepeatedTest(value = 5, name = "Repeticion numero {currentRepetition} de {totalRepetitions}")
        void testDebitoCuenta(RepetitionInfo info){
            if (info.getCurrentRepetition() == 3){
                System.out.println("Estamos en la repticion " + info.getCurrentRepetition());
            }
            cuenta.debito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(900, cuenta.getSaldo().intValue());
            assertEquals("900.12345", cuenta.getSaldo().toPlainString());
        }

        @Test
        @Tag("cuenta")
        void testCreditoCuenta(){
            cuenta.credito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(1100, cuenta.getSaldo().intValue());
            assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
        }

        @Tag("cuenta")
        @Tag("banco")
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
    }



    @Test
    @Tag("cuenta")
    @Tag("error")
    void testDineroInsuficienteExceptionCuenta(){
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1500));
        });
        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente";
        assertEquals(esperado, actual);
    }



    @Test
    @Tag("cuenta")
    @Tag("banco")
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

    @Nested
    class SistemaOperativoTest{
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
    }

    @Nested
    class JavaVersionTest{
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
    }

    @Nested
    class SistemPropertiesTest{
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
        @EnabledIfSystemProperty(named = "user.name", matches = "cabal")
        void testUserName() {
        }

        @Test
        @EnabledIfSystemProperty(named = "ENV", matches = "dev")
        void testDev() {
        }

    }

    @Nested
    class VariableAmbienteTest{
        @Test
        void imprimirVariablesAmbiente () {
            Map<String, String> getenv = System.getenv();
            getenv.forEach((k, v) -> System.out.println(k + " = " + v));
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "ProgramFiles", matches = "C:/Program Files")
        void testJavaHome() {
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "8")
        void testProcesadores() {
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "ENVIROMENT", matches = "dev")
        void testEnviroment() {
        }

        @Test
        @DisabledIfEnvironmentVariable(named = "ENVIROMENT", matches = "dev")
        void testNoEnviroment() {
        }
    }



    @Test
    @DisplayName("saldo de la cuenta corriente cuando este en el ambiente dev!")
    void testSaldoCuentaDev(){
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumeTrue(esDev);
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @DisplayName("saldo de la cuenta corriente cuando este en el ambiente dev!")
    void testSaldoCuentaDev2(){
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumingThat(esDev, () -> {
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        });
    }

    @Tag("param")
    @Nested
    class PruebasParametrizada{

        @Tag("param")
        @ParameterizedTest(name =  "numero{index} ejecutando con valor {0} - {argumentsWithNames}")
        @ValueSource(strings = {"100", "200", "300", "500", "700", "1000"})
        void testDebitoCuentaValueSource(String monto){
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue( cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name =  "numero{index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"1,100", "2,200", "3,300", "4,500", "5,700", "6,1000"})
        void testDebitoCuentaCsvSource(String index, String monto){
            System.out.println(index + " -> " + monto);
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue( cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }



        @ParameterizedTest(name =  "numero{index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"200,100, Jhon, Andres", "250,200, Pepe, Pepe", "300,300, Juan, Juana", "400,500, Carlos, Carlos", "750,700, Andrea, Andrea", "1000,1000, Mario, Mar"})
        void testDebitoCuentaCsvSource2(String saldo, String monto, String esperado, String actual){
            System.out.println(saldo + " -> " + monto);
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));
            cuenta.setPersona(esperado);
            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado, actual);
            assertTrue( cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name =  "numero{index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources =  "/data.csv")
        void testDebitoCuentaCsvFileSource(String monto){
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue( cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name =  "numero{index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources =  "/data2.csv")
        void testDebitoCuentaCsvFileSource2(String saldo, String monto, String esperado, String actual){
            cuenta.debito(new BigDecimal(monto));
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.setPersona(esperado);

            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado, actual);

            assertTrue( cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }
    }

    @Tag("param")
    @ParameterizedTest(name =  "numero{index} ejecutando con valor {0} - {argumentsWithNames}")
    @MethodSource("montoList")
    void testDebitoCuentaMethodSource(String monto){
        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue( cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    static List<String> montoList(){
        return Arrays.asList("100", "200", "300", "500", "700", "1000");
    }


    @Nested
    @Tag("timeout")
    class EjemploTimeoutTest{
        @Test
        @Timeout(3)
        void pruebaTimeout() throws InterruptedException {
            TimeUnit.SECONDS.sleep(1);
        }

        @Test
        @Timeout(value = 2000, unit = TimeUnit.MILLISECONDS)
        void pruebaTimeout2() throws InterruptedException {
            TimeUnit.MILLISECONDS.sleep(1100);
        }

        @Test
        void testTimeoutAssertions() {
            assertTimeout(Duration.ofSeconds(5), ()->{
                TimeUnit.MILLISECONDS.sleep(5500);
            });
        }
    }
    

}